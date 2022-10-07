package com.example.yuldshop.controller.rescontroller;

import com.example.yuldshop.model.Customer;
import com.example.yuldshop.model.DTO.CustomerDTO;
import com.example.yuldshop.model.DTO.RoleDTO;
import com.example.yuldshop.model.DTO.UserDTO;
import com.example.yuldshop.model.LocationRegion;
import com.example.yuldshop.model.User;
import com.example.yuldshop.service.LocationRegion.ILocationRegionService;
import com.example.yuldshop.service.customer.ICustomerService;
import com.example.yuldshop.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class ResCustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ILocationRegionService locationRegionService;
    @Autowired
    private IUserService userService;

    private String getPrincipal(){
        String username ="";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            username = ((UserDetails) principal).getUsername();
            return username;
        }
        return username;
    }

    @GetMapping
    public ResponseEntity<List<?>> findAll(){
      List<Customer> customers = (List<Customer>) customerService.findAll();
      List<CustomerDTO> customerDTOS = new ArrayList<>();
      for (Customer customer :customers){
          customerDTOS.add(customer.customerDTO(customer.getLocationRegion()));
      }
      return new ResponseEntity<>(customerDTOS,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
        Customer customer = customerService.findById(id).get();
        CustomerDTO customerDTO = customer.customerDTO(customer.getLocationRegion());
        return new ResponseEntity<>(customerDTO,HttpStatus.OK);
    }
//    @GetMapping("")
//    public ResponseEntity<?>findByIdParam(@RequestParam(name = "id") Long id){
//        Customer customer = customerService.findById(id).get();
//        CustomerDTO customerDTO = customer.customerDTO(customer.getLocationRegion());
//        return new ResponseEntity<>(customerDTO,HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity<?>createNewCustomer(@Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            List<ObjectError> list = bindingResult.getAllErrors();
            List<String> errorlists = new ArrayList<>();
            for (ObjectError objectError : list){
                errorlists.add(objectError.getDefaultMessage());
            }
            return new ResponseEntity<>(errorlists, HttpStatus.BAD_REQUEST);
        }
        if (customerService.existsPhoneNumber(customerDTO.getPhone())){
            return new ResponseEntity<>("Số điện thoại đã tồn tại",HttpStatus.BAD_REQUEST);
        }
        if (customerService.existsEmail(customerDTO.getEmail())){
            return new ResponseEntity<>("Email đã tồn tại",HttpStatus.BAD_REQUEST);
        }

        String userName = getPrincipal();
        User user = userService.getByUsername(userName);
        Customer customer = customerService.findByUser(user);

        LocationRegion locationRegion = customerDTO.getLocationRegion().toLocationRegion();
        LocationRegion newLocationRegion;
        if (customer!=null){
            locationRegion.setId(customer.getLocationRegion().getId());
        }

        newLocationRegion =  locationRegionService.save(locationRegion);

        Customer newCustomer = customerDTO.toCustomer(newLocationRegion.locationRegionDTO());

        newCustomer.setUser(user);
        newCustomer.setLocationRegion(newLocationRegion);
        newCustomer.setId(0L);
        if (customer!=null){
            newCustomer.setId(customer.getId());
        }


        Customer endCustomer =customerService.save(newCustomer);
        return new ResponseEntity<>(endCustomer.customerDTO(endCustomer.getLocationRegion()),HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id,
                                            @Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult){

        if (bindingResult.hasFieldErrors()){
            List<ObjectError> list = bindingResult.getAllErrors();
            List<String> errorlists = new ArrayList<>();
            for (ObjectError objectError : list){
                errorlists.add(objectError.getDefaultMessage());
            }
            return new ResponseEntity<>(errorlists, HttpStatus.BAD_REQUEST);
        }
        Customer customer = customerService.findById(id).get();
        LocationRegion locationRegion =customerDTO.getLocationRegion().toLocationRegion();
        Long locationID = customer.getLocationRegion().getId();
        locationRegion.setId(locationID);
        Customer newCustomer =customerDTO.toCustomer(customerDTO.getLocationRegion());
        customer = newCustomer;
        customer.setId(id);
        customer.setLocationRegion(locationRegion);
        newCustomer=customerService.save(customer);
        return new ResponseEntity<>(newCustomer.customerDTO(newCustomer.getLocationRegion()),HttpStatus.OK);
    }
    @PatchMapping("/deleted/{id}")
    public ResponseEntity<?>deletedCustomer(@PathVariable Long id){
        Customer customer = customerService.findById(id).get();
        customer.setDeleted(true);
        Customer newCustomer =customerService.save(customer);
        CustomerDTO customerDTO = newCustomer.customerDTO(newCustomer.getLocationRegion());
        return new ResponseEntity<>(customerDTO,HttpStatus.OK);
    }
}

package com.example.yuldshop.controller.rescontroller;

import com.example.yuldshop.model.DTO.UserDTO;
import com.example.yuldshop.model.JwtResponse;
import com.example.yuldshop.model.Role;
import com.example.yuldshop.model.User;
import com.example.yuldshop.model.UserPrinciple;
import com.example.yuldshop.service.Role.IRoleService;
import com.example.yuldshop.service.jwt.JwtService;
import com.example.yuldshop.service.user.IUserService;
import com.example.yuldshop.untils.AppUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class ResUserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private AppUtils appUtils;

    @GetMapping("/{userName}")
    public ResponseEntity<?>findByUserName(@PathVariable String userName){
        if (userService.existsByUserName(userName)){
           UserDTO userDTO = userService.findUserDTOByUsername(userName).get();
           String account = userDTO.getUsername();
            return new ResponseEntity<>(account,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginByUser(@Validated @RequestBody User user, BindingResult result) {
        if (result.hasFieldErrors()) {
            List<ObjectError> list = result.getAllErrors();
            List<String> errorlists = new ArrayList<>();
            for (ObjectError objectError : list) {
                errorlists.add(objectError.getDefaultMessage());
            }
            return new ResponseEntity<>("Please input userName and password !", HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername()).get();

        JwtResponse jwtResponse = new JwtResponse(
                jwt,
                currentUser.getId(),
                userDetails.getUsername(),
                currentUser.getUsername(),
                userDetails.getAuthorities()
        );


        ResponseCookie springCookie = ResponseCookie.from("JWT", jwt)
                .httpOnly(false)
                .secure(false)
                .path("/")
                .maxAge(60 * 1000)
                .domain("localhost")
                .build();

        System.out.println(jwtResponse);

        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, springCookie.toString())
                .body(jwtResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Validated @RequestBody UserDTO userDTO, BindingResult result) {

        if (result.hasFieldErrors()) {
            List<ObjectError> list = result.getAllErrors();
            List<String> errorlists = new ArrayList<>();
            for (ObjectError objectError : list) {
                errorlists.add(objectError.getDefaultMessage());
            }
            return new ResponseEntity<>(errorlists, HttpStatus.BAD_REQUEST);
        }

        if (userService.existsByUserName(userDTO.getUsername())){
            return new ResponseEntity<>("User Name is already exists !", HttpStatus.BAD_REQUEST);
        }

        User user = userDTO.toUser();
        user.setId(0L);
        Role role = user.getRole();
        role.setUsers(user.getRole().getUsers());
        role.setId(2L);
        user.setRole(role);
        try{
            userService.save(user);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("no valid field of user", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //deleted account
    @PostMapping("/deleted")
    public ResponseEntity<?> deletedAccount(HttpServletResponse response, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equalsIgnoreCase("JWT")){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        User user = userService.findByUsername(getUserNamePrincipal()).get();
        user.setDeleted(true);
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    public String getUserNamePrincipal() {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        return username;
    }
}

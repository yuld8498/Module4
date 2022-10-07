package com.example.yuldshop.service.Role;

import com.example.yuldshop.model.Role;
import com.example.yuldshop.model.User;
import com.example.yuldshop.service.IGenericService;

import java.util.Set;

public interface IRoleService extends IGenericService<Role> {
    Role findByName(String name);

}

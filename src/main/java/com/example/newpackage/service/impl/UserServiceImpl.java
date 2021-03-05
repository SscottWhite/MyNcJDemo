package com.example.newpackage.service.impl;

import com.example.newpackage.dto.UserDTO;
import com.example.newpackage.mapper.UserMapper;
import com.example.newpackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getUSer() {
        return userMapper.getUSer();
    }
}

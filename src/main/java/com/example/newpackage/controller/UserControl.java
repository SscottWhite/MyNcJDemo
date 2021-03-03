
package com.example.newpackage.controller;

import com.example.newpackage.dto.UserDTO;
import com.example.newpackage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserControl {

        @Autowired()
        private UserService userService;

    @GetMapping("/getuser")
    public void getUserService() {
        log.info("123");
        log.info(userService.getUSer().toString());
//       / return userService.getUSer();
    }
}

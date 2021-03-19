package com.example.swagger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDTO;

import io.swagger.annotations.*;

/**
 * 默认地址, localhost:8080/swagger-ui.html
 * @author KJS_352
 *
 */
@Api(tags = "用户管理")
@RestController
public class UserController {

    @ApiOperation("添加用户")
    @PostMapping("/add")
    public UserDTO add(@ApiParam("用户") UserDTO user){
        return new UserDTO();
    }

    @ApiOperation("修改用户")
    @PostMapping("/update")
    public String update() {
        return "修改";
    }

    @ApiOperation("删除用户")
    @GetMapping("/delete")
    public boolean delete(@ApiParam("用户编号") Integer id) {
        return true;
    }

    @ApiOperation("查询用户")
    @GetMapping("/query")
    @ApiResponses(value = { @ApiResponse(code = 1000, message = "成功"), @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002,message = "缺少参数") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "电影名", dataType = "String", paramType = "query", required = true),})
    public UserDTO query(@RequestParam String name) {
    	UserDTO user = new UserDTO();
        user.setUserID("name");
        user.setUserID("password");
        return  user;
    }
}    

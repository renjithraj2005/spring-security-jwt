package com.demo.jwt.controller;

import com.demo.jwt.service.ApiUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.mappers.ModelMapper;

@RestController
@RequestMapping("/users")
@Api(tags = "users")
public class UserController {

    @Autowired
    private ApiUserService apiUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/login")
    @ApiOperation(value = "Login API")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid username/password supplied")})
    public String login(//
                        @ApiParam("Username") @RequestParam String username, //
                        @ApiParam("Password") @RequestParam String password) {
        return apiUserService.logIn(username, password);
    }
}

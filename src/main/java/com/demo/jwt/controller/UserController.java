package com.demo.jwt.controller;

import com.demo.jwt.model.User;
import com.demo.jwt.request.UserRequest;
import com.demo.jwt.service.ApiUserService;
import io.swagger.annotations.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public String login(@ApiParam("User") @RequestBody UserRequest loginRequest) {
        return apiUserService.logIn(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @PostMapping("/register")
    @ApiOperation(value = "Creates user")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public ResponseEntity<String> signUp(@ApiParam("Signup User") @RequestBody UserRequest user) {
        apiUserService.signUp(modelMapper.map(user, User.class));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

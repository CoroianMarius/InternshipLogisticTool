package com.ibm.den.controller;
import com.ibm.den.entities.*;
import com.ibm.den.entities.connection.LoginRequest;
import com.ibm.den.entities.connection.LoginResponse;
import com.ibm.den.entities.connection.RegisterTeam;
import com.ibm.den.services.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RegisterAndLoginController {
    @Autowired
    private final LoginRegisterService loginRegisterService;

    public RegisterAndLoginController(LoginRegisterService loginRegisterService){
        this.loginRegisterService = loginRegisterService;
    }
    @PostMapping("/register")
    //check RegisterTeam.java for struct
    public void register(@RequestBody RegisterTeam a) {
        loginRegisterService.register(a);
    }

    @PostMapping("/login")
    //Returns the enum : LEADER, STUDENT, etc. Check LoginResponse.java for struct
    public LoginResponse login(@RequestBody LoginRequest a){
        return loginRegisterService.login(a);
    }
}

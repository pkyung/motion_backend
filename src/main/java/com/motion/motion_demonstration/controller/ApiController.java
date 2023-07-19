package com.motion.motion_demonstration.controller;

import com.motion.motion_demonstration.service.ApiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @PostMapping("/publickey")
    public String publicKey() {
        return apiService.getPublicApiKey();
    }

    @PostMapping("googlekey")
    public String googleKey() {
        return  apiService.getGoogleApiKey();
    }

}

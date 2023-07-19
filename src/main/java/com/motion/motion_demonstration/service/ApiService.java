package com.motion.motion_demonstration.service;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Getter
@Service
public class ApiService {

    @Value("${key.PUBLIC}")
    private String publicApiKey;
    @Value("${key.GOOGLE}")
    private String googleApiKey;


}

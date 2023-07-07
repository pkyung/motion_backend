package com.motion.motion_demonstration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ThreeRequestDto {
    private String caltime;
    private String time;
    private String location;
    private String distance;
    private String region;
    private String wind;
    private String stdnoise;
    private String noise;
    private String name;
    private String currenttime;
}

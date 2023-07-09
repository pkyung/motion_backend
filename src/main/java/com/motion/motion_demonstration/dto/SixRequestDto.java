package com.motion.motion_demonstration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SixRequestDto {
    String caltime;
    String time;
    String location;
    String distance;
    String region;
    String noisedivision;
    String wind;
    String stdnoise;
    String noise;
    String currenttime;
    String name;
}

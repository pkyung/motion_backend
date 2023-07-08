package com.motion.motion_demonstration.dto;

import com.motion.motion_demonstration.dtoArray.Demo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SevenRequestDto {
    Demo[] demo;
    String currenttime;
    String name;
}

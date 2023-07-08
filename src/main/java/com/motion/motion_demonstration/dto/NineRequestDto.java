package com.motion.motion_demonstration.dto;

import com.motion.motion_demonstration.dtoArray.Action;
import com.motion.motion_demonstration.dtoArray.Demo;
import com.motion.motion_demonstration.dtoArray.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NineRequestDto {
    Demo[] demo;
    Item[] item;
    Action[] action;

    String currenttime;
    String name;
}

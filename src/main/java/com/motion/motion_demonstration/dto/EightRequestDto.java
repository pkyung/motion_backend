package com.motion.motion_demonstration.dto;

import com.motion.motion_demonstration.dtoArray.Action;
import com.motion.motion_demonstration.dtoArray.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EightRequestDto {
    Item[] item;
    Action[] action;

    String caltime;
    String time;
    String location;
    String distance;
    String region;
    String wind;
    String stdnoise;
    String noise;

    String currenttime;
    String name;
}

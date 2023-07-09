package com.motion.motion_demonstration.dto;

import com.motion.motion_demonstration.dtoArray.Action;
import com.motion.motion_demonstration.dtoArray.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ElevenRequestDto {
    Item[] item;
    Action[] action;

    String hour;
    String minute;
    String caltime;
    String time;
    String location;
    String distance;
    String region;
    String wind;
    String noise;
    String currenttime;
    String name;
}

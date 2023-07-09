package com.motion.motion_demonstration.dto;

import com.motion.motion_demonstration.dtoArray.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TwelveRequestDto {
    Item[] item;

    String currenttime;
    String name;
}

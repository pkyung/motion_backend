package com.motion.motion_demonstration.controller;

import com.motion.motion_demonstration.dto.OneRequestDto;
import com.motion.motion_demonstration.dto.TwoRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Controller
public class PdfController {

    @PostMapping("/one")
    public void oneDownload(@RequestBody OneRequestDto dto) throws IOException {

    }

    @PostMapping("/two")
    public void twoDownload(@RequestBody TwoRequestDto dto) throws IOException {

    }
}

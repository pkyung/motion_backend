package com.motion.motion_demonstration.controller;

import com.itextpdf.text.DocumentException;
import com.motion.motion_demonstration.dto.OneRequestDto;
import com.motion.motion_demonstration.dto.TwoRequestDto;
import com.motion.motion_demonstration.service.PdfService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class PdfController {

    private final PdfService pdfService;

    @PostMapping("/one")
    public void oneDownload(@RequestBody OneRequestDto dto) throws DocumentException, IOException {
        pdfService.oneManipulate(dto);
    }

    @PostMapping("/two")
    public void twoDownload(@RequestBody TwoRequestDto dto) throws IOException {

    }
}

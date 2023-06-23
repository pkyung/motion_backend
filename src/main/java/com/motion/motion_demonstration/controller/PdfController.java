package com.motion.motion_demonstration.controller;

import com.itextpdf.text.DocumentException;
import com.motion.motion_demonstration.dto.OneRequestDto;
import com.motion.motion_demonstration.dto.TwoRequestDto;
import com.motion.motion_demonstration.service.PdfService;
import com.motion.motion_demonstration.service.PdfToImgService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@AllArgsConstructor
public class PdfController {

    private final PdfService pdfService;
    private final PdfToImgService pdfToImgService;

    @PostMapping("/one")
    public void oneDownload(@RequestBody OneRequestDto dto) throws DocumentException, IOException {
        pdfService.oneManipulate(dto);
        pdfToImgService.pdfToImg(new FileInputStream(new File("./one.pdf")), 0, "one.png");
    }

    @PostMapping("/two")
    public void twoDownload(@RequestBody TwoRequestDto dto) throws DocumentException, IOException {
        pdfService.twoManipulate(dto);
        pdfToImgService.pdfToImg(new FileInputStream(new File("./two.pdf")), 1, "two.png");
    }
}

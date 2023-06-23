package com.motion.motion_demonstration.controller;

import com.itextpdf.text.DocumentException;
import com.motion.motion_demonstration.dto.OneRequestDto;
import com.motion.motion_demonstration.dto.TwoRequestDto;
import com.motion.motion_demonstration.service.PdfService;
import com.motion.motion_demonstration.service.PdfToImgService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@AllArgsConstructor
public class PdfController {

    private final PdfService pdfService;
    private final PdfToImgService pdfToImgService;

    @PostMapping("/one")
    public ResponseEntity<Object> oneDownload(@RequestBody OneRequestDto dto) throws DocumentException, IOException {
        pdfService.oneManipulate(dto);
        pdfToImgService.pdfToImg(new FileInputStream(new File("./one.pdf")), 0, "one.png");

        Path filePath = Paths.get("./one.png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("./one.png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("/two")
    public ResponseEntity<Object> twoDownload(@RequestBody TwoRequestDto dto) throws DocumentException, IOException {
        pdfService.twoManipulate(dto);
        pdfToImgService.pdfToImg(new FileInputStream(new File("./two.pdf")), 1, "two.png");

        Path filePath = Paths.get("./two.png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("./two.png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }
}

package com.motion.motion_demonstration.controller;

import com.itextpdf.text.DocumentException;
import com.motion.motion_demonstration.dto.OneRequestDto;
import com.motion.motion_demonstration.dto.ThreeRequestDto;
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
        // 현재 시간 == 나중에 불러올 때도 사용되는 시간
        String currentTime = dto.getCurrenttime();

        // 만약 이미지가 없으면 이미지 제작
        String fileExist = "./image/one" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.oneManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("./image/one" + currentTime + ".pdf")), 0, "./image/one" + currentTime + ".png");
        }
        Path filePath = Paths.get("./image/one" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("./image/one" + currentTime + ".png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("/two")
    public ResponseEntity<Object> twoDownload(@RequestBody TwoRequestDto dto) throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        String fileExist = "./image/two" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.twoManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("./image/two" + currentTime + ".pdf")), 1, "./image/two" + currentTime + ".png");
        }

        Path filePath = Paths.get("./image/two" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("./image/two" + currentTime + ".png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("/three")
    public ResponseEntity<Object> threeDownload(@RequestBody ThreeRequestDto dto)
            throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        String fileExist = "./image/three" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.threeManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("./image/three" + currentTime + ".pdf")), 2, "./image/three" + currentTime + ".png");
        }
        Path filePath = Paths.get("./image/three" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("./image/three" + currentTime + ".png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }
}

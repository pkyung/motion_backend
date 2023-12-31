package com.motion.motion_demonstration.controller;

import com.itextpdf.text.DocumentException;
import com.motion.motion_demonstration.dto.*;
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
        String fileExist = "image/one" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.oneManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("image/one" + currentTime + ".pdf")), 0, "image/one" + currentTime + ".png");
        }
        Path filePath = Paths.get("image/one" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("image/one" + currentTime + ".png");

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
        String fileExist = "image/two" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.twoManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("image/two" + currentTime + ".pdf")), 1, "image/two" + currentTime + ".png");
        }

        Path filePath = Paths.get("image/two" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("image/two" + currentTime + ".png");

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
        String fileExist = "image/three" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.threeManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("image/three" + currentTime + ".pdf")), 2, "image/three" + currentTime + ".png");
        }
        Path filePath = Paths.get("image/three" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("image/three" + currentTime + ".png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("/four")
    public ResponseEntity<Object> fourDownload(@RequestBody FourRequestDto dto)
            throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        String fileExist = "image/four" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.fourManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("image/four" + currentTime + ".pdf")), 3, "image/four" + currentTime + ".png");
        }
        Path filePath = Paths.get("image/four" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("image/four" + currentTime + ".png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("/five")
    public ResponseEntity<Object> fiveDownload(@RequestBody FiveRequestDto dto)
            throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        String fileExist = "image/five" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.fiveManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("image/five" + currentTime + ".pdf")), 4, "image/five" + currentTime + ".png");
        }
        Path filePath = Paths.get("image/five" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("image/five" + currentTime + ".png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("/six")
    public ResponseEntity<Object> sixDownload(@RequestBody SixRequestDto dto)
            throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        String fileExist = "image/six" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.sixManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("image/six" + currentTime + ".pdf")), 5, "image/six" + currentTime + ".png");
        }
        Path filePath = Paths.get("image/six" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("image/six" + currentTime + ".png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("/seven")
    public ResponseEntity<Object> sevenDownload(@RequestBody SevenRequestDto dto)
            throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        String fileExist = "image/seven" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.sevenManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("image/seven" + currentTime + ".pdf")), 6, "image/seven" + currentTime + ".png");
        }
        Path filePath = Paths.get("image/seven" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("image/seven" + currentTime + ".png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("/eight")
    public ResponseEntity<Object> eightDownload(@RequestBody EightRequestDto dto)
            throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        String fileExist = "image/eight" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.eightManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("image/eight" + currentTime + ".pdf")), 7, "image/eight" + currentTime + ".png");
        }
        Path filePath = Paths.get("image/eight" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("image/eight" + currentTime + ".png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("/nine")
    public ResponseEntity<Object> nineDownload(@RequestBody NineRequestDto dto)
            throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        String fileExist = "image/nine" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.nineManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("image/nine" + currentTime + ".pdf")), 8, "image/nine" + currentTime + ".png");
        }
        Path filePath = Paths.get("image/nine" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("image/nine" + currentTime + ".png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("/ten")
    public ResponseEntity<Object> tenDownload(@RequestBody TenRequestDto dto)
            throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        String fileExist = "image/ten" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.tenManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("image/ten" + currentTime + ".pdf")), 9, "image/ten" + currentTime + ".png");
        }
        Path filePath = Paths.get("image/ten" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("image/ten" + currentTime + ".png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("/eleven")
    public ResponseEntity<Object> elevenDownload(@RequestBody ElevenRequestDto dto)
            throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        String fileExist = "image/eleven" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.elevenManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("image/eleven" + currentTime + ".pdf")), 10, "image/eleven" + currentTime + ".png");
        }
        Path filePath = Paths.get("image/eleven" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("image/eleven" + currentTime + ".png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }


    @PostMapping("/twelve")
    public ResponseEntity<Object> twelveDownload(@RequestBody TwelveRequestDto dto)
            throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        String fileExist = "image/twelve" + currentTime + ".png";
        File exist = new File(fileExist);
        if (!exist.exists()) {
            pdfService.twelveManipulate(dto);
            pdfToImgService.pdfToImg(new FileInputStream(new File("image/twelve" + currentTime + ".pdf")), 11, "image/twelve" + currentTime + ".png");
        }
        Path filePath = Paths.get("image/twelve" + currentTime + ".png");
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));
        File file = new File("image/twelve" + currentTime + ".png");

        HttpHeaders headers = new HttpHeaders();
        String contentType = Files.probeContentType(filePath);

        // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지 알려주는 헤더
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
    }

}

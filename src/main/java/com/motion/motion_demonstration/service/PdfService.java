package com.motion.motion_demonstration.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.motion.motion_demonstration.dto.OneRequestDto;
import com.motion.motion_demonstration.dto.TwoRequestDto;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PdfService {

    public void oneManipulate(OneRequestDto dto) throws DocumentException, IOException {

        // 원본 파일 읽기 - resources 폴더 안에 있음
        ClassPathResource resource = new ClassPathResource("file.pdf");
        PdfReader reader = new PdfReader(resource.getInputStream());

        // 수정된 파일 이름
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("one.pdf"));

        // 첫 장을 수정할 것
        PdfContentByte contentByte = stamper.getOverContent(1);

        // 폰트 지정
        BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        contentByte.setFontAndSize(baseFont, 12);

        // 현재 날짜, 시간 가져오기
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String formattedNow = now.format(formatter);

        // 필요한 글자 넣기
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(0, 4), 213, 163, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(4, 6), 252, 163, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(6, 8), 283, 163, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(8, 10), 314, 163, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(10, 12), 345, 163, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getName(), 250, 93, 0);

        stamper.close();
        reader.close();
    }

    public void twoManipulate(TwoRequestDto dto) throws DocumentException, IOException {

        // 원본 파일 읽기 - resources 폴더 안에 있음
        ClassPathResource resource = new ClassPathResource("file.pdf");
        PdfReader reader = new PdfReader(resource.getInputStream());

        // 수정된 파일 이름
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("two.pdf"));

        // 첫 장을 수정할 것
        PdfContentByte contentByte = stamper.getOverContent(2);

        // 폰트 지정
        BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        contentByte.setFontAndSize(baseFont, 12);

        // 현재 날짜, 시간 가져오기
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String formattedNow = now.format(formatter);

        // 필요한 글자 넣기
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(0, 4), 213, 379, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(4, 6), 252, 379, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(6, 8), 283, 379, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(8, 10), 314, 379, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(10, 12), 345, 379, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getName(), 220, 311, 0);

        // 폰트 크기 바꾸기
        contentByte.setFontAndSize(baseFont, 15);

        // 필요한 글자 넣기
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getCaltime(), 240, 665, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getTime(), 465, 665, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getLocation(), 290, 640, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getDistance(), 240, 615, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getRegion(), 465, 615, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getWind(), 160, 588, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getStdnoise(), 326, 593, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getNoise(), 490, 588, 0);


        stamper.close();
        reader.close();
    }
}

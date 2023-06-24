package com.motion.motion_demonstration.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.motion.motion_demonstration.dto.OneRequestDto;
import com.motion.motion_demonstration.dto.ThreeRequestDto;
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

        // 두번째 장을 수정할 것
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
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getName(), 230, 311, 0);

        // 폰트 크기 바꾸기
        contentByte.setFontAndSize(baseFont, 14);

        // 필요한 글자 넣기
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getCaltime(), 240, 665, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getTime(), 465, 665, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getLocation(), 330, 640, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getDistance(), 240, 615, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getRegion(), 465, 615, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getWind(), 160, 588, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getStdnoise(), 326, 593, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getNoise(), 490, 588, 0);

        stamper.close();
        reader.close();
    }

    public void threeManipulate(ThreeRequestDto dto) throws DocumentException, IOException {
        // 원본 파일 읽기 - resources 폴더 안에 있음
        ClassPathResource resource = new ClassPathResource("file.pdf");
        PdfReader reader = new PdfReader(resource.getInputStream());

        // 수정된 파일 이름
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("three.pdf"));

        // 세번째 장을 수정할 것
        PdfContentByte contentByte = stamper.getOverContent(3);

        // 폰트 지정
        BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        contentByte.setFontAndSize(baseFont, 12);

        // 현재 날짜, 시간 가져오기
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String formattedNow = now.format(formatter);

        // 필요한 글자 넣기
        // 고지일
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(0, 4), 215, 401, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(4, 6), 254, 401, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(6, 8), 285, 401, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(8, 10), 316, 401, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(10, 12), 347, 401, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getName(), 230, 336, 0); // 주최자명

        // 폰트 크기 변경
        contentByte.setFontAndSize(baseFont, 14);

        // 위반 정보 기록
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getCaltime(), 240, 667, 0); // 측정시간
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getTime(), 465, 667, 0); // 시간대
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getLocation(), 350, 640, 0); // 측정 위치
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getDistance(), 242, 615, 0); // 측정 거리
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getRegion(), 465, 615, 0); // 대상지역
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getWind(), 160, 585, 0); // 풍속
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getStdnoise(), 326, 593, 0); // 기준 소음도 (dB)
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getNoise(), 491, 586, 0); // 측정 소음도 (dB)

        stamper.close();
        reader.close();
    }
}

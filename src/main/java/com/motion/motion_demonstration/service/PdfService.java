package com.motion.motion_demonstration.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.motion.motion_demonstration.dto.OneRequestDto;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class PdfService {

    public void oneManipulate(OneRequestDto dto) throws DocumentException, IOException {

        // 원본 파일 읽기 - resources 폴더 안에 있음
        ClassPathResource resource = new ClassPathResource("file.pdf");
        PdfReader reader = new PdfReader(resource.getInputStream());

        // 수정된 파일 이름
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("one"));

        // 첫 장을 수정할 것
        PdfContentByte contentByte = stamper.getOverContent(1);

        // 폰트 지정
        BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        contentByte.setFontAndSize(baseFont, 12);

        // 현재 날짜, 시간 가져오기
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd/HH/mm/ss");

        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getName(), 250, 93, 0);

        stamper.close();
        reader.close();
    }
}

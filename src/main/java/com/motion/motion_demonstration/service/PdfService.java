package com.motion.motion_demonstration.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.motion.motion_demonstration.dto.*;
import com.motion.motion_demonstration.dtoArray.Action;
import com.motion.motion_demonstration.dtoArray.Demo;
import com.motion.motion_demonstration.dtoArray.Item;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;


@Service
public class PdfService {

    public void oneManipulate(OneRequestDto dto) throws DocumentException, IOException {

        String currentTime = dto.getCurrenttime();

        // 원본 파일 읽기 - resources 폴더 안에 있음
        ClassPathResource resource = new ClassPathResource("file.pdf");
        PdfReader reader = new PdfReader(resource.getInputStream());

        // 수정된 파일 이름
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("image/one" + currentTime + ".pdf"));

        // 첫 장을 수정할 것
        PdfContentByte contentByte = stamper.getOverContent(1);

        // 폰트 지정
        BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        contentByte.setFontAndSize(baseFont, 12);

        // 현재 날짜, 시간 가져오기
        String formattedNow = dto.getCurrenttime();

        // 필요한 글자 넣기
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(0, 4), 216, 153, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(4, 6), 257, 153, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(6, 8), 286, 153, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(8, 10), 318, 153, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(10, 12), 349, 153, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getName(), 270, 90, 0);

        contentByte.setFontAndSize(baseFont, 13);

        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getEquinoise(), 200, 698, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getMaxnoise(), 200, 670, 0);

        stamper.close();
        reader.close();
    }

    public void twoManipulate(TwoRequestDto dto) throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();

        // 원본 파일 읽기 - resources 폴더 안에 있음
        ClassPathResource resource = new ClassPathResource("file.pdf");
        PdfReader reader = new PdfReader(resource.getInputStream());

        // 수정된 파일 이름
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("image/two" + currentTime + ".pdf"));

        // 두번째 장을 수정할 것
        PdfContentByte contentByte = stamper.getOverContent(2);

        // 폰트 지정
        BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        contentByte.setFontAndSize(baseFont, 12);

        // 현재 날짜, 시간 가져오기
        String formattedNow = dto.getCurrenttime();

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

        contentByte.setColorFill(BaseColor.RED);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getNoise(), 490, 588, 0);

        stamper.close();
        reader.close();
    }

    public void threeManipulate(ThreeRequestDto dto) throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        // 원본 파일 읽기 - resources 폴더 안에 있음
        ClassPathResource resource = new ClassPathResource("file.pdf");
        PdfReader reader = new PdfReader(resource.getInputStream());

        // 수정된 파일 이름
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("image/three" + currentTime + ".pdf"));

        // 세번째 장을 수정할 것
        PdfContentByte contentByte = stamper.getOverContent(3);

        // 폰트 지정
        BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        contentByte.setFontAndSize(baseFont, 12);

        // 현재 날짜, 시간 가져오기
        String formattedNow = dto.getCurrenttime();

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

        contentByte.setColorFill(BaseColor.RED);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getNoise(), 491, 586, 0); // 측정 소음도 (dB)

        stamper.close();
        reader.close();
    }

    public void fourManipulate(FourRequestDto dto) throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        // 원본 파일 읽기 - resources 폴더 안에 있음
        ClassPathResource resource = new ClassPathResource("file.pdf");
        PdfReader reader = new PdfReader(resource.getInputStream());

        // 수정된 파일 이름
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("image/four" + currentTime + ".pdf"));

        // 네번째 장을 수정할 것
        PdfContentByte contentByte = stamper.getOverContent(4);

        // 폰트 지정
        BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        contentByte.setFontAndSize(baseFont, 12);

        // 현재 날짜, 시간 가져오기
        String formattedNow = dto.getCurrenttime();

        // 필요한 글자 넣기
        // 고지일
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(0, 4), 215, 338, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(4, 6), 254, 338, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(6, 8), 285, 338, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(8, 10), 316, 338, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(10, 12), 347, 338, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getName(), 216, 296, 0); // 주최자명

        Demo[] demos = dto.getDemo(); // 각 회차의 데모 배열
        contentByte.setFontAndSize(baseFont, 14);
        for (int i = 0; i < 3; ++i) {
            Demo demo = demos[i];
            contentByte.setColorFill(BaseColor.BLACK);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getCnt(), 185, 693 - i * 84, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getCaltime(), 355, 693 - i * 84, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getTime(), 490, 693 - i * 84, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getLocation(), 350, 675 - i * 84, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getDistance(), 247, 660 - i * 84, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getRegion(), 465, 660 - i * 84, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getWind(), 160, 637 - i * 84, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getStdnoise(), 324, 644 - i * 84, 0);

            contentByte.setColorFill(BaseColor.RED);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getNoise(), 493, 637 - i * 84, 0);
        }

        stamper.close();
        reader.close();
    }

    public void fiveManipulate(FiveRequestDto dto) throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        // 소스 파일 읽기 - 리소스 폴더에 위치
        ClassPathResource resource = new ClassPathResource("file.pdf");
        PdfReader reader = new PdfReader(resource.getInputStream());

        // 수정된 파일 이름
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("image/five" + currentTime + ".pdf"));

        // 다섯 번째 장을 수정할 것
        PdfContentByte contentByte = stamper.getOverContent(5);

        // 폰트 설정
        BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        contentByte.setFontAndSize(baseFont, 12);

        // 현재 날짜와 시간 가져오기
        String formattedNow = dto.getCurrenttime();

        // 필요한 글자 넣기
        // 고지일
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(0, 4), 213, 404, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(4, 6), 252, 404, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(6, 8), 283, 404, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(8, 10), 314, 404, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(10, 12), 345, 404, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getName(), 230, 338, 0);

        // 폰트 크기 바꾸기
        contentByte.setFontAndSize(baseFont, 14);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getHour(), 370, 738, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getMinute(), 418, 738, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getCaltime(), 240, 621, 0); // 측정시간
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getTime(), 460, 621, 0); // 시간대
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getLocation(), 353, 603, 0); // 측정 위치
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getDistance(), 237, 583, 0); // 측정 거리
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getRegion(), 463, 583, 0); // 대상지역
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getNoisedivision(), 244, 563, 0); // 소음도 구분
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getWind(), 160, 536, 0); // 풍속
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getStdnoise(), 325, 545, 0); // 기준 소음도 (dB)

        contentByte.setColorFill(BaseColor.RED);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getNoise(), 492, 535, 0); // 측정 소음도 (dB)


        stamper.close();
        reader.close();
    }


    public void sixManipulate(SixRequestDto dto) throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        // 소스 파일 읽기 - 리소스 폴더에 위치
        ClassPathResource resource = new ClassPathResource("file.pdf");
        PdfReader reader = new PdfReader(resource.getInputStream());

        // 수정된 파일 이름
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("image/six" + currentTime + ".pdf"));

        // 세 번째 챕터 편집
        PdfContentByte contentByte = stamper.getOverContent(6);

        // 폰트 설정
        BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        contentByte.setFontAndSize(baseFont, 12);

        // 현재 날짜와 시간 가져오기
        String formattedNow = dto.getCurrenttime();

        // 필요한 글자 넣기
        // 고지일
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(0, 4), 215, 400, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(4, 6), 254, 400, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(6, 8), 285, 400, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(8, 10), 316, 400, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(10, 12), 347, 400, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getName(), 230, 334, 0);

        contentByte.setFontAndSize(baseFont, 14);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getCaltime(), 239, 656, 0); // 측정시간
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getTime(), 462, 656, 0); // 시간대
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getLocation(), 352, 632, 0); // 측정 위치
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getDistance(), 238, 611, 0); // 측정 거리
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getRegion(), 466, 611, 0); // 대상지역
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getWind(), 158, 582, 0); // 풍속
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getStdnoise(), 325, 590, 0); // 기준 소음도

        contentByte.setColorFill(BaseColor.RED);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getNoise(), 492, 582, 0); // 측정 소음도

        stamper.close();
        reader.close();
    }


    public void sevenManipulate(SevenRequestDto dto) throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        // 소스 파일 읽기 - 리소스 폴더에 위치
        ClassPathResource resource = new ClassPathResource("file.pdf");
        PdfReader reader = new PdfReader(resource.getInputStream());

        // 수정된 파일 이름
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("image/seven" + currentTime + ".pdf"));

        // 세 번째 챕터 편집
        PdfContentByte contentByte = stamper.getOverContent(7);

        // 폰트 설정
        BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        contentByte.setFontAndSize(baseFont, 12);

        // 현재 날짜와 시간 가져오기
        String formattedNow = dto.getCurrenttime();

        // 필요한 글자 넣기
        // 고지일
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(0, 4), 215, 342, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(4, 6), 254, 342, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(6, 8), 285, 342, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(8, 10), 316, 342, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(10, 12), 347, 342, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getName(), 216, 296, 0); // 주최자명

        Demo[] demos = dto.getDemo(); // 각 회차의 데모 배열
        contentByte.setFontAndSize(baseFont, 12);
        for (int i = 0; i < 3; ++i) {
            Demo demo = demos[i];
            contentByte.setColorFill(BaseColor.BLACK);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getCnt(), 185, 686 - i * 79, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getCaltime(), 355, 686 - i * 79, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getTime(), 490, 686 - i * 79, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getLocation(), 350, 672 - i * 79, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getDistance(), 247, 656 - i * 79, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getRegion(), 467, 656 - i * 80, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getWind(), 160, 637 - i * 79, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getStdnoise(), 324, 644 - i * 79, 0);

            contentByte.setColorFill(BaseColor.RED);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, demo.getNoise(), 493, 637 - i * 79, 0);
        }

        stamper.close();
        reader.close();
    }

    public void eightManipulate(EightRequestDto dto) throws DocumentException, IOException {
        String currentTime = dto.getCurrenttime();
        // 소스 파일 읽기 - 리소스 폴더에 위치
        ClassPathResource resource = new ClassPathResource("file.pdf");
        PdfReader reader = new PdfReader(resource.getInputStream());

        // 수정된 파일 이름
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("image/eight" + currentTime + ".pdf"));

        // 세 번째 챕터 편집
        PdfContentByte contentByte = stamper.getOverContent(8);

        // 폰트 설정
        BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        contentByte.setFontAndSize(baseFont, 12);

        // 현재 날짜와 시간 가져오기
        String formattedNow = dto.getCurrenttime();

        // 필요한 글자 넣기
        // 고지일
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(0, 4), 215, 341, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(4, 6), 254, 341, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(6, 8), 285, 341, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(8, 10), 316, 341, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, formattedNow.substring(10, 12), 347, 341, 0);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getName(), 219, 300, 0);

        contentByte.setFontAndSize(baseFont, 14);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getCaltime(), 240, 689, 0); // 측정시간
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getTime(), 463, 689, 0); // 시간대
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getLocation(), 350, 670, 0); // 측정 위치
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getDistance(), 239, 651, 0); // 측정 거리
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getRegion(), 464, 651, 0); // 대상지역
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getWind(), 159, 624, 0); // 풍속
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getStdnoise(), 326, 631, 0); // 기준 소음도

        contentByte.setColorFill(BaseColor.RED);
        contentByte.showTextAligned(Paragraph.ALIGN_CENTER, dto.getStdnoise(), 492, 624, 0); // 측정 소음도

        contentByte.setFontAndSize(baseFont, 10);
        contentByte.setColorFill(BaseColor.BLACK);

        Item[] items = dto.getItem();
        for (int i = 0; i < items.length; ++i) {
            Item item = items[i];
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, item.getItemname(), 150, 527 - 17 * i, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, item.getCnt(), 216, 527 - 17 * i, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, item.getSig(), 329, 527 - 17 * i, 0);
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, item.getStorage(), 472, 527 - 17 * i, 0);
        }

        Action[] actions = dto.getAction();
        for (int i = 0; i < actions.length; ++i) {
            Action action = actions[i];
            contentByte.showTextAligned(Paragraph.ALIGN_CENTER, action.getActionetc(), 317, 440 - 17 * i, 0);
        }
            stamper.close();
            reader.close();
        }

        public void nineManipulate (NineRequestDto dto) throws DocumentException, IOException {
            String currentTime = dto.getCurrenttime();
            // 소스 파일 읽기 - 리소스 폴더에 위치
            ClassPathResource resource = new ClassPathResource("file.pdf");
            PdfReader reader = new PdfReader(resource.getInputStream());

            // 수정된 파일 이름
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("image/nine" + currentTime + ".pdf"));

            // 세 번째 챕터 편집
            PdfContentByte contentByte = stamper.getOverContent(9);

            // 폰트 설정
            BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            contentByte.setFontAndSize(baseFont, 12);

            // 현재 날짜와 시간 가져오기
            String formattedNow = dto.getCurrenttime();

            stamper.close();
            reader.close();
        }

        public void tenManipulate (TenRequestDto dto) throws DocumentException, IOException {
            String currentTime = dto.getCurrenttime();
            // 소스 파일 읽기 - 리소스 폴더에 위치
            ClassPathResource resource = new ClassPathResource("file.pdf");
            PdfReader reader = new PdfReader(resource.getInputStream());

            // 수정된 파일 이름
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("image/ten" + currentTime + ".pdf"));

            // 세 번째 챕터 편집
            PdfContentByte contentByte = stamper.getOverContent(10);

            // 폰트 설정
            BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            contentByte.setFontAndSize(baseFont, 12);

            // 현재 날짜와 시간 가져오기
            String formattedNow = dto.getCurrenttime();

            stamper.close();
            reader.close();
        }

        public void elevenManipulate (ElevenRequestDto dto) throws DocumentException, IOException {
            String currentTime = dto.getCurrenttime();
            // 소스 파일 읽기 - 리소스 폴더에 위치
            ClassPathResource resource = new ClassPathResource("file.pdf");
            PdfReader reader = new PdfReader(resource.getInputStream());

            // 수정된 파일 이름
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("image/eleven" + currentTime + ".pdf"));

            // 세 번째 챕터 편집
            PdfContentByte contentByte = stamper.getOverContent(11);

            // 폰트 설정
            BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            contentByte.setFontAndSize(baseFont, 12);

            // 현재 날짜와 시간 가져오기
            String formattedNow = dto.getCurrenttime();

            stamper.close();
            reader.close();
        }

        public void twelveManipulate (TwelveRequestDto dto) throws DocumentException, IOException {
            String currentTime = dto.getCurrenttime();
            // 소스 파일 읽기 - 리소스 폴더에 위치
            ClassPathResource resource = new ClassPathResource("file.pdf");
            PdfReader reader = new PdfReader(resource.getInputStream());

            // 수정된 파일 이름
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("image/twelve" + currentTime + ".pdf"));

            // 세 번째 챕터 편집
            PdfContentByte contentByte = stamper.getOverContent(12);

            // 폰트 설정
            BaseFont baseFont = BaseFont.createFont("malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            contentByte.setFontAndSize(baseFont, 12);

            // 현재 날짜와 시간 가져오기
            String formattedNow = dto.getCurrenttime();

            stamper.close();
            reader.close();
        }

    }

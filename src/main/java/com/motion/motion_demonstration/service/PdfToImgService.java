package com.motion.motion_demonstration.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class PdfToImgService {

    public String pdfToImg(InputStream is, int i, String fileName) throws IOException {

        // Document 생성
        PDDocument pdfDoc = PDDocument.load(is);
        PDFRenderer pdfRenderer = new PDFRenderer(pdfDoc);

        // 이미지 파일 생성 경로
        Files.createDirectories(Paths.get("./"));

        BufferedImage bi = pdfRenderer.renderImageWithDPI(i, 300, ImageType.RGB);

        // 이미지 제작
        ImageIOUtil.writeImage(bi, fileName, 300);

        return fileName;
    }
}

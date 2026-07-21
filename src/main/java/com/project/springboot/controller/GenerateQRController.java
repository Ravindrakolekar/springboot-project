package com.project.springboot.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@RestController
public class GenerateQRController {

    @GetMapping(value = "/generateQRCode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCode(@RequestParam String number) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(number, BarcodeFormat.QR_CODE, 250, 250);

            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            ImageIO.write(qrImage, "PNG", pngOutputStream);

            return ResponseEntity.ok(pngOutputStream.toByteArray());
        } catch (WriterException | java.io.IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

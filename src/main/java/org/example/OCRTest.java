package org.example;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

import java.io.File;

public class OCRTest {

    public static void main(String[] args) {

        ITesseract tesseract = new Tesseract();

        tesseract.setDatapath("C:\\Users\\MONICA G\\AppData\\Local\\Programs\\Tesseract-OCR\\tessdata");

        tesseract.setLanguage("eng");
        tesseract.setPageSegMode(6);
        tesseract.setOcrEngineMode(1);


        try {

            String processedImage = ImagePreprocessor.preprocess("Images/img.png");
            File image = new File(processedImage);
            String text = tesseract.doOCR(image);
            text = text.replaceAll("\\s+", " ").trim();
            text = text.toLowerCase();
            String instruction = DecisionEngine.decide(text);

            System.out.println("\nDetected Text:");
            System.out.println(text);

            System.out.println("\nInstruction:");
            System.out.println(instruction);

            System.out.println("========== OCR OUTPUT ==========");
            System.out.println(text);

        } catch (Exception e) {
            System.out.println("OCR Failed!");
            e.printStackTrace();
        }
    }
}














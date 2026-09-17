package org.example;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class ImagePreprocessor {

    static {
        System.load("C:\\Users\\MONICA G\\Downloads\\opencv\\build\\java\\x64\\opencv_java4120.dll");
    }

    public static String preprocess(String inputImage) {

        System.out.println("===== OpenCV Started =====");

        Mat image = Imgcodecs.imread(inputImage);

        if (image.empty()) {
            System.out.println("Image could not be loaded!");
            return inputImage;
        }

        Mat gray = new Mat();
        Imgproc.cvtColor(image, gray, Imgproc.COLOR_BGR2GRAY);

        Mat blur = new Mat();
        Imgproc.GaussianBlur(gray, blur, new Size(3,3), 0);

        Mat threshold = new Mat();
        Imgproc.adaptiveThreshold(
                blur,
                threshold,
                255,
                Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C,
                Imgproc.THRESH_BINARY,
                11,
                2
        );

        Mat kernel = Imgproc.getStructuringElement(
                Imgproc.MORPH_RECT,
                new Size(2,2)
        );

        Mat opening = new Mat();
        Imgproc.morphologyEx(threshold, opening, Imgproc.MORPH_OPEN, kernel);

        Mat closing = new Mat();
        Imgproc.morphologyEx(opening, closing, Imgproc.MORPH_CLOSE, kernel);

        Mat edges = new Mat();
        Imgproc.Canny(closing, edges, 50, 150);

        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();

        Imgproc.findContours(
                edges,
                contours,
                hierarchy,
                Imgproc.RETR_EXTERNAL,
                Imgproc.CHAIN_APPROX_SIMPLE
        );

        Rect largestRect = null;
        double maxArea = 0;

        for (MatOfPoint contour : contours) {

            Rect rect = Imgproc.boundingRect(contour);

            double area = rect.area();

            if (area > maxArea) {
                maxArea = area;
                largestRect = rect;
            }
        }

        Mat result = image.clone();

        if (largestRect != null) {

            Imgproc.rectangle(
                    result,
                    largestRect,
                    new Scalar(0,0,255),
                    3
            );

            System.out.println("Largest Area : " + maxArea);
        }

        String output = "C:\\Users\\MONICA G\\IdeaProjects\\ProxyVisionOCR\\Images\\screen_detected.png";

        Imgcodecs.imwrite(output, result);

        System.out.println("Output File : " + output);

        return output;
    }
}
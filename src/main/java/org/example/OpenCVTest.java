package org.example;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class OpenCVTest {

    public static void main(String[] args) {

        System.load("C:\\Users\\MONICA G\\Downloads\\opencv\\build\\java\\x64\\opencv_java4120.dll");

        Mat image = Imgcodecs.imread("Images/img.png");

        if (image.empty()) {
            System.out.println("Image not found!");
        } else {
            System.out.println("Image Loaded Successfully");
            System.out.println("Rows : " + image.rows());
            System.out.println("Columns : " + image.cols());
        }
    }
}

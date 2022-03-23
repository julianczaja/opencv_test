#include "opencv-utils.h"
#include <opencv2/imgproc.hpp>

void mirrorImage(Mat src) {
    cv::flip(src, src, 1);
}

void grayscaleImage(Mat src) {
    Mat tmp;
    cv::cvtColor(src, tmp, cv::COLOR_RGBA2GRAY);
    cv::cvtColor(tmp, src, cv::COLOR_GRAY2RGBA, 4);
}
#include "opencv-utils.h"
#include <opencv2/imgproc.hpp>

void mirrorImage(Mat src) {
    cv::flip(src, src, 1);
}
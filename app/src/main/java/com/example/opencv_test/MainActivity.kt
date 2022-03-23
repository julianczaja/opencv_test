package com.example.opencv_test

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.opencv_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var srcBitmap: Bitmap
    private lateinit var dstBitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        srcBitmap = BitmapFactory.decodeResource(resources, R.drawable.flower)
        dstBitmap = srcBitmap.copy(srcBitmap.config, true)

        binding.ivImageSrc.setImageBitmap(srcBitmap)
        binding.ivImageDst.setImageBitmap(dstBitmap)

        // Buttons
        binding.btnGrayscale.setOnClickListener {
            grayscaleImage(dstBitmap, dstBitmap)
        }

        binding.btnMirror.setOnClickListener {
            mirrorImage(dstBitmap, dstBitmap)
        }

        binding.btnReset.setOnClickListener {
            dstBitmap = srcBitmap.copy(srcBitmap.config, true)
            binding.ivImageDst.setImageBitmap(dstBitmap)
        }
    }


    // Native stuff
    private external fun mirrorImage(bitmapIn: Bitmap, bitmapOut: Bitmap)
    private external fun grayscaleImage(bitmapIn: Bitmap, bitmapOut: Bitmap)

    companion object {
        init {
            System.loadLibrary("opencv_test")
        }
    }
}
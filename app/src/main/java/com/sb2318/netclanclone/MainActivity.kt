package com.sb2318.netclanclone


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_refine)

       // val simpleProgressBar = findViewById<ProgressBar>(R.id.progressBar)
        //simpleProgressBar.progress = 50'

        val slider = findViewById<Slider>(R.id.distanceSlider)
        slider.setLabelFormatter { value -> value.toInt().toString() }
    }
}
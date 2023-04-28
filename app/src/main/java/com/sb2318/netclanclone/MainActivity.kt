package com.sb2318.netclanclone


import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_home_layout)

        val simpleProgressBar = findViewById<ProgressBar>(R.id.progressBar)
        simpleProgressBar.progress = 50
    }
}
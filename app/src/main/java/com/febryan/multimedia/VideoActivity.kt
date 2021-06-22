package com.febryan.multimedia

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.febryan.multimedia.databinding.ActivityVideoBinding

class VideoActivity : AppCompatActivity() {

    lateinit var binding: ActivityVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Alamat video atau packagenya
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.android)

        //Tampilkan pengontrol video
        val controller = MediaController(this)
        controller.setAnchorView(binding.videoView)
        binding.videoView.setMediaController(controller)

        binding.videoView.setVideoURI(uri)
        binding.videoView.requestFocus()
        binding.videoView.start()

        binding.videoView.setOnCompletionListener {
            finish()
        }
    }
}
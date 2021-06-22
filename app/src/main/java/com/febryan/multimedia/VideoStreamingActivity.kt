package com.febryan.multimedia

import android.app.ProgressDialog
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.febryan.multimedia.databinding.ActivityVideoStreamingBinding

class VideoStreamingActivity : AppCompatActivity() {
    // titik dua di bawah ini itu sama dengan mendeklarasikan 'binding :'
    lateinit var binding : ActivityVideoStreamingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // sama dengan di bawah ini itu sama dengan mengisikan  'binding ='
        binding = ActivityVideoStreamingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val urlVideo = "https://www.dropbox.com/s/2xziljidxo1jzva/Moana.mp4?dl=1"

        val controller = MediaController(this)
        controller.setAnchorView(binding.videoViewStreaming)
        binding.videoViewStreaming.setMediaController(controller)

       val loading = ProgressDialog(this)
        loading.setMessage("Loading...")
        loading.show()

        binding.videoViewStreaming.setVideoURI(Uri.parse(urlVideo))
        binding.videoViewStreaming.requestFocus()
        binding.videoViewStreaming.setOnPreparedListener{
            it.start()
            loading.dismiss()
        }

    }
}
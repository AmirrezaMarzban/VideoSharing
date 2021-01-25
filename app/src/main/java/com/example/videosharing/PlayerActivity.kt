package com.example.videosharing

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val videoView = findViewById<View>(R.id.player) as VideoView
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        val uri: Uri = Uri.parse(intent.getStringExtra("url"))
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.setOnPreparedListener { it.isLooping = true }
        videoView.start()
    }

}
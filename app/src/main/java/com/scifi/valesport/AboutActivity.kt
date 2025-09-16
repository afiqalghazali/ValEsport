package com.scifi.valesport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.scifi.valesport.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = "https://avatars.githubusercontent.com/u/90079738?v=4"
        Glide.with(this)
            .load(url)
            .circleCrop()
            .into(binding.aboutPhoto)
    }
}
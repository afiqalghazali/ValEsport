package com.scifi.valesport

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.ColorFilterTransformation
import com.scifi.valesport.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_ESPORT = "extra_esport"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val esport = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_ESPORT, Esport::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_ESPORT)
        }

        if (esport != null) {
            Glide.with(this)
                .load(esport.photo)
                .apply(RequestOptions.bitmapTransform(ColorFilterTransformation(Color.argb(110,0,0,0))))
                .into(binding.photoEsport)
            Glide.with(this)
                .load(esport.logo)
                .into(binding.logoEsport)
            binding.esportName.text = esport.name
            binding.esportDescription.text = esport.description
            binding.details.rosters.text = esport.roster
            binding.details.achievements.text = esport.achievement
            binding.details.earning.text = esport.earning
        }

        binding.shareButton.setOnClickListener {
            shareEsportDetails(esport)
        }
    }

    private fun shareEsportDetails(esport: Esport?) {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "*Check out this Valorant esport team:*\n\n" +
                    "Name: ${esport?.name}\n\n" +
                    "Description: ${esport?.description}\n\n" +
                    "Main Roster:\n${esport?.roster}\n\n" +
                    "Total Earning: ${esport?.earning}\n\n" +
                    "Highest Achievement:\n${esport?.achievement}\n\n" +
                    esport?.site)
            type = "text/*"
        }
        startActivity(Intent.createChooser(shareIntent, null))
    }
}
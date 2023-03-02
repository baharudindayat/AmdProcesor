@file:Suppress("DEPRECATION")

package com.example.amdprocesor

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.amdprocesor.model.Model

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataProcesor = intent.getParcelableExtra<Model>("key_proc") as Model

        val imgDetailPhoto: ImageView = findViewById(R.id.imageView3)
        val tvDetailName: TextView = findViewById(R.id.textView4)
        val tvDetailspec: TextView = findViewById(R.id.specdetail)
        val tvSetDescription: TextView = findViewById(R.id.descdetail)

        Glide.with(this)
            .load(dataProcesor.photo)
            .apply(RequestOptions())
            .into(imgDetailPhoto)
        tvDetailName.text = dataProcesor.name
        tvDetailspec.text = dataProcesor.specs
        tvSetDescription.text = dataProcesor.description


        val url2: String = tvDetailName.text.toString()
        val url = "https://www.google.com/search?q= + $url2"
        val imageButton = findViewById<ImageButton>(R.id.sharebutton)

        imageButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra("Share ",url)

            val chooser = Intent.createChooser(intent,"Share using.....")
            startActivity(chooser)
        }
    }
}

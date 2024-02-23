package com.example.mydodo

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.net.URI

class DetailActivity : AppCompatActivity() {
    private val selectedImages = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val title = intent.getStringExtra("EXTRA_TITLE")
        val descr = intent.getStringExtra("EXTRA_DESCR")
        val price = intent.getStringExtra("EXTRA_PRICE")

        val detailTitleView = findViewById<TextView>(R.id.detail_title)
        val detailDescrView = findViewById<TextView>(R.id.detail_description)
        val imageView = findViewById<ImageView>(R.id.image_view)
        val detailPriceView = findViewById<Button>(R.id.button)

        detailTitleView.text = title;
        detailDescrView.text = descr;
        detailPriceView.text = "В КОРЗИНУ ЗА " + price + " KZT"

        val imageResId = intent.getIntExtra("EXTRA_IMAGE", 0)
        if (imageResId != 0) { // Проверяем, что ресурс был передан
            imageView.setImageResource(imageResId)
        }

        setupImageSelection()
    }

    private fun setupImageSelection() {
        val imageView1 = findViewById<ImageView>(R.id.imageView1)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)

        listOf(imageView1, imageView2, imageView3).forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                val id = index + 1
                if (selectedImages.contains(id)) {
                    selectedImages.remove(id)
                    imageView.alpha = 0.5f
                } else {
                    selectedImages.add(id)
                    imageView.alpha = 1f
                }
            }
        }
    }
}
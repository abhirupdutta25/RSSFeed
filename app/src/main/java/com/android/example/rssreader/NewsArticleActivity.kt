package com.android.example.rssreader

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.example.rssreader.model.Item
import kotlinx.android.synthetic.main.activity_news_article.*


class NewsArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_article)

        // TODO PHASE 2


        val extras = intent.getParcelableExtra<Item>("extras")!!
        timeAndDate.text = extras.pubDate
        title_phase2.text = extras.title
        description.text = extras.description

        floatingActionButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(extras.link)
            startActivity(intent)
        }

    }
}
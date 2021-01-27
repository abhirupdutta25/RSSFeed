package com.android.example.rssreader

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.example.rssreader.model.Item

class RSSFeedAdapter (private val feedList: MutableList<Item>): RecyclerView.Adapter<RSSFeedAdapter.FeedViewHolder>(){

    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val entryView: LinearLayout = itemView.findViewById(R.id.feedEntry)
        val dateView: TextView = itemView.findViewById(R.id.activityDate)
        val headView: TextView = itemView.findViewById(R.id.activityHead)
        val subheadView: TextView = itemView.findViewById(R.id.activitySubhead)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.rss_feed_item, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.dateView.text = feedList[position].pubDate
        holder.headView.text = feedList[position].title
        holder.subheadView.text =feedList[position].description

        holder.entryView.setOnClickListener{
            val intent = Intent(it.context, NewsArticleActivity::class.java)

            startActivity(it.context,intent, null)
//            println("Have to open the link on page 3 here")
        }
    }

    override fun getItemCount(): Int {
        return feedList.size
    }
}
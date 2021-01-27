package com.android.example.rssreader

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
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
        val view = layoutInflater.inflate(R.layout.feed_topic, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.dateView.text = feedList[position].pubDate
        holder.headView.text = feedList[position].title
        holder.subheadView.text =feedList[position].description

        holder.entryView.setOnClickListener{
            //TODO onclick page 3 with link
            println("Have to open the link on page 3 here")
        }
    }

    override fun getItemCount(): Int {
        return feedList.size
    }
}
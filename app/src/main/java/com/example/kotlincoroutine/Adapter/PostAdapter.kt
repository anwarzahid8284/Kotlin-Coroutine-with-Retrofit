package com.example.kotlincoroutine.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincoroutine.Model.Post
import com.example.kotlincoroutine.R

class PostAdapter(private val context: Context, private var postList: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostVHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVHolder {
        return PostVHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        )
    }

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: PostVHolder, position: Int) {
        val post = postList[position]
        holder.id.text = post.id.toString()
        holder.title.text = post.title

    }

    class PostVHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.textID)
        val title: TextView = itemView.findViewById(R.id.textTitleID)

    }

    fun setPost(postList: List<Post>) {
        this.postList = postList
        notifyDataSetChanged()
    }
}
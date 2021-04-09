package com.example.kotlincoroutine.Activity

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincoroutine.Adapter.PostAdapter
import com.example.kotlincoroutine.Model.Post
import com.example.kotlincoroutine.R
import com.example.kotlincoroutine.Repository.PostRepository
import com.example.kotlincoroutine.ViewModel.PostViewModel
import com.example.kotlincoroutine.ViewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var postAdapter: PostAdapter
    lateinit var viewModel: PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        val postRepository=PostRepository()
        val viewModelFactory=ViewModelFactory(postRepository)
        viewModel=ViewModelProvider(this,viewModelFactory)[PostViewModel::class.java]
        viewModel.liveData()
        viewModel.postLiveData.observe(this, Observer {
             postAdapter.setPost(it as ArrayList<Post>)
            progressbarID.visibility=View.GONE
            recyclerView.visibility=View.VISIBLE
        })

    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.post_recyclerViewID)
        postAdapter= PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=postAdapter
        }
    }
}
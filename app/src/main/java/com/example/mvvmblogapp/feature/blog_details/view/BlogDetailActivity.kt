package com.example.mvvmblogapp.feature.blog_details.view

import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mvvmblogapp.databinding.ActivityBlogDetailBinding
import com.example.mvvmblogapp.feature.blog_list.viewModel.BlogItemUiModel

class BlogDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlogDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val blogItem = intent.getSerializableExtra("blog") as BlogItemUiModel

        Glide.with(this).load(blogItem.imageUrl).into(binding.imageViewFeatured)

        binding.tvTitle.text = blogItem.title
        binding.tvDate.text = blogItem.date
        binding.tvExcerpt.text = Html.fromHtml(blogItem.excerpt, Html.FROM_HTML_MODE_COMPACT)
        binding.tvContent.text = Html.fromHtml(blogItem.content, Html.FROM_HTML_MODE_COMPACT)
    }
}
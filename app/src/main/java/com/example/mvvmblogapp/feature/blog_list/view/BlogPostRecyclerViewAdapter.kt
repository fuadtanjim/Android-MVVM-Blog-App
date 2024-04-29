package com.example.mvvmblogapp.feature.blog_list.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmblogapp.R
import com.example.mvvmblogapp.databinding.ItemBlogPostBinding
import com.example.mvvmblogapp.feature.blog_details.view.BlogDetailActivity
import com.example.mvvmblogapp.feature.blog_list.viewModel.BlogItemUiModel

class BlogPostRecyclerViewAdapter(private val blogList: List<BlogItemUiModel>) : RecyclerView.Adapter<BlogPostRecyclerViewAdapter.BlogPostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogPostViewHolder {
        val binding = ItemBlogPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BlogPostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return blogList.size
    }

    override fun onBindViewHolder(holder: BlogPostViewHolder, position: Int) {
        val blogPost = blogList[position]
        holder.bind(blogPost)
    }

    inner class BlogPostViewHolder(private val binding: ItemBlogPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(blogPost: BlogItemUiModel) {
            Glide.with(itemView.context).load(blogPost.imageUrl).error(R.drawable.ic_launcher_foreground).into(binding.imageViewFeatured)
            binding.tvTitle.text = blogPost.title
            binding.tvDate.text = blogPost.date

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, BlogDetailActivity::class.java)
                intent.putExtra("blog", blogPost)
                binding.root.context.startActivity(intent)
            }

        }
    }
}
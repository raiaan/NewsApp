package com.example.myapplication.ui.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.models.Articles
import com.example.myapplication.databinding.ArticleItemBinding

class ArticleListAdapter : RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder>(){
    var articles =  listOf<Articles>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ArticleItemBinding.inflate( LayoutInflater.from(parent.context),
            parent, false)
        return ArticleViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val context = holder.itemView.context
        Glide.with(context)
            .load(articles[position].urlToImage)
            .into(holder.binding.mainArticleImg)
        holder.binding.mainArticleTitle.text = articles[position].title
        holder.binding.dateArticleTitle.text = articles[position].publishedAt
    }

    override fun getItemCount(): Int {
        return articles.size
    }
    class ArticleViewHolder(val binding: ArticleItemBinding) : RecyclerView.ViewHolder(binding.root)
}
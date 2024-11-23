package com.example.project_mobile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_mobile.R
import com.example.project_mobile.models.Blog
import com.example.project_mobile.models.Clinic

class BlogCardAdapter(
    private val dataList: ArrayList<Blog>
) : RecyclerView.Adapter<BlogCardAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener ?= null;

    public fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    public interface OnClickListener {
        fun onItemClick(position: Int, blog: Blog)
        fun onHeartButtonClick(position: Int, blog: Blog)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val blogTitle = itemView.findViewById<TextView>(R.id.txtBlogTitle)
        val blogImage = itemView.findViewById<com.google.android.material.imageview.ShapeableImageView>(R.id.blogImage)
        val blogAuthorImage = itemView.findViewById<com.google.android.material.imageview.ShapeableImageView>(R.id.blogAuthorImage)
        val blogAuthorName = itemView.findViewById<TextView>(R.id.txtBlogAuthorName)
        val blogTime = itemView.findViewById<TextView>(R.id.txtBlogTime)
        val blogRating = itemView.findViewById<TextView>(R.id.txtBlogRating)

        val heartBtn = itemView.findViewById<ImageButton>(R.id.btnFavourite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.blog_card_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
//        holder.blogTitle.text = currentItem.title
        holder.blogAuthorName.text = currentItem.author.name
//        holder.blogTime.text = currentItem.date
        holder.blogRating.text = currentItem.rating.toString()

        holder.heartBtn.setOnClickListener {
            onClickListener?.onHeartButtonClick(position, dataList[position])
        }

        holder.itemView.setOnClickListener(View.OnClickListener {
            onClickListener?.onItemClick(position, dataList[position])
        })

    }

}
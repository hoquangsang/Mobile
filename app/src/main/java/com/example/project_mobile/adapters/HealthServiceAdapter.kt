package com.example.project_mobile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_mobile.models.HealthService

import com.example.project_mobile.R

class HealthServiceAdapter(
    private val dataList: ArrayList<HealthService>
) : RecyclerView.Adapter<HealthServiceAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener ?= null;

    public fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    public interface OnClickListener {
        fun onItemClick(position: Int, healthService: HealthService)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val serviceName = itemView.findViewById<TextView>(R.id.txtHealthServiceName)
        val serviceImage = itemView.findViewById<ImageView>(R.id.imgHealthServiceIcon)

        init {
            itemView.setOnClickListener {
                onClickListener?.onItemClick(adapterPosition, dataList[adapterPosition])
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_health_service, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.serviceName.text = currentItem.name
        holder.serviceImage.setImageResource(currentItem.imageRes)

        holder.itemView.setOnClickListener(View.OnClickListener {
            onClickListener?.onItemClick(position, dataList[position])
        })
    }
}
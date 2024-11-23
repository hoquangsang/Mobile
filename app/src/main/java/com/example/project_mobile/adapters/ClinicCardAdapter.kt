package com.example.project_mobile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_mobile.R
import com.example.project_mobile.models.Clinic
import com.example.project_mobile.models.User

class ClinicCardAdapter(
    private val dataList: ArrayList<Clinic>
) : RecyclerView.Adapter<ClinicCardAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener ?= null;

    public fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    public interface OnClickListener {
        fun onItemClick(position: Int, clinic: Clinic)
        fun onHeartButtonClick(position: Int, clinic: Clinic)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clinicName = itemView.findViewById<TextView>(R.id.txtClinicName)
        val clinicLocation = itemView.findViewById<TextView>(R.id.txtClinicLocation)
        val clinicImage = itemView.findViewById<com.google.android.material.imageview.ShapeableImageView>(R.id.clinicImage)
        val heartBtn = itemView.findViewById<ImageButton>(R.id.heartBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.clinic_card_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.clinicName.text = currentItem.name
        holder.clinicLocation.text = currentItem.address

        holder.heartBtn.setOnClickListener {
            onClickListener?.onHeartButtonClick(position, dataList[position])
        }

        holder.itemView.setOnClickListener(View.OnClickListener {
            onClickListener?.onItemClick(position, dataList[position])
        })
    }
}
package com.example.project_mobile.adapters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_mobile.models.User

import com.example.project_mobile.R
import com.example.project_mobile.models.HealthService
import java.util.Base64

class DoctorCardAdapter(
    private val dataList: ArrayList<User>
) : RecyclerView.Adapter<DoctorCardAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener ?= null;

    public fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    public interface OnClickListener {
        fun onItemClick(position: Int, doctor: User)
        fun onHeartButtonClick(position: Int, doctor: User)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val doctorName = itemView.findViewById<TextView>(R.id.txtDoctorName)
        val doctorSpecialty = itemView.findViewById<TextView>(R.id.txtDoctorSpeciality)
        val doctorLocation = itemView.findViewById<TextView>(R.id.txtDoctorLocation)
        val doctorImage = itemView.findViewById<com.google.android.material.imageview.ShapeableImageView>(R.id.doctorImage)
        var heartBtn = itemView.findViewById<ImageButton>(R.id.heartBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.doctor_card_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.doctorName.text = currentItem.name
        holder.doctorSpecialty.text = currentItem.specialty
        holder.doctorLocation.text = currentItem.address
//        holder.doctorImage.setImageBitmap(stringToBitmap(currentItem.image))

        holder.heartBtn.setOnClickListener {
            onClickListener?.onHeartButtonClick(position, dataList[position])
        }

        holder.itemView.setOnClickListener(View.OnClickListener {
            onClickListener?.onItemClick(position, dataList[position])
        })
    }

    private fun stringToBitmap(encodedString: String): Bitmap {
        val encodeByte = Base64.getDecoder().decode(encodedString)
        return BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
    }


}
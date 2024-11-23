package com.example.project_mobile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_mobile.R
import com.example.project_mobile.models.UserPopupMenuItem

class UserPopupMenuAdapter (
    private val menuItems: ArrayList<UserPopupMenuItem>
) : RecyclerView.Adapter<UserPopupMenuAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener ?= null;

    public fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    public interface OnClickListener {
        fun onItemClick(position: Int, menuItem: UserPopupMenuItem)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val parentLayout = itemView.findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.menuItem)
        val icon: ImageView = itemView.findViewById<ImageView>(R.id.menuItemIcon)
        val title: TextView = itemView.findViewById<TextView>(R.id.txtMenuItemTitle)

        init {
            itemView.setOnClickListener {
                onClickListener?.onItemClick(adapterPosition, menuItems[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserPopupMenuAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_menu_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserPopupMenuAdapter.ViewHolder, position: Int) {
        val currentItem = menuItems[position]
        holder.icon.setImageResource(currentItem.icon)
        holder.title.text = currentItem.title

        if (position == menuItems.size - 1) {
            holder.parentLayout.setPadding(0, 0, 0, 0)
        }

        holder.itemView.setOnClickListener(View.OnClickListener {
            onClickListener?.onItemClick(position, menuItems[position])
        })
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }


}
package com.example.project_mobile.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.project_mobile.R
import com.example.project_mobile.adapters.UserPopupMenuAdapter
import com.example.project_mobile.models.UserPopupMenuItem
import com.example.project_mobile.utils.CustomDividerItemDecoration

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlogFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blog, container, false)

        val useAvatar = view.findViewById<com.google.android.material.imageview.ShapeableImageView>(R.id.useAvatar)
        useAvatar.setOnClickListener {
            showCustomPopupMenu(useAvatar)
        }

        return view;
    }

    private fun showCustomPopupMenu(viewAnchor: View) {
        val popupView: View = LayoutInflater.from(requireContext()).inflate(R.layout.user_popup_menu, null)

        val popupWindow: PopupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )

        val recyclerView = popupView.findViewById<RecyclerView>(R.id.recyclerViewUserMenu)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val itemDecoration: ItemDecoration = com.example.project_mobile.utils.SpacingItemDecorator(
            left = 0,
            top = 0,
            right = 0,
            bottom = 30
        )
        val underlineItemDecoration: ItemDecoration = CustomDividerItemDecoration(requireContext(), R.drawable.recyclerview_divider)

        recyclerView.addItemDecoration(itemDecoration)
        recyclerView.addItemDecoration(underlineItemDecoration)

        val menuItems = ArrayList<UserPopupMenuItem>();
        menuItems.add(UserPopupMenuItem(R.drawable.ic_compose, "Viết bài viết"))
        menuItems.add(UserPopupMenuItem(R.drawable.ic_username, "Bài viết của tôi"))
        menuItems.add(UserPopupMenuItem(R.drawable.baseline_bookmark_border_24, "Bài viết đã lưu"))

        val adapter = UserPopupMenuAdapter(menuItems)
        adapter.setOnClickListener(object : UserPopupMenuAdapter.OnClickListener {
            override fun onItemClick(position: Int, menuItem: UserPopupMenuItem) {
                when (position) {
                    0 -> {
                        // Write a post
                        Toast.makeText( requireContext(), "1", Toast.LENGTH_SHORT).show()
                    }
                    1 -> {
                        // My posts
                        Toast.makeText( requireContext(), "2", Toast.LENGTH_SHORT).show()
                    }
                    2 -> {
                        // Saved posts
                        Toast.makeText( requireContext(), "3", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        recyclerView.adapter = adapter

        popupWindow.showAsDropDown(viewAnchor, 0, 0)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
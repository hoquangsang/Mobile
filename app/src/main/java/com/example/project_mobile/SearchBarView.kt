package com.example.project_mobile

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageButton

class SearchBarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : androidx.constraintlayout.widget.ConstraintLayout(context, attrs, defStyleAttr) {

    private val editText: EditText
    private val filterButton: ImageButton

    init {
        // Inflate layout từ res/layout/search_bar.xml
        LayoutInflater.from(context).inflate(R.layout.search_bar, this, true)

        // Tìm các view trong file search_bar.xml
        editText = findViewById(R.id.edtSearch)
        filterButton = findViewById(R.id.filterBtn)

    }

    fun setOnSearchBarClickListener(listener: () -> Unit) {
        this.setOnClickListener {
            listener()
        }

        editText.setOnClickListener {
            listener()
        }

        filterButton.setOnClickListener {
            listener()
        }
    }

    fun setOnSearchListener(listener: (String) -> Unit) {
        editText.setOnEditorActionListener { _, _, _ ->
            listener(editText.text.toString())
            true
        }
    }

    fun setOnFilterListener(listener: () -> Unit) {
        filterButton.setOnClickListener {
            listener()
        }
    }

    fun getSearchText(): String {
        return editText.text.toString()
    }

    fun disableChildFocus() {
        editText.isClickable = false
        editText.isFocusable = false
        editText.isFocusableInTouchMode = false
    }
}
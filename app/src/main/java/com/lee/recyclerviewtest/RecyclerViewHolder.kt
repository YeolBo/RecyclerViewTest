package com.lee.recyclerviewtest

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class RecyclerViewHolder(
    itemView: View,
    iRecyclerView: IRecyclerView,
    var onItemClicked: () -> Unit,
    var onItemDeleted: (Int) -> Unit,
) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    companion object {
        const val TAG: String = "로그"
    }

    private val editText = itemView.edit_text

    private var iRecyclerView: IRecyclerView? = null

    init {
        this.iRecyclerView = iRecyclerView
        this.itemView.info_btn.setOnClickListener (this)
        this.itemView.delete_btn.setOnClickListener (this)
    }

    fun bind(chat: Model) {
        editText.text = chat.chat
        onItemClicked.invoke()
        onItemDeleted
    }

    override fun onClick(v: View?) {
        when (v) {
            this.itemView.delete_btn -> {
                Log.d(TAG, "onClick: 삭제클릭")
            }
            this.itemView.info_btn -> {
                Log.d(TAG, "onClick: 수정클릭")
            }
        }
    }
}

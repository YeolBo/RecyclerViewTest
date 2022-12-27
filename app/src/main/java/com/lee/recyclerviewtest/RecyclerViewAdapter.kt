package com.lee.recyclerviewtest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    iRecyclerView: IRecyclerView,
    var onItemClicked: () -> Unit,
    var onItemDeleted: (Int) -> Unit
): RecyclerView.Adapter<RecyclerViewHolder>() {

    private var iRecyclerView: IRecyclerView? = null

    private var chatList: ArrayList<Model> = ArrayList<Model>()

    init{
        this.iRecyclerView = iRecyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_item, parent, false),
            iRecyclerView!!,
            onItemClicked,
            onItemDeleted
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(this.chatList[position])
    }

    override fun getItemCount(): Int {
        return this.chatList.size
    }

    fun submitList(chatList: ArrayList<Model>){
        this.chatList = chatList
    }
}
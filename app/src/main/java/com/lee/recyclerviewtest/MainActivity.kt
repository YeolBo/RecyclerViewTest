package com.lee.recyclerviewtest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IRecyclerView {

    companion object {
        const val TAG: String = "로그"
    }

    var chatList = arrayListOf<Model>()

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    @SuppressLint("NotifyDataSetChanged")
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewAdapter = RecyclerViewAdapter(this,
            onItemClicked = {
                Toast.makeText(this, "$", Toast.LENGTH_SHORT).show()
            },
            onItemDeleted = {
                this.chatList.removeAt(it)
                recyclerViewAdapter.notifyItemRemoved(it)
            }
        )

        this.recyclerViewAdapter.submitList(chatList)

        recycler_view.layoutManager = GridLayoutManager(
            this,
            1,
            GridLayoutManager.VERTICAL,
            false
        )
        recycler_view.adapter = this.recyclerViewAdapter

        text_input_btn.setOnClickListener {
            val userInput = edit_text.text.toString()

            Log.d(TAG, "userInput : $userInput")

            this.chatList.add(Model(chat = userInput))
            recyclerViewAdapter.notifyItemChanged(this.chatList.lastIndex)
//            this.recycler_view.scrollToPosition(this.chatList.lastIndex)
            recyclerViewAdapter.notifyDataSetChanged()
        }

    }
}
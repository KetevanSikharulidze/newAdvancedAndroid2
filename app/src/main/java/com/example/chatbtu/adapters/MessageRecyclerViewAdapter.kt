package com.example.chatbtu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chatbtu.R
import com.example.chatbtu.databinding.ItemMessageBinding
import com.example.chatbtu.models.Messages

class MessageRecyclerViewAdapter(private val listItem: MutableList<Messages>)
    : RecyclerView.Adapter<MessageRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemMessageBinding.bind(itemView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MessageRecyclerViewAdapter.MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_message,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageRecyclerViewAdapter.MyViewHolder, position: Int) {
        val items = listItem[position]
        holder.binding.apply {
            userNameTextView.text = items.username
            messageTextView.text = items.message
            messageSentTimeTextView.text = items.time
            Glide.with(root).load(items.image).into(userImageView)
        }
    }

    override fun getItemCount() = listItem.size
}
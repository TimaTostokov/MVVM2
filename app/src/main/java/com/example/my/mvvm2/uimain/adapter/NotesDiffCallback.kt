package com.example.my.mvvm2.uimain.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.my.mvvm2.room.Note

class NoteDiffCallback : DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean = oldItem == newItem
}
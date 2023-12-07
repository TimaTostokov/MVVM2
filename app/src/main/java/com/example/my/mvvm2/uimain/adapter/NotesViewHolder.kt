package com.example.my.mvvm2.uimain.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my.mvvm2.databinding.NoteListItemBinding
import com.example.my.mvvm2.room.Note

class NoteViewHolder(
    private val binding: NoteListItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

    var item: Note? = null

    fun onBind(item: Note) {
        this.item = item

        views {
            captionTextView.text = item.caption
            noteTextView.text = item.text
        }
    }

    private fun <T> views(block: NoteListItemBinding.() -> T): T? = binding.block()

    companion object {
        fun create(parent: ViewGroup) = NoteListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).let(::NoteViewHolder)
    }

}
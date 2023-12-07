package com.example.my.mvvm2.uimain.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.my.mvvm2.room.Note

class NotesAdapter : ListAdapter<Note, NoteViewHolder>(NoteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder = NoteViewHolder.create(parent)

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = holder.onBind(getItem(position))

}
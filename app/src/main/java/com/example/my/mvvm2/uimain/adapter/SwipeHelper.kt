package com.example.my.mvvm2.uimain.adapter


import androidx.recyclerview.widget.ItemTouchHelper
import com.example.my.mvvm2.room.Note

class SwipeHelper(onSwiped: (Note) -> Unit) : ItemTouchHelper(SwipeCallback(onSwiped))
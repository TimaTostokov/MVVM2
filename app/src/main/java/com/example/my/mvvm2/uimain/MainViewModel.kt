package com.example.my.mvvm2.uimain

import android.text.format.DateFormat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my.mvvm2.locator.locateLazy
import com.example.my.mvvm2.repository.Repository
import com.example.my.mvvm2.room.Note
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import java.util.Date

class MainViewModel : ViewModel() {

    private val repository: Repository by locateLazy()

    val notes = repository.getAll().asLiveDataFlow()
    val newCaption = flow<String> {
        while (true) {
            emit(createCaption())
            delay(500L)
        }
    }

    fun save(note: String) {
        viewModelScope.launch {
            repository.save(createNote(note))
        }
    }

    fun delete(note: Note) {
        viewModelScope.launch {
            repository.delete(note)
        }
    }

    private fun createNote(noteText: String) = Note(
        caption = createCaption(),
        text = noteText
    )

    private fun createCaption(): String = DateFormat.format("hh:mm:ss, MMM dd, yyyy", Date()).toString()

    private fun <T> Flow<T>.asLiveDataFlow() = shareIn(viewModelScope, SharingStarted.Eagerly, replay = 1)
}
package com.example.my.mvvm2

import android.app.Application
import android.content.Context
import com.example.my.mvvm2.locator.ServiceLocator
import com.example.my.mvvm2.locator.locate
import com.example.my.mvvm2.repository.Repository
import com.example.my.mvvm2.room.NotesDatabase
import com.example.my.mvvm2.room.NotesDatabaseImpl

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ServiceLocator.register<Context>(this)
        ServiceLocator.register<NotesDatabase>(NotesDatabaseImpl.create(locate()))
        ServiceLocator.register(Repository(locate()))
    }

}

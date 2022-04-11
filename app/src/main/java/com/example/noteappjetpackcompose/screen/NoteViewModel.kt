package com.example.noteappjetpackcompose.screen


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.noteappjetpackcompose.data.NoteaDataSource
import com.example.noteappjetpackcompose.model.Note

class NoteViewModel : ViewModel() {

    var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NoteaDataSource().loadNotes())
    }
    fun addNote(note: Note) {
        noteList.add(note)
    }

    fun removeNote(note: Note) {
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note>{
        return noteList
    }
}
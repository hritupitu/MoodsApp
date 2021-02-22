package com.android.example.moods.data

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {


    // TODO PHASE 2.0: Define getAllNotes method - call noteDao to get all notes
    val getAllNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    // TODO PHASE 2.0: Define addNote method - call noteDao to insert note
    suspend fun addNote(note: Note){
        noteDao.addNote(note)
    }

    // TODO PHASE 2.0: Define updateNote method - call noteDao to update note
    suspend fun updateNote(note: Note){
        noteDao.updateNote(note)
    }

    // TODO PHASE 2.0: Define deleteNote method - call noteDao to delete note
    suspend fun deleteNote(note : Note){
        noteDao.deleteNote(note)
    }
}
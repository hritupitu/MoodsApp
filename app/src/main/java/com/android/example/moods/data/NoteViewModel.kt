package com.android.example.moods.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {
    // TODO PHASE 2.0: declare member variables getAllNotes and repository
    val getAllNotes: LiveData<List<Note>>
    private val repository: NoteRepository

    // TODO PHASE 2.0: initialize noteDao, repository and getAllNotes

    init{
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        getAllNotes = repository.getAllNotes
    }

    // TODO PHASE 2.0: Define addNote method - call repository inside of a viewModelScope to add note
    fun addNote(note : Note){
        viewModelScope.launch(Dispatchers.IO){
            repository.addNote(note)
        }
    }

    // TODO PHASE 2.0: Define updateNote method - call repository inside of a viewModelScope to update note
    fun updateNote(note: Note){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateNote(note)
        }
    }

    // TODO PHASE 2.0: Define deleteNote method - call repository inside of a viewModelScope to delete note
    fun deleteNode(note: Note){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteNote(note)
        }
    }
}
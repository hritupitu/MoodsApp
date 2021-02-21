package com.android.example.moods.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    // TODO PHASE 2.0: Define Query to get all Notes
    @Query ("SELECT * FROM note_table")
    fun getAllNotes (): LiveData<List<Note>>

    // TODO PHASE 2.0: Define Query to update a Note
    @Update
    fun updateNote (notes : Note)

    // TODO PHASE 2.0: Define Query to insert a Note
    @Insert
    fun addNote (notes: Note)

    // TODO PHASE 2.0: Define Query to delete a Note
    @Delete
    fun deleteNote (notes: Note)
}
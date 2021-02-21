package com.android.example.moods.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    // TODO PHASE 2.0: Declare abstract noteDao Function
    abstract fun noteDao(): NoteDao

    // TODO PHASE 2.0: Define companion object that returns an instance of the NoteDatabase
    companion object{
        @Volatile
        private var NOTEINSTANCE: NoteDatabase? = null

        fun getDatabase(context : Context): NoteDatabase{
            val tempNoteInstance = NOTEINSTANCE
            if(tempNoteInstance != null){
                return tempNoteInstance
            }
            synchronized(this){
                val noteInstance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "Note_DataBase"
                ).build()
                NOTEINSTANCE = noteInstance
                return noteInstance
            }
        }
    }
}
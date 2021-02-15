package com.android.example.moods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.android.example.moods.data.Note
import com.android.example.moods.data.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_create_note.*

class CreateNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO PHASE 1.2: Add on click listener to the submission FAB that calls insertNoteIntoDB()


        // TODO PHASE 1.2: Add on click listener to the cancellation FAB


        // TODO PHASE 1.2: Add on click listener to Mood Images to select the one that was clicked last
    }


    // TODO TIP: It might be helpful to create a function that resets all the mood images to be w/o outlines


    private fun insertNoteIntoDB() {
        // TODO PHASE 2.1: Create Note Object from data inputted and add Note to Database using NoteViewModel


        // TODO PHASE 1.2: Use the Navigation Controller to switch to NoteFeedFragment
    }
}
package com.android.example.moods

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.example.moods.data.Note
import com.android.example.moods.data.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_create_note.*

class CreateNoteFragment : Fragment() {

    lateinit var sadFace : ImageView
    lateinit var happyFace : ImageView
    lateinit var contentFace : ImageView
    lateinit var anxiousFace : ImageView
    lateinit var madFace : ImageView
    lateinit var neutralFace : ImageView
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
        floatingActionButton1.setOnClickListener{
            //This is the add floating action button
            val action = CreateNoteFragmentDirections.actionCreateNoteFragmentToNoteFeedFragment()
            findNavController().navigate(action)
            // TODO Abhirup: Connect this to db
        }


        // TODO PHASE 1.2: Add on click listener to the cancellation FAB
        floatingActionButton2.setOnClickListener{
            val action = CreateNoteFragmentDirections.actionCreateNoteFragmentToNoteFeedFragment()
            findNavController().navigate(action)
        }


        // TODO PHASE 1.2: Add on click listener to Mood Images to select the one that was clicked last

        sadFace = view.findViewById<ImageView>(R.id.sad)
        happyFace = view.findViewById<ImageView>(R.id.happy)
        contentFace = view.findViewById<ImageView>(R.id.content)
        anxiousFace = view.findViewById<ImageView>(R.id.anxious)
        madFace = view.findViewById<ImageView>(R.id.mad)
        neutralFace = view.findViewById<ImageView>(R.id.neutral)
        sadFace.setOnClickListener{
            resetImages()
            sadFace.setImageResource(R.drawable.ic_sad_outline_true)
        }
        happyFace.setOnClickListener{
            resetImages()
            happyFace.setImageResource(R.drawable.ic_happy_outline_true)
        }
        contentFace.setOnClickListener{
            resetImages()
            contentFace.setImageResource(R.drawable.ic_content_outline_true)
        }
        anxiousFace.setOnClickListener{
            resetImages()
            anxiousFace.setImageResource(R.drawable.ic_anxious_outline_true)
        }
        madFace.setOnClickListener{
            resetImages()
            madFace.setImageResource(R.drawable.ic_mad_outline_true)
        }
        neutralFace.setOnClickListener{
            resetImages()
            neutralFace.setImageResource(R.drawable.ic_neutral_outline_true)
        }

    }


    // TODO TIP: It might be helpful to create a function that resets all the mood images to be w/o outlines

    private fun resetImages(){
        sadFace.setImageResource(R.drawable.ic_sad_outline_false)
        happyFace.setImageResource(R.drawable.ic_happy_outline_false)
        contentFace.setImageResource(R.drawable.ic_content_outline_false)
        anxiousFace.setImageResource(R.drawable.ic_anxious_outline_false)
        madFace.setImageResource(R.drawable.ic_mad_outline_false)
        neutralFace.setImageResource(R.drawable.ic_neutral_outline_false)

    }

    private fun insertNoteIntoDB() {
        // TODO PHASE 2.1: Create Note Object from data inputted and add Note to Database using NoteViewModel


        // TODO PHASE 1.2: Use the Navigation Controller to switch to NoteFeedFragment
    }
}
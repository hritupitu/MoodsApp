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
import androidx.navigation.fragment.navArgs
import androidx.room.Update
import com.android.example.moods.data.Note
import com.android.example.moods.data.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_update_note.*

class UpdateNoteFragment : Fragment() {

    val args: UpdateNoteFragmentArgs by navArgs()
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
        return inflater.inflate(R.layout.fragment_update_note, container, false)
    }


    private fun resetImages(){
        sadFace.setImageResource(R.drawable.ic_sad_outline_false)
        happyFace.setImageResource(R.drawable.ic_happy_outline_false)
        contentFace.setImageResource(R.drawable.ic_content_outline_false)
        anxiousFace.setImageResource(R.drawable.ic_anxious_outline_false)
        madFace.setImageResource(R.drawable.ic_mad_outline_false)
        neutralFace.setImageResource(R.drawable.ic_neutral_outline_false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var react = "empty"
        // TODO PHASE 1.4: Set Data on screen by grabbing Note from safe args
        //  (EditTexts, ImageViews, and so on ...)
        val title = args.currentNote.title
        val content = args.currentNote.content
        val reaction = args.currentNote.reaction
        titleupdate.setText(title)
        contentupdate.setText(content)
        sadFace = view.findViewById<ImageView>(R.id.sad)
        happyFace = view.findViewById<ImageView>(R.id.happy)
        contentFace = view.findViewById<ImageView>(R.id.content)
        anxiousFace = view.findViewById<ImageView>(R.id.anxious)
        madFace = view.findViewById<ImageView>(R.id.mad)
        neutralFace = view.findViewById<ImageView>(R.id.neutral)
        sadFace.setOnClickListener{
            resetImages()
            sadFace.setImageResource(R.drawable.ic_sad_outline_true)
            react = "sad"
        }
        happyFace.setOnClickListener{
            resetImages()
            happyFace.setImageResource(R.drawable.ic_happy_outline_true)
            react = "happy"
        }
        contentFace.setOnClickListener{
            resetImages()
            contentFace.setImageResource(R.drawable.ic_content_outline_true)
            react = "content"
        }
        anxiousFace.setOnClickListener{
            resetImages()
            anxiousFace.setImageResource(R.drawable.ic_anxious_outline_true)
            react = "anxious"
        }
        madFace.setOnClickListener{
            resetImages()
            madFace.setImageResource(R.drawable.ic_mad_outline_true)
            react = "mad"
        }
        neutralFace.setOnClickListener{
            resetImages()
            neutralFace.setImageResource(R.drawable.ic_neutral_outline_true)
            react = "neutral"
        }


        // TODO PHASE 1.4: Add an on click listener to the submission FAB that
        //  calls updateNoteIntoDB()
        floatingok.setOnClickListener {
            updateNoteIntoDB()
        }



        // TODO PHASE 1.4: Add an on click listener to the cancellation FAB that
        //  sends the user back to NoteFeedFragment

        floatingdel2.setOnClickListener {
            val action = UpdateNoteFragmentDirections.actionUpdateNoteFragmentToNoteFeedFragment()
            findNavController().navigate(action)
        }


        // TODO PHASE 1.4: Add an on click listeners to Mood Images to select
        //  the one that was clicked last
    }

    private fun updateNoteIntoDB() {
        // TODO PHASE 2.4: Create(or update) a Note Object from data inputted on the screen
        //  and add said Note to Database using NoteViewModel


        // TODO PHASE 1.4: Use the Navigation Controller to switch to NoteFeedFragment
        val action = UpdateNoteFragmentDirections.actionUpdateNoteFragmentToNoteFeedFragment()
        findNavController().navigate(action)
    }



    // Feel free to use/update this function if you find parts of it useful for your implementation
    private fun setMoodImage(view: ImageView, mood: String) {
        when (mood) {
            "anxious" -> view.setImageResource(R.drawable.ic_anxious_outline_false)
            "content" -> view.setImageResource(R.drawable.ic_content_outline_false)
            "happy" -> view.setImageResource(R.drawable.ic_happy_outline_false)
            "mad" -> view.setImageResource(R.drawable.ic_mad_outline_false)
            "neutral" -> view.setImageResource(R.drawable.ic_neutral_outline_false)
            "sad" -> view.setImageResource(R.drawable.ic_sad_outline_false)
            else -> {
                view.setImageResource(R.drawable.ic_empty_state)
            }
        }
    }
}
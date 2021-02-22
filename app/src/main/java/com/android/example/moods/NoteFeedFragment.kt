package com.android.example.moods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.example.moods.data.Note
import com.android.example.moods.data.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_note_feed.*

class NoteFeedFragment : Fragment() {

    lateinit var rv : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val noteListAdapter = NoteListAdapter()
//        if (noteListAdapter.itemCount==0)
//        {
//            val action = NoteFeedFragmentDirections.actionNoteFeedFragmentToEmptyCase()
//            findNavController().navigate(action)
//        }
        this.rv = view.findViewById<RecyclerView>(R.id.NoteRecyclerView)
        this.rv.layoutManager=LinearLayoutManager(view.context)
        this.rv.adapter = noteListAdapter
        //  you may fill the recyclerview with dummy data to test it out
        //  but you'll want to remove the dummy data when working on Phase 2



        // TODO PHASE 1.1: Add an on click listener to the '+' FAB
        //  and use the Navigation Controller to navigation to the CreateNoteFragment
        floatingActionButtonNoteFeed.setOnClickListener{
            val action = R.id.action_noteFeedFragment_to_createNoteFragment
            findNavController().navigate(action)
        }

        // TODO PHASE 2.2: Connect to the NoteViewModel and use it to update the RecyclerView's list
        //  Hint: Look at NoteListAdapter's setData method
        val myNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        myNoteViewModel.getAllNotes.observe(viewLifecycleOwner, Observer { note -> noteListAdapter.setData(note) })
    }
}
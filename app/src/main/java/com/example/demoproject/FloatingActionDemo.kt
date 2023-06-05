package com.example.demoproject

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FloatingActionDemo.newInstance] factory method to
 * create an instance of this fragment.
 */
class FloatingActionDemo : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_floating_action_demo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val livedata = MutableLiveData<String>("")
        livedata.observe(viewLifecycleOwner) {
            Log.e("data", it)
        }
        livedata.postValue("New value")
        val btnFloatingAction = view.findViewById<FloatingActionButton>(R.id.btnAddFloating)
        val floatingExpandable = view.findViewById<ExtendedFloatingActionButton>(R.id.add_fab)
        val helpFloating = view.findViewById<FloatingActionButton>(R.id.help_fab)
        val addFloating = view.findViewById<FloatingActionButton>(R.id.add_fab2)

        var isAllFabsVisible = false
        floatingExpandable.shrink()

        floatingExpandable.setOnClickListener {
            if (!isAllFabsVisible) {
                isAllFabsVisible = !isAllFabsVisible
                addFloating.show()
                helpFloating.show()
                floatingExpandable.extend()
            } else {
                isAllFabsVisible = !isAllFabsVisible
                addFloating.hide()
                helpFloating.hide()
                floatingExpandable.shrink()
            }
        }

        helpFloating.visibility = View.GONE
        addFloating.visibility = View.GONE

        btnFloatingAction.setOnClickListener {
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
            livedata.postValue("Fab button clicked")
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FloatingActionDemo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FloatingActionDemo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
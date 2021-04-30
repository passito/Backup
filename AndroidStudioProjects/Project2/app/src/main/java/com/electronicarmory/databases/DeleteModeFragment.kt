package com.electronicarmory.databases

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DeleteModeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DeleteModeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var DeleteAllButton: Button
    lateinit var DeleteButton: Button
    lateinit var titleEditText: EditText

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
        val view = inflater.inflate(R.layout.fragment_todo_delete, container, false)
        titleEditText = view.findViewById(R.id.iddelete)


        DeleteAllButton = view.findViewById(R.id.DeleteAll)
        DeleteAllButton.setOnClickListener {

            ToDoRepository.deleteModernALL()
        }
        DeleteButton = view.findViewById(R.id.delete1)
        DeleteButton.setOnClickListener {
            val title = titleEditText.text.toString()
            if(title.isEmpty()){
                titleEditText.error = "Enter id please";
            }else {
                val id :Long=title.toLong()
                if (ToDoRepository.containsModern(id)){
                    ToDoRepository.deleteModern(id)
                    activity
                }else {
                    titleEditText.error = "No id found";
                }



            }
        }
        return view
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DeleteModeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DeleteModeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
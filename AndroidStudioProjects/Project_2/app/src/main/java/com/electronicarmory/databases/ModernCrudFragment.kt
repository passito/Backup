package com.electronicarmory.databases

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ModernCrudFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ModernCrudFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    lateinit var saveButton: Button
    lateinit var titleEditText: EditText
    lateinit var descriptionEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    private fun isDateValid(date: String?): Boolean {
        val DATE_FORMAT = "MM/dd/yyyy"
        return try {
            val df: DateFormat = SimpleDateFormat(DATE_FORMAT)
            df.isLenient = false
            df.parse(date)
            true
        } catch (e: ParseException) {
            false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_to_do_crud, container, false)
        titleEditText = view.findViewById(R.id.titleEditText)
        descriptionEditText = view.findViewById(R.id.descriptionEditText)

        saveButton = view.findViewById(R.id.button2)
        saveButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()

            if (title.isEmpty()) {
                titleEditText.error = "Enter Name please";
            } else {
                if (description.isEmpty()) {
                    descriptionEditText.error = "Enter a date please";
                } else {
                    if (isDateValid(description)) {
                        ToDoRepository.createModern(title, description, false)
                        activity
                    } else {
                        descriptionEditText.error = "Enter a valid date";
                    }
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
         * @return A new instance of fragment ToDoCrudFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ModernCrudFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
package pjatk.prm.s17918.managerfinansowykotlin.fragments

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation

import pjatk.prm.s17918.managerfinansowykotlin.R
import pjatk.prm.s17918.managerfinansowykotlin.databases.DatabaseHelper
import pjatk.prm.s17918.managerfinansowykotlin.model.Event

class AddFragment : Fragment() {

    lateinit var addName: EditText
    lateinit var addPrice: EditText
    lateinit var addDate: EditText
    lateinit var submitData: Button
    lateinit var spinner: Spinner
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        clearSubtitle()
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        findViews(view)
        setInputTypes()

        addDate.setOnClickListener{

        }

        submitData.setOnClickListener {
            val event = Event(1, addPrice.text.toString(), addName.text.toString(), addDate.text.toString(), spinner.selectedItem.toString())
            navController = Navigation.findNavController(view)
            navController.popBackStack(R.id.events_fragment, false)

            val database = DatabaseHelper(context)
            database.addOneEvent(event)
        }
    }

    private fun clearSubtitle(){
        val subtitle: String = resources.getString(R.string.null_string)
        (activity as AppCompatActivity).supportActionBar!!.subtitle = subtitle
    }

    private fun findViews(view: View){
        addName = requireView().findViewById(R.id.add_name)
        addPrice = requireView().findViewById(R.id.add_price)
        addDate = requireView().findViewById(R.id.add_date)
        submitData = requireView().findViewById(R.id.add_submit_button)
        spinner = requireView().findViewById(R.id.add_category_spinner)
        val arrayAdapter =
            context?.let { ArrayAdapter.createFromResource(it, R.array.add_category_spinner, android.R.layout.simple_spinner_item) }

        arrayAdapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter
    }

    private fun setInputTypes(){
        addDate.inputType = InputType.TYPE_NULL
        addPrice.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL or InputType.TYPE_NUMBER_FLAG_SIGNED
        addName.inputType = InputType.TYPE_CLASS_TEXT
    }
}

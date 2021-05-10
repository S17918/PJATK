package pjatk.prm.s17918.managerfinansowykotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

import pjatk.prm.s17918.managerfinansowykotlin.R

/**
 * A simple [Fragment] subclass.
 */
class SearchByName : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        clearSubtitle()
        return inflater.inflate(R.layout.fragment_search_by_name, container, false)
    }

    private fun clearSubtitle(){
        val subtitle: String = resources.getString(R.string.null_string)
        (activity as AppCompatActivity).supportActionBar!!.subtitle = subtitle
    }

}

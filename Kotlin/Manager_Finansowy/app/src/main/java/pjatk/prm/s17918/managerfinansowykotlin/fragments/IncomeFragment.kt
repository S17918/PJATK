package pjatk.prm.s17918.managerfinansowykotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

import pjatk.prm.s17918.managerfinansowykotlin.R
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class IncomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setSubtitle()
        return inflater.inflate(R.layout.fragment_income, container, false)
    }

    private fun setSubtitle(){
        (activity as AppCompatActivity).supportActionBar!!.subtitle = getDate()
    }

    private fun getDate(): String{
        val cal = Calendar.getInstance()
        val date = SimpleDateFormat("LLLL", Locale.forLanguageTag("PL"))
        val month = date.format(cal.time)
        return month.substring(0, 1).toUpperCase() + month.substring(1)
    }

}

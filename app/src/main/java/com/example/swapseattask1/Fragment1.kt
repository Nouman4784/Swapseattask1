package com.example.swapseattask1

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.swapseattask1.databinding.Fragment1Binding

class Fragment1 : Fragment() {


    var binding: Fragment1Binding? = null
    private var arrayList: ArrayList<TeamItem>? = null
    private var teamAdapter: TeamAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(layoutInflater)


        arrayList = ArrayList()
        arrayList = setData()
        teamAdapter = TeamAdapter(requireContext(), arrayList!!)
        binding!!.gridView.adapter = teamAdapter


        // Spinner 1 SPORT


        val items = resources.getStringArray(R.array.sport_string_array)
        val spinnerAdapter = object :
            ArrayAdapter<String>(requireContext(), R.layout.custom_spinner, items) {

            override fun isEnabled(position: Int): Boolean {
                return position != 0
            }

            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView =
                    super.getDropDownView(position, convertView, parent) as TextView
                if (position == 0) {
                    view.setTextColor(Color.GRAY)
                }
                return view
            }
        }
        spinnerAdapter.setDropDownViewResource(R.layout.custom_spinner)
        binding!!.spinner.adapter = spinnerAdapter
        binding!!.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if (value == items[0]) {
                    (view as? TextView)?.setTextColor(Color.GRAY)
                }
            }
        }


        // Spinner 2 COUNTRY


        val items2 = resources.getStringArray(R.array.country_string_array)
        val spinnerAdapter2 = object :
            ArrayAdapter<String>(requireContext(), R.layout.custom_spinner, items2) {

            override fun isEnabled(position: Int): Boolean {
                return position != 0
            }

            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView =
                    super.getDropDownView(position, convertView, parent) as TextView
                if (position == 0) {
                    view.setTextColor(Color.GRAY)
                }
                return view
            }
        }
        spinnerAdapter2.setDropDownViewResource(R.layout.custom_spinner)
        binding!!.spinner2.adapter = spinnerAdapter2
        binding!!.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if (value == items2[0]) {
                    (view as? TextView)?.setTextColor(Color.GRAY)
                }
            }
        }


        // Spinner 3 LEAGUE


        val items3 = resources.getStringArray(R.array.league_string_array)
        val spinnerAdapter3 = object :
            ArrayAdapter<String>(requireContext(), R.layout.custom_spinner, items3) {

            override fun isEnabled(position: Int): Boolean {
                return position != 0
            }

            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView =
                    super.getDropDownView(position, convertView, parent) as TextView
                if (position == 0) {
                    view.setTextColor(Color.GRAY)
                }
                return view
            }
        }
        spinnerAdapter3.setDropDownViewResource(R.layout.custom_spinner)
        binding!!.spinner3.adapter = spinnerAdapter3
        binding!!.spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if (value == items3[0]) {
                    (view as? TextView)?.setTextColor(Color.GRAY)
                }
            }
        }
        return binding?.root
    }

    private fun setData(): ArrayList<TeamItem> {
        val arrayList: ArrayList<TeamItem> = ArrayList()

        arrayList.add(TeamItem(R.drawable.arsenal, "Arsenal"))
        arrayList.add(TeamItem(R.drawable.manchester, "Manchester"))
        arrayList.add(TeamItem(R.drawable.chalsea, "Chalsea"))
        arrayList.add(TeamItem(R.drawable.manchester, "Manchester"))
        arrayList.add(TeamItem(R.drawable.chalsea, "Chalsea"))
        arrayList.add(TeamItem(R.drawable.arsenal, "Arsenal"))
        arrayList.add(TeamItem(R.drawable.arsenal, "Arsenal"))
        arrayList.add(TeamItem(R.drawable.manchester, "Manchester"))
        arrayList.add(TeamItem(R.drawable.chalsea, "Chalsea"))
        arrayList.add(TeamItem(R.drawable.manchester, "Manchester"))
        arrayList.add(TeamItem(R.drawable.chalsea, "Chalsea"))
        arrayList.add(TeamItem(R.drawable.arsenal, "Arsenal"))
        arrayList.add(TeamItem(R.drawable.arsenal, "Arsenal"))
        arrayList.add(TeamItem(R.drawable.manchester, "Manchester"))
        arrayList.add(TeamItem(R.drawable.chalsea, "Chalsea"))

        return arrayList
    }
}
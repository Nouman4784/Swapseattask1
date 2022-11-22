package com.example.swapseattask1

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class TeamAdapter(var context: Context, var arrayList: ArrayList<TeamItem>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.cardview_item_grid, null)
        val icon: ImageView = view.findViewById(R.id.image)
        val name: TextView = view.findViewById(R.id.text_view)

        val listTeamItem: TeamItem = arrayList[position]

        icon.setImageResource(listTeamItem.icon!!)
        name.text = listTeamItem.name

        return view
    }
}
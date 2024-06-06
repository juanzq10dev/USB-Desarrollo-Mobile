package com.example.solarsystem

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MyListViewAdapter(val context: Context, val items: List<Planet>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_view_layout, parent, false)

        } else {
            view = convertView
        }

        val textView = view.findViewById<TextView>(R.id.planet_name)
        val imageView = view.findViewById<ImageView>(R.id.planet_image)
        val planetMoonsView = view.findViewById<TextView>(R.id.planet_moons)

        val planet = getItem(position) as Planet
        textView.text = planet.name
        "Moons: ${planet.moons}".also { planetMoonsView.text = it }
        imageView.setImageResource(planet.image)

        view.setOnClickListener {
            Toast.makeText(context, planet.name, Toast.LENGTH_SHORT).show()
        }


        return view
    }

}
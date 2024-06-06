package com.example.solarsystem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(val planets: List<Planet>): RecyclerView.Adapter<RVAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView = itemView.findViewById<TextView>(R.id.planet_name)
        var moonsTextView: TextView = itemView.findViewById<TextView>(R.id.planet_moons)
        var imageView: ImageView = itemView.findViewById<ImageView>(R.id.planet_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_view_layout, parent, false)
        val viewHolder = MyViewHolder(view)
        return  viewHolder
    }

    override fun getItemCount(): Int {
        return planets.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val planet = planets[position]
        holder.nameTextView.text = planet.name
        "Moons: ${planet.moons}".also { holder.moonsTextView.text = it }
        holder.imageView.setImageResource(planet.image)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, planet.name, Toast.LENGTH_SHORT).show()
        }
    }


}
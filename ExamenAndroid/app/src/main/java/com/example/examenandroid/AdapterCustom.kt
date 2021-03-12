package com.example.examenandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterCustom(var contexto:Context,items: ArrayList<Movie>): RecyclerView.Adapter<AdapterCustom.ViewHolder>() {
    var items: ArrayList<Movie>? = null
    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCustom.ViewHolder {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.templeate_movie,parent,false)
        val viewHolder = ViewHolder(vista)

        return viewHolder
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.title?.text = item?.title
        holder.tagline?.text = item?.tagline
        holder.status?.text = item?.status
    }

    class ViewHolder(vista:View): RecyclerView.ViewHolder(vista)
    {
        var vista = vista
        var title:TextView? = null
        var tagline:TextView? = null
        var status:TextView? = null

        init {
            title = vista.findViewById(R.id.tvTitle)
            tagline = vista.findViewById(R.id.tvTagline)
            status = vista.findViewById(R.id.tvStatus)
        }

    }
}
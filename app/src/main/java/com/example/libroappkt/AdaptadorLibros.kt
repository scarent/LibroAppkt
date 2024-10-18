package com.example.libroappkt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdaptadorLibros(
    private var listaLibros: List<Libro>,
    private val onItemClick: (Libro) -> Unit
) : RecyclerView.Adapter<AdaptadorLibros.LibroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_libro, parent, false)
        return LibroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libro = listaLibros[position]
        holder.bind(libro)


        holder.itemView.setOnClickListener {
            onItemClick(libro) // Llama a la función pasada como parámetro cuando se hace clic
        }
    }

    override fun getItemCount(): Int {
        return listaLibros.size
    }

    fun updateList(newList: List<Libro>) {
        listaLibros = newList
        notifyDataSetChanged()
    }

    class LibroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // enlace
        fun bind(libro: Libro) {
            // Config datos
        }
    }
}





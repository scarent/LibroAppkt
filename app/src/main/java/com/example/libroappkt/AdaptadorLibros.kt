package com.example.libroappkt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorLibros(private val libros: List<Libro>, private val onClick: (Libro) -> Unit) :
    RecyclerView.Adapter<AdaptadorLibros.LibroViewHolder>() {

    inner class LibroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titulo: TextView = itemView.findViewById(R.id.textoTitulo)
        private val autor: TextView = itemView.findViewById(R.id.textoAutor)
        private val precio: TextView = itemView.findViewById(R.id.textoPrecio)
        private val imagen: ImageView = itemView.findViewById(R.id.imagenLibro)

        fun bind(libro: Libro) {
            titulo.text = libro.titulo
            autor.text = libro.autor
            precio.text = libro.precio
            imagen.setImageResource(libro.imagenResId)  // Cargar la imagen del libro
            itemView.setOnClickListener {
                onClick(libro)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_libro, parent, false)
        return LibroViewHolder(vista)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        holder.bind(libros[position])
    }

    override fun getItemCount(): Int = libros.size
}



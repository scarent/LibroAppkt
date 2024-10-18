package com.example.libroappkt // <-- Asegúrate de incluir esto al principio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libroappkt.AdaptadorLibros
import com.example.libroappkt.Libro
import com.example.libroappkt.R

class BuscarFragment : Fragment() {

    private lateinit var editTextBuscar: EditText
    private lateinit var buttonBuscar: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adaptadorLibros: AdaptadorLibros
    private var listaLibros = listOf<Libro>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_buscar, container, false)

        editTextBuscar = view.findViewById(R.id.editTextBuscar)
        buttonBuscar = view.findViewById(R.id.buttonBuscar)
        recyclerView = view.findViewById(R.id.recyclerViewResultados)

        // Configuración del RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // Pasamos una función vacía para el clic en el libro
        adaptadorLibros = AdaptadorLibros(listaLibros) { /* función vacía */ }
        recyclerView.adapter = adaptadorLibros

        buttonBuscar.setOnClickListener {
            val query = editTextBuscar.text.toString()
            buscarLibros(query)
        }

        return view
    }

    private fun buscarLibros(query: String) {
        // Aquí filtras los libros por el criterio de búsqueda
        val librosFiltrados = listaLibros.filter { libro ->
            libro.titulo.contains(query, ignoreCase = true)
        }

        adaptadorLibros.updateList(librosFiltrados)
    }
}


package com.example.libroappkt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.libroappkt.BuscarActivity

class CatalogoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        //  RecyclerView
        val libros = listOf(
            Libro("Cien años de soledad", "Gabriel Garcia Marquez", "$10.000"),
            Libro("La naranja mecanica", "Anthony Burgess", "$11.990"),
            Libro("1984", "George Orwell", "$15.000")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerLibros)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdaptadorLibros(libros) { libro ->
            val intent = Intent(this, ReservarLibroActivity::class.java)
            intent.putExtra("libro", libro)
            startActivity(intent)
        }

        // Configuración de la Bottom Bar
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_mis_libros -> {
                    startActivity(Intent(this, MisLibrosActivity::class.java))
                    true
                }
                R.id.nav_buscar -> {
                    //
                    startActivity(Intent(this, BuscarActivity::class.java))
                    true
                }
                R.id.nav_wishlist -> {
                    startActivity(Intent(this, WishlistActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}








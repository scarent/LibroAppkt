package com.example.libroappkt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MisLibrosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_libros)

        findViewById<TextView>(R.id.textoCatalogo).setOnClickListener {
            startActivity(Intent(this, CatalogoActivity::class.java))
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_mis_libros -> {
                    startActivity(Intent(this, MisLibrosActivity::class.java))
                    true
                }
                R.id.nav_buscar -> {
                    // Código para abrir barra de búsqueda
                    true
                }
                R.id.nav_catalogo -> {
                    startActivity(Intent(this, CatalogoActivity::class.java))
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



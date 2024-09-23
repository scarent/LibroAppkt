package com.example.libroappkt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class WishlistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wishlist)

        // Configuración de la Bottom Bar
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_mis_libros -> {
                    startActivity(Intent(this, MisLibrosActivity::class.java))
                    true
                }
                R.id.nav_buscar -> {
                    // siguiente barra de busqueda
                    true
                }
                R.id.nav_catalogo -> {
                    startActivity(Intent(this, CatalogoActivity::class.java))
                    true
                }
                R.id.nav_wishlist -> {
                    // No es necesario reiniciar la misma actividad en esta parte
                    true
                }
                else -> false
            }
        }
    }
}


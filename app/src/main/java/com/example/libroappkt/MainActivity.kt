package com.example.libroappkt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        loadFragment(CatalogoFragment()) // Cargar fragmento por defecto

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.itemCatalogo -> selectedFragment = CatalogoFragment()
                R.id.itemBuscar -> selectedFragment = BuscarFragment()
                R.id.itemMisLibros -> selectedFragment = MisLibrosFragment()
                R.id.itemWishlist -> selectedFragment = WishlistFragment()
            }
            if (selectedFragment != null) {
                loadFragment(selectedFragment) // Cargar el fragmento seleccionado
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}


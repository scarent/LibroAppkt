package com.example.libroappkt

import java.io.Serializable

data class Libro(val titulo: String,
                 val autor: String,
                 val precio: String,
                 val imagenResId: Int) : Serializable   // id para las imagenes




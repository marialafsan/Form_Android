package com.example.form_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondaryActivity : AppCompatActivity() {

    private lateinit var txtResumen: TextView
    private lateinit var btnVolver: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recuperarDatos()
    }

    private fun recuperarDatos() {

        txtResumen = findViewById(R.id.txtResumen)
        btnVolver = findViewById(R.id.btnVolver)

        val nombre = intent.getStringExtra("nombre")
        val edad = intent.getIntExtra("edad", 0)
        val tecnologias = intent.getStringExtra("tecnologias")
        val turno = intent.getIntExtra("turno", 0)

        val resumen = """
            
            Datos del alumno:
            
            Nombre: $nombre
            Edad: $edad
            Tecnologías: $tecnologias
            Turno preferido: $turno
            
        """.trimIndent()

        txtResumen.text = resumen

        btnVolver.setOnClickListener {
            finish()
        }

    }
}
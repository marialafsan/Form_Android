package com.example.form_android


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondaryActivity : AppCompatActivity() {

    private lateinit var txtResumen: TextView
    private lateinit var btnVolver: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_secondary)

        recuperarDatos()
    }

    private fun recuperarDatos() {

        txtResumen = findViewById(R.id.txtResumen)
        btnVolver = findViewById(R.id.btnVolver)

        val nombre = intent.getStringExtra("nombre")
        val edad = intent.getIntExtra("edad", 0)
        val tecnologias = intent.getStringExtra("tecnologias")
        val turno = intent.getStringExtra("turno")

        val resumen = """
            
            Datos del alumno
            
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
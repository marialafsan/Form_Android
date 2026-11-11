package com.example.form_android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var cbJava: CheckBox
    private lateinit var cbKotlin: CheckBox
    private lateinit var rgHora: RadioGroup

    private lateinit var btnEnviar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        inicializarComponentes()
        configurarEnvio()

    }

    private fun inicializarComponentes() {

        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        cbJava = findViewById(R.id.cbJava)
        cbKotlin = findViewById(R.id.cbKotlin)
        rgHora = findViewById(R.id.rgHora)
        btnEnviar = findViewById(R.id.btnEnviar)

    }

    private fun configurarEnvio(){


        btnEnviar.setOnClickListener {


            /* VALIDACIONES */

            /* Validación Nombre */

            val nombre = etNombre.text.toString().trim()
            if (nombre.isEmpty()) {
                etNombre.error = "Introduce tu nombre"
                etNombre.requestFocus()
                return@setOnClickListener
            }

            /* Validación Edad */

            val edadString = etEdad.text.toString().trim()
            var edad: Int? = 0

            if (edadString.isEmpty() || edadString.toIntOrNull() == null) {
                etEdad.error = "Introduce una edad válida"
                etEdad.requestFocus()
                return@setOnClickListener
            } else {
                edad = edadString.toIntOrNull()
            }

            /* Validación Tecnologías */

            var tecnologias = ""
            if (cbJava.isChecked) {
                tecnologias += cbJava.text.toString() + "\n"
            }
            if (cbKotlin.isChecked) {
                tecnologias += cbKotlin.text.toString() + "\n"
            }
            if (tecnologias.isEmpty()) {
                Toast.makeText(this, "Selecciona al menos una tecnología", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            /* Validación Turno */

            val turno = rgHora.checkedRadioButtonId
            if (turno == -1) {
                Toast.makeText(this, "Selecciona un turno", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // INTENT

            val intent = Intent(this, SecondaryActivity::class.java)

            intent.putExtra("nombre", nombre)
            intent.putExtra("edad", edad)
            intent.putExtra("tecnologias", tecnologias)
            intent.putExtra("turno", turno)

            startActivity(intent)

            finish()

        }

    }








}
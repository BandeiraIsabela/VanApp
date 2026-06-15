package com.example.vanapp

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.vanapp.viewmodel.VanViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: VanViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nomeUsuario = intent.getStringExtra("usuario")
        val txtUsuario = findViewById<TextView>(R.id.txtUsuario)
        val listView = findViewById<ListView>(R.id.listView)
        val fabMap = findViewById<FloatingActionButton>(R.id.fabAdd)

        txtUsuario.text = "Bem-vindo, $nomeUsuario"

        viewModel = ViewModelProvider(this).get(VanViewModel::class.java)

        viewModel.vans.observe(this) { vans ->
            val adapter = VanAdapter(this, vans)
            listView.adapter = adapter

            listView.setOnItemClickListener { _, _, position, _ ->
                val van = vans[position]

                val intent = Intent(this, DetalhesActivity::class.java)
                intent.putExtra("rota", van.rota)
                intent.putExtra("motorista", van.motorista)
                intent.putExtra("horario", van.horario)
                startActivity(intent)
            }
        }

        fabMap.setOnClickListener {
            startActivity(Intent(this, MapActivity::class.java))
        }

        // Adicionando um clique longo no FAB para abrir os Sensores (opcional, para ter 6 telas ou fácil acesso)
        fabMap.setOnLongClickListener {
            startActivity(Intent(this, SensorActivity::class.java))
            true
        }

        viewModel.carregarVans()
    }
}

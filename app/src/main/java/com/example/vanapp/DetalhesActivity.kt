package com.example.vanapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vanapp.databinding.ActivityDetalhesBinding
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class DetalhesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesBinding
    private lateinit var map: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configuração necessária para o osmdroid
        Configuration.getInstance().load(this, getPreferences(MODE_PRIVATE))

        // 🔗 ligação com o layout
        binding = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rota = intent.getStringExtra("rota")
        val motorista = intent.getStringExtra("motorista")
        val horario = intent.getStringExtra("horario")

        // 🔙 botão voltar
        binding.btnVoltar.setOnClickListener {
            finish()
        }

        // 📄 dados
        binding.txtRota.text = rota
        binding.txtMotorista.text = "Motorista: $motorista"
        binding.txtHorario.text = "Horário: $horario"

        // ✅ confirmação
        binding.btnConfirmar.setOnClickListener {
            Toast.makeText(this, "Embarque confirmado!", Toast.LENGTH_SHORT).show()
        }

        // 📍 Configurar o mapa osmdroid
        map = binding.mapDetalhes
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)

        val mapController = map.controller
        mapController.setZoom(15.0)

        // 🏢 Localização da Empresa
        val empresaPoint = GeoPoint(-23.5505, -46.6333)
        mapController.setCenter(empresaPoint)

        val empresaMarker = Marker(map)
        empresaMarker.position = empresaPoint
        empresaMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        empresaMarker.title = "Sede da Empresa"
        map.overlays.add(empresaMarker)

        // 🚐 Localização da Van (simulada próxima à empresa)
        val vanPoint = GeoPoint(-23.5525, -46.6353)
        val vanMarker = Marker(map)
        vanMarker.position = vanPoint
        vanMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        vanMarker.title = "Sua Van"
        // No osmdroid, para mudar a cor do marcador padrão é mais fácil usar um ícone personalizado, 
        // mas por padrão deixaremos assim para simplicidade.
        map.overlays.add(vanMarker)
        
        // Centralizar na Van
        mapController.setCenter(vanPoint)
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }
}

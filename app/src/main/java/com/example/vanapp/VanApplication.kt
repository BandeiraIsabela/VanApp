package com.example.vanapp

import android.app.Application
import org.osmdroid.config.Configuration

class VanApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Inicializa a configuração do osmdroid uma única vez no início do app
        // Isso evita leituras de disco repetitivas em cada Activity de mapa
        Configuration.getInstance().userAgentValue = packageName
    }
}
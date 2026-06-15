# 🚐 VanGo - App de Transporte Corporativo

O **VanGo** é um aplicativo Android desenvolvido em Kotlin que simula um sistema de transporte corporativo, onde funcionários podem visualizar rotas de vans disponibilizadas pela empresa e confirmar seu embarque.

Este projeto foi atualizado para atender a requisitos avançados de arquitetura e funcionalidades nativas.

---

## 📱 Funcionalidades

* 🔐 **Login e Cadastro**: Autenticação com persistência de preferências do usuário.
* 📋 **Listagem de Vans**: Consumo de API REST para obter dados de rotas.
* 💾 **Persistência Local**: Armazenamento em banco de dados Room para suporte offline.
* 📍 **Mapas**: Integração com Google Maps para visualização de localização.
* 📳 **Sensores**: Uso do acelerômetro para detecção de movimento.
* 🧪 **Testes**: Implementação de testes unitários para garantir a qualidade do código.

---

## 🧠 Tecnologias e Arquitetura

* **Arquitetura MVVM**: Separação clara de responsabilidades (View, ViewModel, Repository, Model).
* **Retrofit**: Consumo de API RESTful.
* **Room Database**: Persistência de dados local com SQLite.
* **Coroutines & Flow**: Processamento assíncrono em threads secundárias.
* **SharedPreferences**: Armazenamento de preferências simples (Login).
* **Google Maps SDK**: Visualização de mapas.
* **Sensor Manager**: Acesso ao acelerômetro do dispositivo.
* **JUnit & Mockito**: Testes unitários.

---

## 🛠️ Modificações Realizadas

1.  **Arquitetura**: Refatoração do `VanRepository` e `VanViewModel` para seguir o padrão MVVM rigorosamente com Coroutines.
2.  **Persistência**: Implementação do Room (`AppDatabase`, `VanDao`, `VanEntity`) para salvar as rotas localmente.
3.  **Novas Telas**: Adição da `MapActivity` (Google Maps) e `SensorActivity` (Acelerômetro), totalizando 6 telas.
4.  **API REST**: Atualização do fluxo de dados para sincronizar a API com o banco de dados local.
5.  **Testes**: Criação da classe `VanViewModelTest` com JUnit e Mockito.
6.  **Dependências**: Atualização do `build.gradle.kts` e `libs.versions.toml` para incluir Room, Maps e ferramentas de teste.

---

## 🚀 Como Executar o Projeto

1. Clone o repositório.
2. No `AndroidManifest.xml`, adicione sua chave do Google Maps em `YOUR_API_KEY_HERE`.
3. Abra no Android Studio e sincronize o Gradle.
4. Execute em um emulador ou dispositivo físico.

---

## 🎯 Objetivo Acadêmico

Demonstrar o domínio de conceitos fundamentais e avançados do ecossistema Android, desde o consumo de serviços externos até a interação com hardware e persistência robusta.

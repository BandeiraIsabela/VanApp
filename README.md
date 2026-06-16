# 🚐 VanGo - App de Transporte Corporativo

O **VanGo** é um aplicativo Android desenvolvido em Kotlin que simula um sistema de transporte corporativo, onde funcionários podem visualizar rotas de vans disponibilizadas pela empresa e confirmar seu embarque.

Este projeto foi atualizado para atender a requisitos avançados de arquitetura, performance e funcionalidades nativas.

---

## 📱 Funcionalidades

* 🔐 **Login e Cadastro**: Autenticação com persistência de preferências do usuário.
* 📋 **Listagem de Vans**: Consumo de API REST (JSONPlaceholder) para obter dados de rotas.
* 💾 **Persistência Local**: Armazenamento em banco de dados Room para suporte offline.
* 📍 **Mapas (OpenStreetMap)**: Integração com **osmdroid** para visualização de localização sem necessidade de API Key.
* 📳 **Sensores**: Uso do acelerômetro para monitoramento de movimento em tempo real.
* 🧪 **Testes Unitários**: Garantia de qualidade na lógica de negócios com JUnit e Mockito.
* 🚀 **Alta Performance**: Otimização contra travamentos (ANR) usando Coroutines em todas as camadas de I/O.

---

## 🧠 Tecnologias e Arquitetura

* **Arquitetura MVVM**: Separação clara de responsabilidades (View, ViewModel, Repository, Model).
* **Retrofit (Suspend Functions)**: Consumo de API RESTful de forma assíncrona e eficiente.
* **Room Database (Suspend DAO)**: Persistência de dados local com SQLite usando Coroutines.
* **Coroutines (Main/IO Dispatchers)**: Processamento assíncrono para garantir uma UI fluida.
* **osmdroid**: Renderização de mapas baseados em OpenStreetMap (100% gratuito e open-source).
* **Sensor Manager**: Acesso nativo ao acelerômetro do dispositivo.
* **JUnit & Mockito**: Testes de unidade para ViewModels.
* **View Binding**: Acesso seguro e tipado aos componentes de layout.

---

## 🛠️ Modificações e Evoluções Realizadas

1.  **Arquitetura & Performance**: Refatoração completa para o padrão MVVM. Implementação de `suspend functions` no Room e Retrofit para evitar o erro "Application Not Responding" (ANR).
2.  **Migração de Mapas**: Substituição do Google Maps pelo **osmdroid (OpenStreetMap)**. Isso permite que o mapa funcione instantaneamente sem a burocracia de chaves de API.
3.  **UI/UX Avançada**:
    *   `DetalhesActivity`: Implementação de mapa em tela cheia com elementos flutuantes (`Extended FAB` e `MaterialCard`) usando `CoordinatorLayout`.
    *   Botão Flutuante na Main: Acesso rápido ao mapa (clique) e sensores (clique longo).
4.  **Persistência Robusta**: Sincronização automática entre a API REST e o Banco de Dados local.
5.  **Inicialização Global**: Uso de `VanApplication` para configuração otimizada de bibliotecas de terceiros.
6.  **Testes**: Implementação da classe `VanViewModelTest` validando a integração com o repositório.

---

## 🚀 Como Executar o Projeto

1. Clone o repositório.
2. Abra o projeto no Android Studio (versão Ladybug ou superior recomendada).
3. Sincronize o Gradle.
4. Execute em um emulador ou dispositivo físico (necessário internet para o primeiro carregamento do mapa).
5. **Dica**: O mapa agora é *plug-and-play*, não requer configuração de chaves externas!

---

## 🎯 Objetivo Acadêmico

Demonstrar o domínio de conceitos avançados do ecossistema Android moderno: persistência reativa, consumo assíncrono de serviços, interação com hardware (sensores), arquitetura desacoplada e testes automatizados.

package com.example.supervisordeobra.data

data class ArquivoModel(
    val nomeArquivo: String = "",
    val dadosArquivo: String = "",
    var kmStaca: String = "",
    var coordNorte: Double = 0.0,
    var coordEste: Double = 0.0
)
package com.example.supervisordeobra.telas.Ensaio

import kotlin.math.round

sealed class Selada(val route: String) {
    object telaIncial :  Selada(route = "TelaInicial")
    object arquivo :  Selada(route = "telaincerirArquivo")
    object supervisor :  Selada(route = "supervisao")
    object balanco :  Selada(route = "balacoDeMassa")
    object compactacao :  Selada(route = "grauDeCompactacao")
    object ensaio :  Selada(route = "dadosEnsaio")
    object laboratorio :  Selada(route = "laboratorio")
    object campo :  Selada(route = "dadosCampos")
    object telaOpcaoInicial : Selada(route = "opcaoInicial")
    object telaOpcaoEnsaio : Selada(route = "opcaoEnsaio")

}
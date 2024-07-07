package com.example.supervisordeobra

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.supervisordeobra.TelasIniciais.grauDeCompactacao
import com.example.supervisordeobra.telas.Ensaio.Selada
import com.example.supervisordeobra.telas.Ensaio.dadosCampos
import com.example.supervisordeobra.telas.Ensaio.dadosEnsaio
import com.example.supervisordeobra.telas.Ensaio.laboratorio

fun NavGraphBuilder.navegacaoEnsaio(navController: NavController){
    navigation(startDestination = Selada.compactacao.route, route = Selada.telaOpcaoEnsaio.route) {

        composable(route = Selada.compactacao.route) {
            grauDeCompactacao(navController = navController)
        }
        composable(route = Selada.ensaio.route) {
            dadosEnsaio(navController = navController)
        }
        composable(route = Selada.laboratorio.route) {
            laboratorio(navController = navController)
        }
        composable(route = Selada.campo.route) {
            dadosCampos(navController = navController)
        }
    }
}
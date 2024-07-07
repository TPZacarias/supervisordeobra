package com.example.supervisordeobra

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.supervisordeobra.TelasIniciais.TelaInicial
import com.example.supervisordeobra.TelasIniciais.balacoDeMassa
import com.example.supervisordeobra.TelasIniciais.grauDeCompactacao
import com.example.supervisordeobra.TelasIniciais.supervisao
import com.example.supervisordeobra.TelasIniciais.telaincerirArquivo
import com.example.supervisordeobra.telas.Ensaio.Selada

fun NavGraphBuilder.navegacaoInicial(navController: NavController){
    navigation(startDestination = Selada.telaIncial.route, route = Selada.telaOpcaoInicial.route){

        composable(route = Selada.telaIncial.route) {
            TelaInicial(navController)
        }
        composable(route = Selada.arquivo.route) {
            telaincerirArquivo(navController = navController )
        }
        composable(route = Selada.supervisor.route) {
            supervisao(navController = navController)
        }
        composable(route = Selada.balanco.route) {
            balacoDeMassa(navController = navController)
        }
        composable(route = Selada.compactacao.route) {
            grauDeCompactacao(navController = navController)
        }
    }
}
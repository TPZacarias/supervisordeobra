package com.example.supervisordeobra

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.supervisordeobra.ui.BalancoDeMassa
import com.example.supervisordeobra.ui.GrauDeCompactacao
import com.example.supervisordeobra.ui.InsereArquivo
import com.example.supervisordeobra.ui.Supervisao
import com.example.supervisordeobra.ui.TelaInicial
import com.example.supervisordeobra.ui.campo.DadosCampos
import com.example.supervisordeobra.ui.ensaio.DadosEnsaio
import com.example.supervisordeobra.ui.laboratorio.Laboratorio

@Composable
fun Navegar() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "opcaoInicial") {
        navigation(startDestination = "TelaInicial", route = "opcaoInicial") {
            composable(route = "TelaInicial") {
                TelaInicial(navController = navController)
            }
            composable(route = "telaincerirArquivo") {
                InsereArquivo(navController = navController)
            }
            composable(route = "supervisao") {
                Supervisao(navController = navController)
            }
            composable(route = "balacoDeMassa") {
                BalancoDeMassa(navController = navController)
            }
            composable(route = "grauDeCompactacao") {
                GrauDeCompactacao(navController = navController)
            }
        }

        navigation(startDestination = "grauDeCompactacao", route = "opcaoEnsaio") {
            composable(route = "grauDeCompactacao") {
                GrauDeCompactacao(navController = navController)
            }
            composable(route = "dadosEnsaio") {
                DadosEnsaio(navController = navController)
            }
            composable(route = "laboratorio") {
                Laboratorio(navController = navController)
            }
            composable(route = "dadosCampos") {
                DadosCampos(navController = navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavegar() {
    Navegar()
}

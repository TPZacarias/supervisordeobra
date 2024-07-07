package com.example.supervisordeobra

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.supervisordeobra.telas.Ensaio.Selada
import com.example.supervisordeobra.telas.Ensaio.dadosCampos
import com.example.supervisordeobra.telas.Ensaio.dadosEnsaio
import com.example.supervisordeobra.telas.Ensaio.laboratorio
import com.example.supervisordeobra.TelasIniciais.balacoDeMassa
import com.example.supervisordeobra.TelasIniciais.grauDeCompactacao
import com.example.supervisordeobra.TelasIniciais.supervisao
import com.example.supervisordeobra.TelasIniciais.TelaInicial
import com.example.supervisordeobra.TelasIniciais.telaincerirArquivo

@Composable
// Aval navController = rememberNavController() CABINE DO PILOTO QUE CONTROLA A NAVEGAÇÃO
fun navegar(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Selada.telaOpcaoInicial.route ) {

        navegacaoInicial(navController)
        navegacaoEnsaio(navController)

    }
    }
package com.example.supervisordeobra.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.supervisordeobra.R

@Composable
fun telaInicial(navController:NavController) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Column(modifier = Modifier.background(color = Color.White)) {
        Image(painter = painterResource(id = R.drawable.inserir_arquivo ) , contentDescription = "", modifier = Modifier
            .clickable { navController.navigate("telaincerirArquivo") }
            .width(350.dp)
            .height(150.dp)
            .padding(10.dp))

        }
        Spacer(modifier = Modifier.size(6.dp))
        Column (modifier = Modifier.background(color = Color.White))
        {
            Image(painter = painterResource(id = R.drawable.supervisor_de_obra ) , contentDescription = "", modifier = Modifier
                    .clickable { navController.navigate("supervisor") }
                .width(350.dp)
                .height(150.dp)
                .padding(10.dp))
        }
        Spacer(modifier = Modifier.size(6.dp))
        Column(modifier = Modifier.background(color = Color.White))
        {
            Image(painter = painterResource(id = R.drawable.escavadeira ) , contentDescription = "", modifier = Modifier
                    .clickable {navController.navigate("balacoDeMassa")}
                .width(350.dp)
                .height(150.dp)
                .padding(10.dp))
        }
        Spacer(modifier = Modifier.size(6.dp))
        Column (modifier = Modifier.background(color = Color.White))
        {
            Image(painter = painterResource(id = R.drawable.grau_de_compacta__o ) , contentDescription = "", modifier = Modifier
                    .clickable { navController.navigate("grauDeCompactacao") }
                .width(350.dp)
                .height(150.dp)
                .padding(10.dp))
        }
    }
}
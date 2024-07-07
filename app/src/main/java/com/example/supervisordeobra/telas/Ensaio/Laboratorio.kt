package com.example.supervisordeobra.telas.Ensaio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun laboratorio(navController: NavController){
    val densidadeAeia = remember { mutableStateOf("") }
    val pesoFunil = remember { mutableStateOf("") }
    var umidadeOtima = remember { mutableStateOf("") }
    val densidade = remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(text = "DATA E HORA:")
            Spacer(modifier = Modifier.size(5.dp))
            OutlinedTextField(
                value = densidadeAeia.value,
                onValueChange = {
                    densidadeAeia.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.size(5.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(text = "LOTE:")
            Spacer(modifier = Modifier.size(5.dp))
            OutlinedTextField(
                value = pesoFunil.value,
                onValueChange = {
                    pesoFunil.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.size(5.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(text = "KM/ESTACA:")
            Spacer(modifier = Modifier.size(5.dp))
            OutlinedTextField(
                value = umidadeOtima.value,
                onValueChange = {
                    umidadeOtima.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.size(5.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Spacer(modifier = Modifier.size(15.dp))

            Text(text = "ESTRUTURA:")
            Spacer(modifier = Modifier.size(5.dp))
            OutlinedTextField(
                value = densidade.value,
                onValueChange = {
                    densidade.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        }
    }

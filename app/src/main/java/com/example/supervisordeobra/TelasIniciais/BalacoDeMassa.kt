package com.example.supervisordeobra.TelasIniciais

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun balacoDeMassa(navController: NavController) {
    val dataHoraVisita = remember { mutableStateOf("") }
    val lote = remember { mutableStateOf("") }
    var kmEstaca = remember { mutableStateOf("") }
    val estrutura = remember { mutableStateOf("") }
    val origem_destino = remember { mutableStateOf("") }

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
                value = dataHoraVisita.value,
                onValueChange = {
                    dataHoraVisita.value = it
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
                value = lote.value,
                onValueChange = {
                    lote.value = it
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
                value = kmEstaca.value,
                onValueChange = {
                    kmEstaca.value = it
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
                value = estrutura.value,
                onValueChange = {
                    estrutura.value = it
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
            Text(text = "ORIGEM OU DESTINO")
        }

        Spacer(modifier = Modifier.size(5.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            OutlinedTextField(
                value = origem_destino.value,
                onValueChange = {

                    origem_destino.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                maxLines = 4,
                label = {
                    Text(text = "ORIGEM OU DESTINO/CORTE OU ATERRO ", color = Color.Red)
                })

        }

    }
}
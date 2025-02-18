package com.example.supervisordeobra.ui.ensaio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileOpen
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.supervisordeobra.ui.BackButton

@Composable
fun DadosEnsaio(navController: NavController = rememberNavController()) {

    val dataHoraEnsaio = remember { mutableStateOf("") }
    val lote = remember { mutableStateOf("") }
    var kmEstaca = remember { mutableStateOf("") }
    val numeroCamada = remember { mutableStateOf("") }
    val ladoFuro = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                BackButton(navController)
            }
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(40.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Text(text = "DATA E HORA:")
                Spacer(modifier = Modifier.size(5.dp))
                OutlinedTextField(
                    value = dataHoraEnsaio.value,
                    onValueChange = {
                        dataHoraEnsaio.value = it
                    },
                    modifier = Modifier.fillMaxWidth()
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
                    modifier = Modifier.fillMaxWidth()
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
                    modifier = Modifier.fillMaxWidth()
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
                    value = numeroCamada.value,
                    onValueChange = {
                        numeroCamada.value = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.size(5.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                OutlinedTextField(
                    value = ladoFuro.value,
                    onValueChange = {
                        ladoFuro.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    maxLines = 4,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.FileOpen,
                            tint = Color.Red,
                            contentDescription = "abrirArquivo"
                        )
                    },
                    placeholder = {
                        Text("DESCREVA O SERVIÇO", color = Color.Red)
                    },
                    label = {
                        Text(text = "DESCREVA O SERVIÇO SUPERVISIONADO ", color = Color.Red)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDadosEnsaio() {
    DadosEnsaio()
}
package com.example.supervisordeobra.ui.campo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.supervisordeobra.ui.BackButton

@Composable
fun DadosCampos(navController: NavController = rememberNavController()) {

    val pesoInicialFrasco = remember { mutableStateOf("") }
    val pesoFunil = remember { mutableStateOf("") }
    var pesoSoloUmido = remember { mutableStateOf("") }
    val teorUmidade = remember { mutableStateOf("") }

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
                    value = pesoInicialFrasco.value,
                    onValueChange = {
                        pesoInicialFrasco.value = it
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
                    value = pesoFunil.value,
                    onValueChange = {
                        pesoFunil.value = it
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
                    value = pesoSoloUmido.value,
                    onValueChange = {
                        pesoSoloUmido.value = it
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
                    value = teorUmidade.value,
                    onValueChange = {
                        teorUmidade.value = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDadosCampos() {
    DadosCampos()
}
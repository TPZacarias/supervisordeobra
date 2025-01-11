package com.example.supervisordeobra.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileOpen
import androidx.compose.material3.Button
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
import com.example.supervisordeobra.data.Arquivo

@Composable
fun InsereArquivo(navController: NavController = rememberNavController()) {

    val nomeDoArquivo = remember { mutableStateOf("") }
    val insiraArquivo = remember { mutableStateOf("") }

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
                .fillMaxWidth()
                .padding(contentPadding)
                .padding(15.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(40.dp))

            OutlinedTextField(
                value = insiraArquivo.value,
                onValueChange = {
                    insiraArquivo.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("DIGITE O NOME DO ARQUIVO", color = Color.Red)
                },
                label = {
                    Text(text = "NOME DA OBRA", color = Color.Red)
                },
            )
            Spacer(modifier = Modifier.size(15.dp))

            OutlinedTextField(
                value = nomeDoArquivo.value,
                onValueChange = {
                    nomeDoArquivo.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                maxLines = 4,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.FileOpen,
                        tint = Color.Red,
                        contentDescription = "abrirArquivo"
                    )
                },
                placeholder = {
                    Text("COLE O ARQUIVO AQUI", color = Color.Red)
                },
                label = {
                    Text(text = "INSIRA O ARQUIVO AQUI", color = Color.Red)
                },
            )

            Spacer(modifier = Modifier.size(15.dp))

            Button(onClick = {
                var linhaArquivo =
                    Arquivo(updateLocalizacao = { latitude, longitude -> Unit }).linhaDados
            }) {
                Text(text = "SALVAR ARQUIVO")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaincerirArquivo() {
    InsereArquivo()
}
package com.example.supervisordeobra.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GrauDeCompactacao(navController: NavController = rememberNavController()) {

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
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .background(color = Color(0xFF552A27))
                    .clip(RoundedCornerShape(20.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { navController.navigate("dadosEnsaio") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "ENSAIO", fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.size(2.dp))
                Button(
                    onClick = { navController.navigate("laboratorio") },
                    modifier = Modifier.weight(1.5f)
                ) {
                    Text(
                        text = "LABORATÓRIO", fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.size(2.dp))
                Button(
                    onClick = { navController.navigate("dadosCampos") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "CAMPO", fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGrauDeCompactacao() {
    GrauDeCompactacao()
}

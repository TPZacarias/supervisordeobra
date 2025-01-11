package com.example.supervisordeobra.data

import android.content.Context
import android.os.Environment
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.supervisordeobra.domain.Conversor
import com.example.supervisordeobra.domain.Localizacao
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.Spliterator

class Arquivo(updateLocalizacao: (Double, Double) -> Unit) : Localizacao(updateLocalizacao) {

    var matrixArquivo = ArrayList<String>(arrayListOf())
    var matrixCoordenadas = ArrayList<Double>(arrayListOf())
    var matrixModulo = ArrayList<Double>(arrayListOf())
    var menorDistancia = ""
    var indexMenorDistancia = 0
    var indexCoordenada = 0.0
    var linhaDados = ""
    var latitudeFinal by mutableStateOf(0.0)
    var longitudeFinal by mutableStateOf(0.0)

    val atualizarLocalizacaoCallback: (Double, Double) -> Unit = { latitude, longitude ->
        latitudeFinal = latitude
        longitudeFinal = longitude
    }

    fun writeToFile(context: Context, fileName: String, content: String) {

        val f = File(Environment.getExternalStorageDirectory(), fileName)
        if (!f.exists()) {
            f.createNewFile()
        }
        val fileWriter = BufferedWriter(FileOutputStream(f).bufferedWriter())
        fileWriter.write(content)
        fileWriter.close()
    }

    fun readFromFile(context: Context, fileName: String): String {

        val data: StringBuffer = StringBuffer()
        val f = File(Environment.getExternalStorageDirectory(), fileName)
        if (!f.exists()) {
            Toast.makeText(context, "ARQUIVO NÃO ENCONTRADO", Toast.LENGTH_SHORT).show()

        } else {
            val fileReader = BufferedReader(FileInputStream(f).bufferedReader())
            var line = fileReader.readLine()
            while (line != null) {
                var latitudeFinal = Conversor(latitudeFinal, longitudeFinal).latitudeCoordenada
                matrixArquivo.add(line)
                var prineiroElemento = line.split(",").get(2).toDouble()
                var diferenca = prineiroElemento - latitudeFinal
                matrixCoordenadas.add(diferenca)
                line = fileReader.readLine()

            }
            var separdor: Spliterator<Double> = matrixCoordenadas.spliterator()

            separdor.forEachRemaining { s: Double ->
                if (s < 0) {
                    matrixModulo.add(s * -1)

                } else {
                    matrixModulo.add(s)
                }
            }
            menorDistancia = (matrixModulo.minOrNull().toString())
            indexMenorDistancia = matrixModulo.indexOf(menorDistancia.toDouble())
            linhaDados = matrixArquivo.get(indexMenorDistancia)

            fileReader.close()
        }
        return linhaDados
    }
}

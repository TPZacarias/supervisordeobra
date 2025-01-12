package com.example.supervisordeobra.data

import android.content.Context
import android.os.Environment
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.supervisordeobra.domain.ArquivoMapper
import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream

object ArquivoManager {

    var matrixArquivo = ArrayList<String>(arrayListOf())
    var matrixCoordenadas = ArrayList<Double>(arrayListOf())
    var matrixModulo = ArrayList<Double>(arrayListOf())
    var menorDistancia = ""
    var indexMenorDistancia = 0
    var indexCoordenada = 0.0
    var linhaDados = ""
    var latitudeFinal by mutableStateOf(0.0)
    var longitudeFinal by mutableStateOf(0.0)

    fun salvarArquivo(fileName: String, content: String) {

        val f = File(Environment.getExternalStorageDirectory(), fileName)
        if (!f.exists()) {
            f.createNewFile()
        }
        val fileWriter = BufferedWriter(FileOutputStream(f).bufferedWriter())
        fileWriter.write(content)
        fileWriter.close()
    }

    fun readFromFile(context: Context, fileName: String): ArquivoModel {

        var arquivoModel = ArquivoModel()
        val f = File(Environment.getExternalStorageDirectory(), fileName)
        if (!f.exists()) {
            Toast.makeText(context, "ARQUIVO NÃO ENCONTRADO", Toast.LENGTH_SHORT).show()
        } else {
            arquivoModel = ArquivoMapper.fromJson(f.readText())!!
        }

        return arquivoModel
    }
}

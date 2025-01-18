package com.example.supervisordeobra.data

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.supervisordeobra.domain.ArquivoMapper
import com.example.supervisordeobra.domain.LoggerUtil.logD
import com.example.supervisordeobra.domain.LoggerUtil.logE
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

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

    fun salvarArquivo(context: Context, fileName: String, content: String) {
        logD { "salvarArquivo" }

        try {
            val file = File(context.getExternalFilesDir(null), fileName)
            if (!file.exists()) {
                file.createNewFile()
            }
            val fileWriter = FileOutputStream(file).bufferedWriter()
            fileWriter.use {
                it.write(content)
            }
            Toast.makeText(context, "Arquivo salvo com sucesso", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            logE { "Erro: ${e.message}" }
            Toast.makeText(context, "Erro ao salvar o arquivo", Toast.LENGTH_SHORT).show()
        }
    }

    fun lerArquivo(context: Context, fileName: String): ArquivoModel {
        logD { "lerArquivo" }
        var arquivoModel = ArquivoModel()
        val file = File(context.getExternalFilesDir(null), fileName)
        if (!file.exists()) {
            Toast.makeText(context, "ARQUIVO NÃO ENCONTRADO", Toast.LENGTH_SHORT).show()
        } else {
            arquivoModel = ArquivoMapper.fromJson(file.readText())!!
        }
        return arquivoModel
    }
}

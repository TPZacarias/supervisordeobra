package com.example.supervisordeobra.domain

import com.example.supervisordeobra.data.ArquivoModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder

/**
 * Object responsible for mapping chat history to and from JSON format.
 */
object ArquivoMapper {

    private val gson: Gson = GsonBuilder().create()

    fun toJson(arquivo: ArquivoModel): String {
        return gson.toJson(arquivo)
    }

    fun fromJson(json: String?): ArquivoModel? {
        requireNotNull(json) { "JSON string cannot be null" }

        if (json.isBlank()) {
            return null
        }

        return try {
            val arquivo = gson.fromJson(json, ArquivoModel::class.java)
            arquivo
        } catch (e: Exception) {
            println("Error parsing JSON: ${e.message}")
            null
        }
    }
}

package com.example.supervisordeobra.domain

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@RequiresApi(Build.VERSION_CODES.O)
fun dataHora() {
    val dataFormatada: DateTimeFormatter =
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
    val captarHoraMain: LocalDateTime = now()
    val formatar: String = dataFormatada.format(captarHoraMain)
}

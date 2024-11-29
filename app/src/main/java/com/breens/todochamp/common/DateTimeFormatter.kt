package com.breens.todochamp.common

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Retorna a data atual como string
fun getCurrentTimeAsString(): String {
    val currentTime = Date()
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale("pt", "BR")) // Altera para português
    return dateFormat.format(currentTime)
}

// Converte uma string de data para um formato legível em português
fun convertDateFormat(dateString: String): String {
    val currentDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale("pt", "BR")) // Define o formato original em português
    val newDateFormat = SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy, HH:mm", Locale("pt", "BR")) // Formato novo em português
    val date = currentDateFormat.parse(dateString)
    return newDateFormat.format(date!!)
}
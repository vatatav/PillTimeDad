package com.vatatav.pilltimedad.data.model

data class Medication(
    val id: String = "",
    val name: String = "",
    val dosage: String = "",
    val startDate: String = "",
    val endDate: String = "",
    val schedule: List<String> = listOf(), // Günlük ilaç alma saatleri
    val photo: String = "", // İlaç fotoğrafının URL'i
    val status: String = "active" // "active" veya "inactive"
) 
package com.vatatav.pilltimedad.data.model

data class MedicationHistory(
    val id: String = "",
    val medicationId: String = "",
    val date: String = "",
    val time: String = "",
    val status: String = "taken" // "taken", "skipped", "delayed"
) 
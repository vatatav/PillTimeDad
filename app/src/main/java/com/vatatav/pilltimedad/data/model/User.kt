package com.vatatav.pilltimedad.data.model

data class User(
    val id: String = "",
    val name: String = "",
    val phone: String = "",
    val role: String = "hasta" // "hasta" veya "bakici"
) 
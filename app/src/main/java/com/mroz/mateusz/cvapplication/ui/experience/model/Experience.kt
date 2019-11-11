package com.mroz.mateusz.cvapplication.ui.experience.model


data class Experience(
    val date: String,
    val workPlace: String,
    val tasks: List<Task>
)
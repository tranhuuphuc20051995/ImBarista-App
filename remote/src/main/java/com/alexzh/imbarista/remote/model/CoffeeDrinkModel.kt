package com.alexzh.imbarista.remote.model

data class CoffeeDrinkModel(
    val id: Long = -1L,
    val name: String = "",
    val description: String = "",
    val ingredients: List<IngredientModel> = emptyList(),
    val isFavourite: Boolean = false
)
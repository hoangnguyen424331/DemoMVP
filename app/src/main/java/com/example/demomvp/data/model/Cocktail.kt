package com.example.demomvp.data.model

data class Cocktail(
    val id: String = "",
    val title: String = "",
    val urlImage: String = ""
)

object CocktailEntry {
    const val DRINKS = "drinks"
    const val ID = "idDrink"
    const val TITLE = "strDrink"
    const val URL_IMAGE = "strDrinkThumb"
}


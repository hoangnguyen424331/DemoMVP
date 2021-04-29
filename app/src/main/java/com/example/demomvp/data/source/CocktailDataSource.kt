package com.example.demomvp.data.source

import com.example.demomvp.data.model.Cocktail
import com.example.demomvp.data.source.remote.OnFetchDataJsonListener

interface CocktailDataSource {

    interface Remote {
        fun getCocktails(listener: OnFetchDataJsonListener<MutableList<Cocktail>>)
    }
}

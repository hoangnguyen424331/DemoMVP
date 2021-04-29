package com.example.demomvp.data.source

import com.example.demomvp.data.model.Cocktail
import com.example.demomvp.data.source.remote.CocktailRemoteDataSource
import com.example.demomvp.data.source.remote.OnFetchDataJsonListener

class CocktailRepository private constructor(
    private val remote: CocktailDataSource.Remote
) {

    private object Holder {
        val INSTANCE = CocktailRepository(
            remote = CocktailRemoteDataSource.instance
        )
    }

    fun getCocktail(listener: OnFetchDataJsonListener<MutableList<Cocktail>>) {
        remote.getCocktails(listener)
    }

    companion object {
        val instance: CocktailRepository by lazy { Holder.INSTANCE }
    }
}

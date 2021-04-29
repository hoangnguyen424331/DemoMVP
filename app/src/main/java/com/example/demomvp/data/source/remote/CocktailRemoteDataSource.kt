package com.example.demomvp.data.source.remote

import com.example.demomvp.data.model.Cocktail
import com.example.demomvp.data.model.CocktailEntry
import com.example.demomvp.data.source.CocktailDataSource
import com.example.demomvp.data.source.remote.fetchjson.GetJsonFromUrl
import com.example.demomvp.utils.Constant

@Suppress("DEPRECATION")
class CocktailRemoteDataSource : CocktailDataSource.Remote {

    private var baseUrl = Constant.BASE_URL

    override fun getCocktails(listener: OnFetchDataJsonListener<MutableList<Cocktail>>) {
        GetJsonFromUrl(listener, CocktailEntry.DRINKS).execute(baseUrl)
    }

    private object Holder {
        val INSTANCE = CocktailRemoteDataSource()
    }

    companion object {
        val instance: CocktailRemoteDataSource by lazy { Holder.INSTANCE }
    }
}

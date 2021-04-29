package com.example.demomvp.data.source.remote.fetchjson

import com.example.demomvp.data.model.Cocktail
import com.example.demomvp.data.model.CocktailEntry
import org.json.JSONObject

class ParseJson {

    fun cocktailParseJson(jsonObject: JSONObject) = jsonObject.run {
        Cocktail(
            id = getString(CocktailEntry.ID),
            title = getString(CocktailEntry.TITLE),
            urlImage = getString(CocktailEntry.URL_IMAGE)
        )
    }
}

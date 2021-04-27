@file:Suppress("DEPRECATION")

package com.example.demomvp.data.source.remote.fetchjson

import android.os.AsyncTask
import com.example.demomvp.data.source.remote.OnFetchDataJsonListener
import org.json.JSONObject

@Suppress("DEPRECATION", "UNCHECKED_CAST")
class GetJsonFromUrl<T> constructor(
    private val listener: OnFetchDataJsonListener<T>,
    private val keyEntity: String
) : AsyncTask<String?, Void?, String?>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg string: String?): String {
        var data = ""
        try {
            val parseDataWithJson = ParseDataWithJson()
            data = parseDataWithJson.getJsonFromUrl(string[0].toString())
        } catch (e: Exception) {
            exception = e
        }
        return data
    }

    override fun onPostExecute(data: String?) {
        super.onPostExecute(data)
        if (data != null && data.isNotBlank()) {
            val jsonObject = JSONObject(data)
            listener.onSuccess(ParseDataWithJson().parseJsonToData(jsonObject, keyEntity) as T)
        } else listener.onError(exception)
    }
}

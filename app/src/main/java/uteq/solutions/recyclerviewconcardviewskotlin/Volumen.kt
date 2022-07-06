package uteq.solutions.recyclerviewconcardviewskotlin

import android.util.Log
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class Volumen(a: JSONObject) {
    var issue_id: String
    var volume: String
    var number: String
    var year: String
    var date_published: String
    var title: String
    var doi: String
    var cover: String

    companion object {
        @Throws(JSONException::class)
        fun JsonObjectsBuild(datos: JSONArray): ArrayList<Volumen> {
            val volumen: ArrayList<Volumen> = ArrayList<Volumen>()
            var i = 0
            while (i < datos.length()) {
                volumen.add(Volumen(datos.getJSONObject(i)))
                i++
            }

            return volumen
        }
    }

    init {
        issue_id = a.getString("issue_id").toString()
        volume =  a.getString("volume").toString()
        number = a.getString("number").toString()
        year = a.getString("year").toString()
        date_published = a.getString("date_published").toString()
        title = a.getString("title").toString()
        doi = a.getString("doi").toString()
        cover = a.getString("cover").toString()
    }
}
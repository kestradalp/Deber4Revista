package uteq.solutions.recyclerviewconcardviewskotlin

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class Revista(a: JSONObject) {
    var journal_id: String
    var portada: String
    var abbreviation: String
    var description: String
    var journalThumbnail: String
    var name: String

    companion object {
        @Throws(JSONException::class)
        fun JsonObjectsBuild(datos: JSONArray): ArrayList<Revista> {
            val revista: ArrayList<Revista> = ArrayList<Revista>()
            var i = 0
            while (i < datos.length()) {
                revista.add(Revista(datos.getJSONObject(i)))
                i++
            }
            return revista
        }
    }

    init {
        journal_id = a.getString("journal_id").toString()
        portada =  a.getString("portada").toString()
        abbreviation = a.getString("abbreviation").toString()
        description = a.getString("description").toString()
        journalThumbnail = a.getString("journalThumbnail").toString()
        name = a.getString("name").toString()
    }
}
package uteq.solutions.recyclerviewconcardviewskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class VolumenActivity : AppCompatActivity() {
    var layoutManager: RecyclerView.LayoutManager? = null
    var adapter: RecyclerView.Adapter<RecyclerAdapterVol.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bundle=intent.extras
        var id = bundle?.getString("idRevista").toString()



        layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager



        val queue = Volley.newRequestQueue(this)
        val url = "https://revistas.uteq.edu.ec/ws/issues.php?j_id=3"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->

                val JSONlistaVolumenes: JSONArray = JSONArray(response)
                var lstVolumenes = ArrayList<Volumen>()
                lstVolumenes = Volumen.JsonObjectsBuild(JSONlistaVolumenes)
                val resId = R.anim.layout_animation_down_to_up
                val animation = AnimationUtils.loadLayoutAnimation(
                    applicationContext,
                    resId
                )
//                recyclerView.layoutAnimation = animation
//                adapter = RecyclerAdapterRev(lstRevistas, this)
//                recyclerView.adapter = adapter

            },
            Response.ErrorListener {  })
        queue.add(stringRequest)

    }
}
package uteq.solutions.recyclerviewconcardviewskotlin.Actividad

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import uteq.solutions.recyclerviewconcardviewskotlin.Adaptador.RecyclerAdapterRev
import uteq.solutions.recyclerviewconcardviewskotlin.Modelo.Revista
import uteq.solutions.recyclerviewconcardviewskotlin.R

class MainActivity : AppCompatActivity() {
    var layoutManager: RecyclerView.LayoutManager? = null
    var adapter: RecyclerView.Adapter<RecyclerAdapterRev.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager

        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET, "https://revistas.uteq.edu.ec/ws/journals.php",
            Response.Listener<String> { response ->

                val JSONlistaRevistas: JSONArray = JSONArray(response)
                var lstRevistas = ArrayList<Revista>()
                lstRevistas = Revista.JsonObjectsBuild(JSONlistaRevistas)
                val resId = R.anim.layout_animation_down_to_up
                val animation = AnimationUtils.loadLayoutAnimation(
                    applicationContext,
                    resId
                )
                recyclerView.layoutAnimation = animation
                adapter = RecyclerAdapterRev(lstRevistas, this)
                recyclerView.adapter = adapter

            },
            Response.ErrorListener {  })
        queue.add(stringRequest)
    }

}
package uteq.solutions.recyclerviewconcardviewskotlin.Adaptador

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import uteq.solutions.recyclerviewconcardviewskotlin.Actividad.VolumenActivity
import uteq.solutions.recyclerviewconcardviewskotlin.Modelo.Revista
import uteq.solutions.recyclerviewconcardviewskotlin.R

class RecyclerAdapterRev (val revList: ArrayList<Revista>, contexto: Context) : RecyclerView.Adapter<RecyclerAdapterRev.ViewHolder>() {

    val context:Context = contexto

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.lyitemrevcard, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtNombre.text = revList[position].name
        Picasso.get().load(revList[position].portada).into(holder.itemImage);
    }

    override fun getItemCount(): Int {
        return revList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var txtNombre: TextView

        init {
            txtNombre = itemView.findViewById(R.id.txtName)
            itemImage = itemView.findViewById(R.id.imgAvatar)

            itemView.setOnClickListener { v: View  ->
                var position: Int = getAdapterPosition()
                var idRevista:String = revList[position].journal_id

                val intent= Intent(context, VolumenActivity::class.java)
                intent.putExtra("idRevista", position)
                ContextCompat.startActivity(context,intent, null)

                Snackbar.make(v, "Item Selecccionado ${revList[position].name}",
                    Snackbar.LENGTH_LONG).setAction("Actción", null).show()



            }
        }
    }
}
package uteq.solutions.recyclerviewconcardviewskotlin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import android.content.Context


class RecyclerAdapterVol (val volList: ArrayList<Volumen>) : RecyclerView.Adapter<RecyclerAdapterVol.ViewHolder>() {

//    val context:Context = TODO()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.lyitemrevcard, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtNombre.text = volList[position].title
        Picasso.get().load(volList[position].cover).into(holder.itemImage);
    }

    override fun getItemCount(): Int {
        return volList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var txtNombre: TextView

        init {
            txtNombre = itemView.findViewById(R.id.txtName)
            itemImage = itemView.findViewById(R.id.imgAvatar)

            itemView.setOnClickListener { v: View  ->
                var position: Int = getAdapterPosition()


//                val bundle = Bundle()
//                val i= Intent(context,VolumenActivity::class.java)
//                ContextCompat.startActivity(context,i, null)
//                bundle.putString("posicion", position.toString())

                Snackbar.make(v, "Item Selecccionado $position",
                    Snackbar.LENGTH_LONG).setAction("Actción", null).show()



            }
        }
    }
}
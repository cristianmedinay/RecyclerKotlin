package com.example.recyclerkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
//import com.squareup.picasso.Picasso

class RecyclerPersona (private val context: Context, val persona:List<Persona>,
                       val linstener:OnPersonaSelected):RecyclerView.Adapter<RecyclerPersona.MiHolder>() {


    interface OnPersonaSelected{
        fun onImageSelected(persona:Persona)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_persona,parent,false);
        return MiHolder(itemView);
    }

    override fun onBindViewHolder(holder: MiHolder, position: Int) {
        val perso = persona[position]
        //holder.imagen.setImageResource(perso.imagen)
        //Picasso.get().load(perso.imagen).resize(50, 50).into(holder.imagen);
        //imagen.setImageResource(Integer.parseInt(ciudad.getImagen()));

        Glide.with(context).load(perso.imagen).apply(RequestOptions.circleCropTransform()).into(holder.imagen)
        holder.nombre.setText(perso.nombre)
        holder.apellido.setText(perso.apellido)

        holder.imagen.setOnClickListener{
            linstener.onImageSelected(perso)
        }


    }

    override fun getItemCount(): Int {
        return persona.size
    }

    inner class MiHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

        var imagen:ImageView
        var nombre:TextView
        var apellido:TextView

        init {
            imagen = itemView.findViewById(R.id.imagenvista);
            nombre = itemView.findViewById(R.id.nombrevista);
            apellido = itemView.findViewById(R.id.apellidovista);
        }


    }

}




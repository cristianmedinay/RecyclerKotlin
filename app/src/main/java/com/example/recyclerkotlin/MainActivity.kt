package com.example.recyclerkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),RecyclerPersona.OnPersonaSelected {

    lateinit var recycler:RecyclerView
    //lateinit var listaPersonas: ArrayList<Persona>

    var listaPersonas: List<Persona> = listOf(

        Persona("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Brad_Pitt_2019_by_Glenn_Francis.jpg/599px-Brad_Pitt_2019_by_Glenn_Francis.jpg","Brat","Pit"),
        Persona("https://phantom-telva.unidadeditorial.es/99da4ecff6d748daf9a16d16aa868bef/crop/0x0/2038x2880/resize/828/f/jpg/assets/multimedia/imagenes/2021/05/06/16202888369890.jpg","George","Clonet"),
        Persona("https://media.vogue.es/photos/6103b3b7f8089797e7a62d24/2:3/w_2560%2Cc_limit/202183436_1174473083056281_7191844845131551308_n.jpg","Jennifer","Lopez"),
        Persona("https://estaticos.marie-claire.es/media/cache/1140x_thumb/uploads/images/gallery/5dc54a5f5cafe8c07d6d2e3e/leo11grande.jpg","Lonardo","Di Caprio"),
        Persona("https://www.cnnbrasil.com.br/wp-content/uploads/sites/12/2021/06/24630_7E9A5B3C65889D88.jpg?w=1024","Angelina","Jolie"),
        Persona("https://upload.wikimedia.org/wikipedia/commons/c/c2/Tobey_Maguire_2014.jpg","Tobey","Maguire"),
        Persona("https://fotos.perfil.com/2021/06/22/cropped/1200/1200/center/margot-robbie-1193882.jpg","Margot","Robbie"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias();


    }

     fun instancias() {
        recycler = findViewById(R.id.lista)
        recycler.layoutManager = LinearLayoutManager(this);
        //val adapter = RecyclerPersona(this,listaPersonas)
        //listaPersonas = ArrayList<Persona>()

         recycler.adapter = RecyclerPersona(this,listaPersonas,this)

    }

    override fun onImageSelected(persona:Persona) {
        Toast.makeText(this,"PULSADO",Toast.LENGTH_LONG).show()
        val intent = Intent(this,Detalle::class.java)
        intent.putExtra("imagen",persona.imagen)
        startActivity(intent)
    }


}



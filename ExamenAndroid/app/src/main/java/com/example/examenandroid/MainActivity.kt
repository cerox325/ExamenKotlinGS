package com.example.examenandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var lista:RecyclerView? = null
    var adapter:AdapterCustom? = null
    var layoutManager:RecyclerView.LayoutManager? = null
    private val File = 1
    private val database = Firebase.database
    val myRef = database.getReference("imgMovie")
    private lateinit var locationCallback: LocationCallback



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnUbicacion.setOnClickListener {
            fileUpload()
        }

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult ?: return
                for (location in locationResult.locations){
                    updateValuesFromBundle(savedInstanceState)
                }
            }
        }



        val movies = ArrayList<Movie>()

        movies.add(Movie("Fight Club","tag","status"))
        movies.add(Movie("2","tag","status"))
        movies.add(Movie("3","tag","status"))





        lista = findViewById(R.id.lista)
        lista?.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        lista?.layoutManager = layoutManager

        adapter = AdapterCustom(this,movies)
        lista?.adapter = adapter


    }

    fun fileUpload(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        startActivityForResult(intent,File)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == File){
            if (resultCode == Activity.RESULT_OK){
                val Fileuri = data!!.data
                val Folder: StorageReference = FirebaseStorage.getInstance().getReference().child("imgMovie")
                val file_name:StorageReference = Folder.child("file"+Fileuri!!.lastPathSegment)
                file_name.putFile(Fileuri).addOnSuccessListener { taskSnapshot ->
                    file_name.downloadUrl.addOnSuccessListener { uri ->
                        val hashMap = HashMap<String,String>()
                       Toast.makeText(this,"Imagen Cargada en la BD", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun updateValuesFromBundle(savedInstanceState: Bundle?) {
        savedInstanceState ?: return
    }



}

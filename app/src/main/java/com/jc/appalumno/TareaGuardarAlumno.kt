package com.jc.appalumno

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class TareaGuardarAlumno(var texto:TextInputEditText?, var ctx:Context?):
    AsyncTask<Void,Void,Void>(){
    //Declaramos dos tributos para nuestra interacción con el bakc-end
    var alumno=Alumno()
    var estatus=Estatus()


    override fun onPreExecute() {
        super.onPreExecute()
        alumno.email=texto?.text.toString()


    }


    override fun doInBackground(vararg p0: Void?): Void? {


        //Aqui vamos a preparar nuestro objeto alumno que ya tenemos para enviar a
        // El back-end
        //Aqui usaremos la bibloteca REtrofir que es muy iportante

        var retrofit= Retrofit.Builder()
            .baseUrl("https://invierno.herokuapp.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        var servicioAlumno=retrofit.create(ServicioAlumno::class.java)
        var envio=servicioAlumno.guardar(alumno)
        estatus=envio.execute().body()!!
        return null
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        Log.i("YO",estatus.mensaje!!)
        //   texto?.text=estatus.mensaje!!
        Toast.makeText(ctx, estatus.mensaje, Toast.LENGTH_LONG ).show()
    }



}
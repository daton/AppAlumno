package com.jc.appalumno

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class TareaAutenticarAlumno(var txtEmail:TextInputEditText?,
                            var txtPswd:TextInputEditText?,
                            var ctx:Context?):
    AsyncTask<Void,Void,Void>(){
    //Declaramos dos tributos para nuestra interacción con el bakc-end
    var alumno=Alumno()
    var estatus=Estatus()


    override fun onPreExecute() {
        super.onPreExecute()
        alumno.email=txtEmail?.text.toString()
        alumno.password=txtPswd?.text.toString()


    }

//Metodo doInBackground
    override fun doInBackground(vararg p0: Void?): Void? {


        //Aqui vamos a preparar nuestro objeto alumno que ya tenemos para enviar a
        // El back-end
        //Aqui usaremos la bibloteca REtrofir que es muy iportante

        var retrofit= Retrofit.Builder()
                //lssaslajsals
          //  .baseUrl("https://invierno.herokuapp.com/")
            .baseUrl("https://admingeer.herokuapp.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        var servicioAlumno=retrofit.create(ServicioAlumno::class.java)
        var envio=servicioAlumno.autenticar(alumno)
        alumno=envio.execute().body()!!
        return null
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)

        //   texto?.text=estatus.mensaje!!

        //Aqui una condicion de que si el id es distinto de null los lleve a la siguiente
        //activity
        if(alumno.id!=null){
            var intent= Intent(ctx?.applicationContext, BienvenidoActivity::class.java)
            ctx?.startActivity(intent);
        }else{

            Toast.makeText(ctx,"NO se pudo autenticar", Toast.LENGTH_LONG).show()
        }

    }



}

# Excluimos las licencias duplicadas
Excluimos:

```
packagingOptions {
        exclude 'META-INF/ASL2.0'
        exclude 'META-INF/LICENSE'
        exclude 'META-INF/license.txt'
        exclude 'META-INF/NOTICE'
        exclude 'META-INF/notice.txt'
    }

```

# Agregamos las dependencias de Retrofit

```
//Las siguientes dependencias son las usadas para retrofit en android
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-jackson:2.5.0'


```
# Agregamos los permisos de internet
```
<uses-permission android:name="android.permission.INTERNET"/>
```

# Agregamos las interfaces de los repositorios de nuestras entidades

```

interface ServicioAlumno {


    @POST("api/alumno")
    fun guardar(@Body alumno:Alumno): Call<Estatus>

    @POST("api/alumno/autenticar")
    fun autenticar(@Body alumno:Alumno):Call<Alumno>

    @GET("api/alumno/{id}")
    fun buscarPorId(@Path("id") id:String?):Call<Alumno>

    @GET("api/alumno/{email}")
    fun buscarPorEmail(@Path("email") nombre:String?):Call<ArrayList<Alumno>>

    @GET("api/alumno")
    fun buscarTodos():Call<ArrayList<Alumno>>
}

# Generar una tarea asincronica 

```

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
```

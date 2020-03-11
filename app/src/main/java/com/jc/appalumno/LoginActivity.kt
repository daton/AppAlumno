package com.jc.appalumno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //
        autenticar.setOnClickListener {
            //Pedir los valores a los campos de texto
          txtEmail as TextInputEditText
          txtPassword as TextInputEditText
      var email=      txtEmail.text.toString()
      var paswd=txtPassword.text.toString();
         //Tarea Guadar alumno
            TareaGuardarAlumno(txtEmail,txtPassword, this)
                .execute(null,null,null)

        }
    }
}

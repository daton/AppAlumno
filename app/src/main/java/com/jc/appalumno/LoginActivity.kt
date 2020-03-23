package com.jc.appalumno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //Invocamos el boton y su evento
        ingresar.setOnClickListener {
            TareaGuardarAlumno(txtEmail,txtPassword,this)
                .execute(null,null,null)
        }

    }
}

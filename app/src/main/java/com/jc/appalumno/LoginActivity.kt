package com.jc.appalumno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //Invocamos el boton y su evento
        autenticar.setOnClickListener {
            TareaAutenticarAlumno(txtEmail,txtPassword,this)
                .execute(null,null,null)
        }

    }
}

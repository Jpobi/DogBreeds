package com.example.dogbreeds

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    public lateinit var inputUser: EditText
    public lateinit var inputPass: EditText
    public lateinit var btnLogin: Button
    public lateinit var btnRegister: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        inputUser=findViewById(R.id.usernameInput)
        inputPass=findViewById(R.id.passInput)
        btnLogin=findViewById(R.id.buttonLogin)
        btnRegister=findViewById(R.id.buttonRegister)

        btnLogin.setOnClickListener{
            if (inputUser.text.isNullOrEmpty() || inputPass.text.isNullOrEmpty()) {
                Toast.makeText(this, "Error: Faltan Datos. Regístrese!", Toast.LENGTH_SHORT).show()
            }else{
                val sharedPreferences= this.getSharedPreferences(
                    "credenciales", Context.MODE_PRIVATE
                )
                val username=sharedPreferences.getString("username","Null")
                val password=sharedPreferences.getString("password","Null")
                if(inputUser.text.toString()!= username || inputPass.text.toString()!= password){
                    Toast.makeText(this, "Error: Datos erróneos. Regístrese!", Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(this, "¡Bienvenido!", Toast.LENGTH_SHORT).show()
                    startActivity(
                        Intent(this,MainActivity::class.java)
                    )
                }

            }
        }
        btnRegister.setOnClickListener{
            startActivity(
                Intent(this,RegisterActivity::class.java)
            )
        }
    }
}
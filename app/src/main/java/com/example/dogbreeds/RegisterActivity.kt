package com.example.dogbreeds

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var inputUser: EditText
    private lateinit var inputPass: EditText
    private lateinit var btnRegister: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        inputUser=findViewById(R.id.usernameInputReg)
        inputPass=findViewById(R.id.passInputReg)
        btnRegister=findViewById(R.id.buttonRegisterReg)

        btnRegister.setOnClickListener{
            if (inputUser.text.isNullOrEmpty() || inputPass.text.isNullOrEmpty()) {
                Toast.makeText(this, "Faltan Datos!", Toast.LENGTH_SHORT).show()
            }else{
                val sharedPreferences= this.getSharedPreferences(
                    "credenciales", Context.MODE_PRIVATE
                )
                val editor= sharedPreferences.edit()
                editor.putString("username",inputUser.text.toString())
                editor.putString("password",inputPass.text.toString())
                editor.commit()//apply()

                startActivity(
                    Intent(this,LoginActivity::class.java)
                )
            }
        }

    }
}
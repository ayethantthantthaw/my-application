package com.example.walmal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.walmal.Register.Register
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tv_register.setOnClickListener {
            val register = Intent(this@Login, Register::class.java)
            startActivity(register)
        }
        btn_sign_in.setOnClickListener {
            if (et_user.text.toString().equals("Customer")) {
                val sign_in = Intent(this@Login, MainActivity::class.java)
                startActivity(sign_in)
                finish()
            }





            else {
                Toast.makeText(this,"Seller Site",Toast.LENGTH_LONG).show()
            }

        }
    }

}

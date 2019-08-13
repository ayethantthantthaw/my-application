package com.example.walmal.Register

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.walmal.Login
import com.example.walmal.R
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btn_register.setOnClickListener {
            val name=userName.text.toString()
            val email=email.text.toString()
            val password=password.text.toString()
            val confirm_password=confirmPassword.text.toString()
            val nrc=nrc.text.toString()
            val phone=phone.text.toString()
            val address=address.text.toString()
            val webClient = SeverRequest.retrofitClient.register(name,email,password,confirm_password,nrc,phone,address)
            webClient.enqueue(object: Callback<ServerRespone> {
                override fun onFailure(call: Call<ServerRespone>, t: Throwable) {
                    Log.e("register",t.message.toString())
                    //progressBar.visibility = View.GONE
                }


                override fun onResponse(call: Call<ServerRespone>, response: Response<ServerRespone>) {
                    Log.e("register",response.body().toString())
                    //progressBar.visibility = View.GONE
                    val res = response.body()
                    val message=res?.data?.message
                    t("$message")
                    if(message.equals("successful")) {
                        val i = Intent(this@Register, Login::class.java)
                        startActivity(i)

                        finish()
                    }
                    else{
                        Toast.makeText(this@Register,"Something Wrong",Toast.LENGTH_SHORT).show()
                    }
                }

            })


        }
    }
    fun Context.t(s:String){
        Toast.makeText(applicationContext,s, Toast.LENGTH_SHORT).show()}
}



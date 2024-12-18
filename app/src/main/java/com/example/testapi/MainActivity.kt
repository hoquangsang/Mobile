package com.example.testapi

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.testapi.services.api.ApiManager
import com.example.testapi.services.requests.PostSignInRequest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val submitButton = findViewById<Button>(R.id.submit)
        submitButton.setOnClickListener {
            testApi()
//            submitForm()
        }
    }git init


    private fun testApi() {
        ApiManager.getApiManager().testApi(
            onSuccess = { response ->
                if (response != null) {
                    Toast.makeText(this, response.data.toString(), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Không thành công", Toast.LENGTH_SHORT).show()
                } 
            },
            onError = { errorMessage ->
                Log.e("Login", "Error: $errorMessage")
                Toast.makeText(this, "Không thành công", Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun submitForm() {
        val emailField = findViewById<EditText>(R.id.email)
        val passwordField = findViewById<EditText>(R.id.password)

        val email = emailField.text.toString().trim()
        val password = passwordField.text.toString().trim()

        // Kiểm tra dữ liệu hợp lệ
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, email, Toast.LENGTH_SHORT).show()
            Toast.makeText(this, password, Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            return
        }

        val postSignInRequest = PostSignInRequest(
            email = email,
            password = password,
            phone = null
        )

        ApiManager.getApiManager().login(
            postSignInRequest,
            onSuccess = { response ->
                if (response?.data != null && response.token != null) {

                    Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()

                    Log.d("token", response.token!!)
                    Log.d("data", response.data!!.toString())


                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
                } else {
                    Toast.makeText(this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show()
                }
            },
            onError = { errorMessage ->
                Log.e("Login", "Error: $errorMessage")
                Toast.makeText(this, "Đăng nhập thất bại: $errorMessage", Toast.LENGTH_SHORT).show()
            }
        )
    }
}

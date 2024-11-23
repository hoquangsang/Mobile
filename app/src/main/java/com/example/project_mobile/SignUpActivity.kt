package com.example.project_mobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_mobile.databinding.ActivitySignUpBinding
import com.example.project_mobile.models.User

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonCreateAccount.setOnClickListener {
            // Handle create account button click
            if (validateFields(
                    binding.editTextUsername.text.toString(),
                    binding.editTextPhoneEmail.text.toString(),
                    binding.editTextPassword.text.toString()
                )
            ) {
                // Create account
            }
        }
    }

    private fun validateFields(username: String, email_phone: String, password: String): Boolean {
        // Validate fields
        val user = User(username, email_phone, password)

        if (!user.isNameValid()) {
            binding.editTextUsername.error = "Invalid name"
            return false
        }

        if (!user.isEmailValid() && !user.isPhoneValid()) {
            binding.editTextPhoneEmail.error = "Invalid email or phone"
            return false
        }

        if (!user.isPasswordValid()) {
            binding.editTextPassword.error = "Invalid password"
            return false
        }

        return true
    }
}
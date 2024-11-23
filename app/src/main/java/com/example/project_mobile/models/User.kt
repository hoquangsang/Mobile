package com.example.project_mobile.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    var id: Int,
    var name: String,
    var email: String,
    var phone: String,
    var password: String,
    var image: String = "",
    var address: String = "",
    var role: String = "user",
    var specialty: String = ""
) {
    constructor(name: String, emailPhone: String, password: String) : this(0, name, "", "", password)
    {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailPhone).matches())
            this.email = emailPhone
        else
            this.phone = emailPhone
    }

   fun isEmailValid(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isPasswordValid(): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$"
        return password.matches(passwordPattern.toRegex())
    }

    fun isPhoneValid(): Boolean {
        val phonePattern = "^(\\+\\d{1,3}[- ]?)?\\d{10}$"
        return phone.matches(phonePattern.toRegex())
    }

    fun isNameValid(): Boolean {
        val namePattern = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$"
        return name.matches(namePattern.toRegex())
    }

    fun isValid(): Boolean {
        return isEmailValid() && isPasswordValid() && isPhoneValid() && isNameValid()
    }
}
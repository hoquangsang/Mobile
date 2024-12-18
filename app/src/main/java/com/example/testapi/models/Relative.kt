package com.example.testapi.models

import com.google.gson.annotations.SerializedName

data class Relative (
    @SerializedName("name") var name: String? = null,
    @SerializedName("avatar") var avatar: String? = null,
    @SerializedName("email") var email: String = "",
    @SerializedName("relationship") var relationship: String = "",
)
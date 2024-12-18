package com.example.testapi.models

import com.google.gson.annotations.SerializedName


data class UserInfo(
    @SerializedName("_id") var _id: String = "",//
    @SerializedName("name") var name: String = "",
    @SerializedName("address") var address: String? = null,
    @SerializedName("location") var location: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("email") var email: String,
    //@SerializedName("password") var password: String?,
    @SerializedName("role") var role: String? = null,
    @SerializedName("avatar") var avatar: String? = null,
    @SerializedName("relatives") var relatives: List<Relative>? = null,
    @SerializedName("dob") var dob: String? = null,
    @SerializedName("gender") var gender: String? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("citizenId") var citizenId: String? = null,
    //more...
) {
}
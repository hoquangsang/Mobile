package com.example.testapi.services.response

import com.google.gson.annotations.SerializedName

data class PostSignUpResponse(
    @SerializedName("error") var error: Boolean,
    @SerializedName("message") var message: String,
    @SerializedName("data") var token: String?,
) {
    data class PostSignUpResponseData(
        @SerializedName("access_token") var accessToken: String?,
        @SerializedName("refresh_token") var refreshToken: String?
    )
}

/*
{"error":0,"message":"User created successfully","data":"akjnkvjsdv.sdvsvsdvsdv..."}
{"error":1,"message":"User alreadly exits","data":null}
 */
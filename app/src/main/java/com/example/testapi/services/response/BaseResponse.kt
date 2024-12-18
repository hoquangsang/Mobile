package com.example.testapi.services.response

import com.google.gson.annotations.SerializedName

open class BaseResponse<T>(
    @SerializedName("result") var result: String? = null,
    @SerializedName("error") var error: Boolean? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("data") open var data: T? = null
)
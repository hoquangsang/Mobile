package com.example.testapi.services.response

import com.example.testapi.models.UserInfo
import com.google.gson.annotations.SerializedName

//Interface
data class PostSignInResponse(
    @SerializedName("result") var result: String? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("token") var token: String? = null,
    @SerializedName("data") var data: UserInfo? = null,
)
//=> success, fail : interface


/*
{"message":"User not found"} //email wrong
{"message":"Password is incorrect"} //(empty email + invalid pass)
{
"result":"signin successfully",
"token":"[token]",
"data":{
	"_id":"6758a6715a8c93f7a9f0fc43",
	"name":"hoquangsang",
	"address":"Tan Phu, Thu Duc, Ho Chi Minh",
	"location":"12.223, 102.442",
	"phone":"098765432",
	"email":"sangdinhban@gmail.com",
	"password":"$2b$10$6Rr27GpUP/lbXLqUDZElQuZWdjzAy49pDur6BqpiT/y7G83i5YVm6",
	"role":"user"
}}
 */
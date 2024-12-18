package com.example.testapi.services.response

import com.example.testapi.models.UserInfo
import com.google.gson.annotations.SerializedName

data class GetUserInfoResponse(
    @SerializedName("error")    var error: Boolean?,
    @SerializedName("message")  var message: String?,
    @SerializedName("data")     var data: UserInfo?,
) {
//    data class GetUserInfoResponseData(
//        val empty: Any? = null
//    )
}

/*
{"error":1,"message":"Invalid token","data":null}
{"data":{
	"_id":"6758a6715a8c93f7a9f0fc43",
	"name":"Ho Quang Sang",
	"address":"Tan Phu, Thu Duc, Ho Chi Minh",
	"location":"12.223, 102.442",
	"phone":"098765432",
	"email":"sangdinhban@gmail.com",
	"password":"$2b$10$6Rr27GpUP/lbXLqUDZElQuZWdjzAy49pDur6BqpiT/y7G83i5YVm6",
	"role":"user",
	"avatar":"https://bizweb.dktcdn.net/100/438/408/files/anh-luffy-yody-vn-67.jpg?v=1688806271889",
	"relatives":[
		{"id":"675894765a8c93f7a9f0fc34","email":"hoanglenu@gmail.com","relation":"Ch?"},
		{"id":"675bdf7603832ca9de796a44","email":"hoanglenam@gmail.com","relation":"Em"},
		{"id":"675bf5190a36c5814b752663","email":"songtungmtp@gmail.com","relation":"Anh"}
	],
	"dob":"2004-03-12",
	"gender":"male",
	"status":"inactive"
	}
}}
 */
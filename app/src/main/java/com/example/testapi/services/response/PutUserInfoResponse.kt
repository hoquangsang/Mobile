package com.example.testapi.services.response

import com.google.gson.annotations.SerializedName

data class PutUserInfoResponse(
    @SerializedName("error") var error: Boolean? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("data") var data: PutUserInfoResponseData? = null
) {
    data class PutUserInfoResponseData(
        @SerializedName("acknowledged") var acknowledged: Boolean?,
        @SerializedName("modifiedCount") var modifiedCount: Int?,
        @SerializedName("upsertedId") var upsertedId: String?,
        @SerializedName("upsertedCount") var upsertedCount: Int?,
        @SerializedName("matchedCount") var matchedCount: Int?,
    )
}

//data class PutUserInfoResponse(
//    @SerializedName("error") var error: Any?,
//    @SerializedName("message") var message: String,
//    @SerializedName("data") var data: PutUserInfoResponseData?,
//)

/*
{"error":1,"message":"Invalid token","data":null}
    -> bash: -d: command not found
{"message":"Cập nhật tài khoản thành công","data":{"acknowledged":true,"modifiedCount":0,"upsertedId":null,"upsertedCount":0,"matchedCount":1}}

curl -X 'PUT' \
  'http://localhost:3001/api/v1/users/6758a6715a8c93f7a9f0fc43' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -H 'Authorization: Bearer <token>
  -d '{
  <String>: <Any>
}'
*/
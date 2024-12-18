package com.example.testapi.services.requests

import com.google.gson.annotations.SerializedName

data class PostSignInRequest (
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("phone") val phone: String? = null,
)

/*
curl -X 'POST' \
'http://localhost:3001/api/v1/users/login' \
-H 'accept: application/json' \
-H 'Content-Type: application/json' \
-d '{
"email": "",
"password": ""
}'
*/
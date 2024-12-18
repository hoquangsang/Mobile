package com.example.testapi.services.requests

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,

    @SerializedName("phone") val phone: String?,
    //more... ex: avatar: sign up on facebook
)
/*
curl -X 'POST' \
  'http://localhost:3001/api/v1/users/register' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "",
  "address": "",
  "location": "",
  "phone": "",
  "email": "",
  "password": "",
  "role": ""
}'
*/
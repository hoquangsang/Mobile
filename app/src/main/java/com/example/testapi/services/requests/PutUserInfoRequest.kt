package com.example.testapi.services.requests

typealias PutUserInfoRequest = Map<String, Any>

//import com.google.gson.annotations.SerializedName
//
//data class PutUserInfoRequest(
//    @SerializedName("data")
//    val data: Map<String, Any>?,
//)

/*curl -X 'PUT' \
  'http://localhost:3001/api/v1/users/6758a6715a8c93f7a9f0fc43' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -H 'Authorization: Bearer <token>' \
  -d '{
  "status": "inactive",
  "gender": "male",
  "dob": "2004-03-12",
  "relatives": [
    {
      "id": "675894765a8c93f7a9f0fc34",
      "email": "hoanglenu@gmail.com",
      "relation": "Chị"
    },
    {
      "id": "675bdf7603832ca9de796a44",
      "email": "hoanglenam@gmail.com",
      "relation": "Em"
    },
    {
      "id": "675bf5190a36c5814b752663",
      "email": "songtungmtp@gmail.com",
      "relation": "Anh"
    }
  ]
}'


{"error":{"status":400,"message":"Unexpected string in JSON at position 407"}}


 */
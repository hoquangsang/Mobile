package com.example.project_mobile.models

class Clinic(
    var id: Int,
    var name: String,
    var address: String,
    var phone: String,
    var image: String,
    var rating: Float,
    var description: String,
    var services: ArrayList<HealthService>
) {

}
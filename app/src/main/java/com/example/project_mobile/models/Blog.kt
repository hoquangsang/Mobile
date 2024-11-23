package com.example.project_mobile.models

class Blog(
    var title: String,
    var description: String,
    var image: String,
    var date: String,
    var rating: Int,
    var author: User,
) {
    override fun toString(): String {
        return "Blog(title='$title', description='$description', image='$image', date='$date', author=$author)"
    }
}
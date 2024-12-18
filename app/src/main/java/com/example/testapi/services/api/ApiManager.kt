package com.example.testapi.services.api

import com.example.testapi.services.requests.PostSignInRequest
import com.example.testapi.services.requests.PostSignUpRequest
import com.example.testapi.services.requests.PutUserInfoRequest
import com.example.testapi.services.response.GetUserInfoResponse
import com.example.testapi.services.response.PostSignInResponse
import com.example.testapi.services.response.PostSignUpResponse
import com.example.testapi.services.response.PutUserInfoResponse
import com.google.gson.annotations.SerializedName



class ApiManager {
    companion object {
        private val instance: ApiManager by lazy { ApiManager() }

        fun getApiManager(): ApiManager = instance
    }

    data class TestRes(
        @SerializedName("data") val data: String? = null
    )
    fun testApi(
        onSuccess: (TestRes?) -> Unit,
        onError: (String?) -> Unit
    ) {
        ApiHelper.executeRequest<TestRes>(
            method = "GET",
            path = "api/v1",
            headers = mapOf(
                "accept" to "application/json",
            ),
            clazz = TestRes::class.java,
            onSuccess = onSuccess,
            onError = onError
        )
    }

    // Đăng ký tài khoản
    fun register(
        postSignUpRequest: PostSignUpRequest,
        onSuccess: (PostSignUpResponse?) -> Unit,
        onError: (String?) -> Unit
    ) {
        ApiHelper.executeRequest<PostSignUpResponse>(
            method = "POST",
            path = "api/v1/users/register",
            headers = mapOf(
                "accept" to "application/json",
                "Content-Type" to "application/json; charset=UTF-8"
            ),
            body = postSignUpRequest,
            clazz = PostSignUpResponse::class.java,
            onSuccess = onSuccess,
            onError = onError
        )
    }

    // Đăng nhập
    fun login(
        postSignInRequest: PostSignInRequest,
        onSuccess: (PostSignInResponse?) -> Unit,
        onError: (String?) -> Unit
    ) {
        ApiHelper.executeRequest<PostSignInResponse>(
            method = "POST",
            path = "api/v1/users/login",
            headers = mapOf(
                "accept" to "application/json",
                "Content-Type" to "application/json; charset=UTF-8"
            ),
            body = postSignInRequest,
            clazz = PostSignInResponse::class.java,
            onSuccess = onSuccess,
            onError = onError
        )
    }

    // Lấy thông tin người dùng
    fun getUserInfo(
        token: String,
        onSuccess: (GetUserInfoResponse?) -> Unit,
        onError: (String?) -> Unit
    ) {
        ApiHelper.executeRequest<GetUserInfoResponse>(
            method = "GET",
            path = "api/v1/users/info",
            headers = mapOf(
                "accept" to "application/json",
                "Authorization" to "Bearer $token"
            ),
            clazz = GetUserInfoResponse::class.java,
            onSuccess = onSuccess,
            onError = onError
        )
    }

    // Cập nhật thông tin người dùng
    fun updateUserInfo(
        userId: String,
        token: String,
        request: PutUserInfoRequest,
        onSuccess: (PutUserInfoResponse?) -> Unit,
        onError: (String?) -> Unit
    ) {
        ApiHelper.executeRequest<PutUserInfoResponse>(
            method = "PUT",
            path = "api/v1/users/$userId",
            headers = mapOf(
                "accept" to "application/json",
                "Content-Type" to "application/json; charset=UTF-8",
                "Authorization" to "Bearer $token"
            ),
            body = request,
            clazz = PutUserInfoResponse::class.java,
            onSuccess = onSuccess,
            onError = onError
        )
    }
}

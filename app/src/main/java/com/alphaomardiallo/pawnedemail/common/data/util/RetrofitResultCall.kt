package com.alphaomardiallo.pawnedemail.common.data.util

import com.alphaomardiallo.pawnedemail.common.domain.model.ErrorEntity
import okhttp3.Request
import okio.IOException
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class RetrofitResultCall<T>(private val delegate: Call<T>) : Call<ApiResponse<T>> {
    override fun clone(): Call<ApiResponse<T>> {
        return RetrofitResultCall(delegate.clone())
    }

    override fun execute(): Response<ApiResponse<T>> {
        return Response.success(ApiResponse.ApiSuccess(delegate.execute().body()!!))
    }

    override fun enqueue(callback: Callback<ApiResponse<T>>) {
        delegate.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()

                if (response.isSuccessful && body != null) {
                    callback.onResponse(
                        this@RetrofitResultCall,
                        Response.success(
                            /* code = */ response.code(),
                            /* body = */ ApiResponse.ApiSuccess(body)
                        )
                    )
                } else {
                    callback.onResponse(
                        this@RetrofitResultCall,
                        Response.success(
                            ApiResponse.ApiError(
                                internalErrorCode = response.code(),
                                interErrorBody = response.errorBody()
                            )
                        )
                    )
                }
            }

            override fun onFailure(call: Call<T>, throwable: Throwable) {
                callback.onResponse(
                    this@RetrofitResultCall,
                    Response.success(
                        when (throwable) {
                            is IOException -> ApiResponse.ApiException(ErrorEntity.Network)
                            is HttpException -> ApiResponse.ApiError(
                                throwable.code(),
                                throwable.response()?.errorBody()
                            )
                            else -> ApiResponse.ApiException(ErrorEntity.Unknown)
                        }
                    )
                )
            }
        })
    }

    override fun isExecuted(): Boolean {
        return delegate.isExecuted
    }

    override fun cancel() {
        return delegate.cancel()
    }

    override fun isCanceled(): Boolean {
        return delegate.isCanceled
    }

    override fun request(): Request {
        return delegate.request()
    }

    override fun timeout(): Timeout {
        return delegate.timeout()
    }
}

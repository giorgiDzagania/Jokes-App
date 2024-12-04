package com.example.jokes.core

import retrofit2.Response

object NetworkCallHelper {

    suspend fun <SuccessType> safeApiCall(
        apiCall: suspend () -> Response<SuccessType>
    ): OperationStatus<SuccessType> {
        return try {
            val response = apiCall.invoke()
            OperationStatus.Success(response.body()!!)
        } catch (e: Exception) {
            OperationStatus.Failure(e)
        }
    }

    suspend fun <SuccessType> safeRoomCall(
        dbCall: suspend () -> SuccessType
    ): OperationStatus<SuccessType> {
        return try {
            val result = dbCall.invoke()
            OperationStatus.Success(result)
        } catch (e: Exception) {
            OperationStatus.Failure(e)
        }
    }

}
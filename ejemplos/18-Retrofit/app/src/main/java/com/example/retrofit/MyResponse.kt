package com.example.retrofit

/*
   A wrapper for retrofit request, It is a common practice to segregate the calls.
   This way the viewModel it is not binded to Retrofit
 */
class MyResponse<T>(val result: T?, val errorCode: Int?) {
    val isSuccess: Boolean
        get() = errorCode == null

}
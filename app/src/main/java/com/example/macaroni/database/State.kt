package com.example.macaroni.database

sealed class State<T> (val data: T? = null) {
    class Loading<T> : State<T>()
    class Success<T>(data: T?): State<T>(data)
    class Empty<T>: State<T>()
}

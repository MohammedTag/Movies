package com.task.remote.di.errors

sealed class BackendError : IllegalArgumentException() {
    class Error(val status: Int, override val message: String) : BackendError()
    class NoUserExist :BackendError()
}
package com.task.remote.di.services

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ResponseListWrapper<T>(val data: List<T>)

@JsonClass(generateAdapter = true)
class ResponseWrapper<T>(val data: T)
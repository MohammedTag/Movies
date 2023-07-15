package com.task.remote.di.services

object EndPoints {

    private const val apiVersion = "api/v2"
    const val LocalESimsEndpoint = "${apiVersion}/countries?type=popular"
    const val CountryPackagesEndpoint = "${apiVersion}/countries/{id}"
}
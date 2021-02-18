package com.ns.consumer

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.getForObject

@Service
class StatusService(private val restTemplate: RestTemplateBuilder) {

    @Value("\${producer.url}")
    lateinit var url: String

    fun getStatus(): String {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON


        val userStatus = restTemplate.defaultHeader("Content-Type", "application/json").build()
            .getForObject<UserStatus>("$url/status")
        return userStatus.status
    }
    fun getPactStatus(): String {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON


        val userStatus = restTemplate.defaultHeader("Content-Type", "application/json").build()
            .getForObject<UserStatus>("$url/pactstatus")
        return userStatus.status
    }
}

data class UserStatus(val id: Int, val status: String)
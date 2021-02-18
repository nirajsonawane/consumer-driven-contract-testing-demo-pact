package com.ns.producer

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserStatusController(private val userStatusService: UserStatusService) {


    @GetMapping("/status")
    fun getStatus(): ResponseEntity<UserStatus> {
        return ResponseEntity.ok(userStatusService.getUserStatus(1))
    }

}

data class UserStatus(val id: Int, val status: String)
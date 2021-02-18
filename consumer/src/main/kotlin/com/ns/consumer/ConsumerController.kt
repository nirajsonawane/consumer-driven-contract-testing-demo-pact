package com.ns.consumer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ConsumerController(private val statusService: StatusService) {


    @GetMapping("/test")
    fun test(): String {
        return statusService.getStatus()
    }

    @GetMapping("/pacttest")
    fun pacttest(): String {
        return statusService.getStatus()
    }


}
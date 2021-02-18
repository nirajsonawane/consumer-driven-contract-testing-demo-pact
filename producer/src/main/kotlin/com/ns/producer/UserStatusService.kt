package com.ns.producer

import org.springframework.stereotype.Service

@Service
class UserStatusService {

    fun getUserStatus(userId:Int):UserStatus{
        return UserStatus(1,"ACTIVATED")
    }
}
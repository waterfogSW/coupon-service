package com.exapmle.ulid

import com.github.f4b6a3.ulid.UlidCreator
import java.util.*

object UlidUtil {

    fun createUlid(): UUID {
        return UlidCreator.getMonotonicUlid().toUuid()
    }
    
}

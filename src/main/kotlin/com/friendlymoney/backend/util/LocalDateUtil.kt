package com.friendlymoney.backend.util

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

class LocalDateUtil {
    companion object {
        fun longToDate(long: Long): LocalDate {
            return LocalDate.ofInstant(Instant.ofEpochMilli(long), ZoneId.systemDefault())
        }
    }
}
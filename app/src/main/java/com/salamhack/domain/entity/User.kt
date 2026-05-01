package com.salamhack.domain.entity

data class UserEntity(
    val name: String = "",
    val profileImage: String? = null,
    val hasNotification: Boolean = false
)

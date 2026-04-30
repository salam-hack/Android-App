package com.salamhack.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("name") val name: String?,
    @SerializedName("profileImage") val profileImage: String?,
    @SerializedName("hasNotification") val hasNotification: Boolean?
)
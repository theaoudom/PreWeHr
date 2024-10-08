package com.hrd.wehr_project.data.auth

data class OtpState(
    val otpCode : List<String> = List(6){ "" }
)
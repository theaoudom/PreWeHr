package com.hrd.wehr_project.ui.screen.auth

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hrd.wehr_project.data.auth.OtpState

class OtpViewModel : ViewModel(){
    // State for OTP
    private val _otpState = mutableStateOf(OtpState())
    val otpState: State<OtpState> = _otpState

    fun updateOtpCode( index: Int , value: String){
        if( value.length <= 1){
            //  Create a new list with the updated value at the specify index
            val updateOTpCode = _otpState.value.otpCode.toMutableList().apply {
                this[index] = value
            }
            //  Update State with new OTP code
            _otpState.value = OtpState(otpCode = updateOTpCode)
        }
    }
}
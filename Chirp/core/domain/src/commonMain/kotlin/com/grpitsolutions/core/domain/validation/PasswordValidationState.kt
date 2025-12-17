package com.grpitsolutions.core.domain.validation

data class PasswordValidationState(
    val hasMinLength: Boolean = false,
    val hasDigit: Boolean = false,
    val hasUppcercase: Boolean = false
){
    val isValidPassword: Boolean
        get() = hasMinLength && hasDigit && hasUppcercase
}
package com.grpitsolutions.auth.presentation.register_success

sealed interface RegisterSuccessAction {
    data object onLoginClick: RegisterSuccessAction
    data object onResendVerificationEmailClick: RegisterSuccessAction

}
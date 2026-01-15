package com.grpitsolutions.auth.presentation.email_verification

sealed interface EmailVerificationAction {
    data object onLoginClick : EmailVerificationAction
    data object onCloseClick : EmailVerificationAction
}
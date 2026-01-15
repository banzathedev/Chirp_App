package com.grpitsolutions.auth.presentation.reset_password

import androidx.compose.foundation.text.input.TextFieldState
import com.grpitsolutions.core.presentation.util.UiText

data class ResetPasswordState(
    val passwordTextState: TextFieldState = TextFieldState(),
    val errorText: UiText? = null,
    val isPasswordVisible: Boolean = false,
    val isResetSuccessFull: Boolean = false,
    val canSubmit: Boolean = false,
    val isLoading: Boolean = false,
)
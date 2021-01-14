package com.amaringo.presentation.model


sealed class ScreenFlowState {
    object NavigateToMainScreen : ScreenFlowState()
}
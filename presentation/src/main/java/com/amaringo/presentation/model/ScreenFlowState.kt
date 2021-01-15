package com.amaringo.presentation.model

import com.amaringo.presentation.feature.center_list.model.Center
import com.amaringo.presentation.feature.center_list.model.CenterCategory


sealed class ScreenFlowState {
    object NavigateToMainScreen : ScreenFlowState()
    class NavigateToCenterCategoryDetail(val data: CenterCategory) : ScreenFlowState()
    class NavigateToCenterDetail(val data: Center) : ScreenFlowState()
}
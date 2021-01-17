package com.amaringo.presentation.model

import com.amaringo.presentation.common.Action


data class Error(val message: String, val fallback: Action? = null)
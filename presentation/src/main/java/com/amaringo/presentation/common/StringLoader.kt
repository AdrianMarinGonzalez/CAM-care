package com.amaringo.presentation.common

import android.content.Context
import androidx.annotation.StringRes


class StringLoader(val context: Context) {

    fun load(@StringRes resource: Int): String {
        return context.getString(resource)
    }

}
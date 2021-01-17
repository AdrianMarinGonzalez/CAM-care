package com.amaringo.presentation.feature.center_list.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Center(val url: String, val title: String, @DrawableRes val icon: Int, val location: Location): Parcelable
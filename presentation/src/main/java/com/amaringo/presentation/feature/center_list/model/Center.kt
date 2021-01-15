package com.amaringo.presentation.feature.center_list.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Center(val url: String, val title: String, val location: Location): Parcelable
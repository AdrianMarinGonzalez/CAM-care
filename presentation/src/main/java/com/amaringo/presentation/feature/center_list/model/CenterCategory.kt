package com.amaringo.presentation.feature.center_list.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CenterCategory(
    val id: String,
    val title: String,
    val centers: List<Center>
) : Parcelable

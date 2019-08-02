package com.surya.footballclub.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItem(
        val image: Int?,
        val name: String?,
        val description: String?): Parcelable
package com.module.appcheckup

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConsumerData(val name: String, val yob: String) : Parcelable
package com.example.amdprocesor.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Model(
    var name: String,
    var specs: String,
    var description: String,
    var photo: String
) : Parcelable
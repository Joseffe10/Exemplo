package com.joseffe.exemplo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Usuario(val id: Int, val nome: String) : Parcelable

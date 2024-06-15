package br.com.fiap.easyinbox

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Email(
    val sender: String,
    val category: String,
    val messagePreview: String,
    val time: String,
    val isRead: Boolean,
    val emailAddress: String = "",
    val date: String = "",
    val body: String = "",
    val eventDate: String = ""
) : Parcelable


package br.com.fiap.easyinbox.model

import java.time.LocalDateTime

data class Email(
    val id: String?,
    val sender: String,
    val receiver: String,
    val subject: String,
    val body: String,
    val dateTime: LocalDateTime,
    val category: String,
    val important: Boolean
)

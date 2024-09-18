package br.com.fiap.easyinbox.model

data class Preference(
    val id: String?,
    val userId: String,
    val theme: String,
    val color: String,
    val category: String
)

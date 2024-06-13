package br.com.fiap.easyinbox

data class Email(
    val sender: String,
    val category: String,
    val messagePreview: String,
    val time: String,
    val isBookmarked: Boolean
)
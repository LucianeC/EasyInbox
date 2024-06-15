package br.com.fiap.easyinbox


import android.os.Bundle
import android.os.Build
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class EmailDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_detail)

        // Usando getParcelableExtra de maneira compatível com diferentes versões da API
        val email = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("EMAIL", Email::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("EMAIL")
        }

        if (email != null) {
            Log.d("EmailDetailActivity", "Email recebido: $email")
            val senderTextView = findViewById<TextView>(R.id.emailSenderDetailTextView)
            val detailTextView = findViewById<TextView>(R.id.emailDetailTextView)
            val categoryTextView = findViewById<TextView>(R.id.emailCategoryDetailTextView)
            val dateTextView = findViewById<TextView>(R.id.emailDateDetailTextView)
            val bodyTextView = findViewById<TextView>(R.id.emailBodyTextView)
            val eventDateTextView = findViewById<TextView>(R.id.emailEventDateTextView)

            senderTextView.text = email.sender
            detailTextView.text = email.emailAddress
            categoryTextView.text = "Categoria: ${email.category}"
            dateTextView.text = email.date
            bodyTextView.text = email.body
            eventDateTextView.text = "Data do evento: ${email.eventDate}"
        } else {
            Log.e("EmailDetailActivity", "Email não encontrado")
        }
    }
}

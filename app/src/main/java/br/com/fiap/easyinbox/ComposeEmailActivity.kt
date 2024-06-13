//package br.com.fiap.easyinbox
//
//import android.os.Bundle
//import android.widget.ArrayAdapter
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Spinner
//import androidx.appcompat.app.AppCompatActivity
//
//class ComposeEmailActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_compose_email)
//
//        val toEditText = findViewById<EditText>(R.id.toEditText)
//        val categorySpinner = findViewById<Spinner>(R.id.categorySpinner)
//        val emailContentEditText = findViewById<EditText>(R.id.emailContentEditText)
//        val eventDateEditText = findViewById<EditText>(R.id.eventDateEditText)
//        val sendButton = findViewById<Button>(R.id.sendButton)
//
//        val categories = arrayOf("Importantes", "Pessoal", "Redes sociais", "Estudos", "Empresarial", "Finanças")
//        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        categorySpinner.adapter = adapter
//
//        sendButton.setOnClickListener {
//            val to = toEditText.text.toString()
//            val category = categorySpinner.selectedItem.toString()
//            val content = emailContentEditText.text.toString()
//            val eventDate = eventDateEditText.text.toString()
//
//            // Lógica para enviar o email
//            // Aqui você pode adicionar a lógica para enviar o email
//
//            // Voltar para a tela de Inbox após enviar o email
//            finish()
//        }
//    }
//}
//

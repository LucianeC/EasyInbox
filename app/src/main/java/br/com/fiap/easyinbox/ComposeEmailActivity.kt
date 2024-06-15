package br.com.fiap.easyinbox
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ComposeEmailActivity : AppCompatActivity() {

    private lateinit var eventDateEditText: EditText
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compose_email)

        val toEditText = findViewById<EditText>(R.id.toEditText)
        val categorySpinner = findViewById<Spinner>(R.id.categorySpinner)
        val emailContentEditText = findViewById<EditText>(R.id.emailContentEditText)
        eventDateEditText = findViewById(R.id.eventDateEditText)
        val sendButton = findViewById<ImageView>(R.id.sendButton)

        val categories = arrayOf("Importantes", "Pessoal", "Redes sociais", "Estudos", "Empresarial", "Finanças")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = adapter

        eventDateEditText.setOnClickListener {
            showDatePickerDialog()
        }

        sendButton.setOnClickListener {
            val to = toEditText.text.toString()
            val category = categorySpinner.selectedItem.toString()
            val content = emailContentEditText.text.toString()
            val eventDate = eventDateEditText.text.toString()

            if (eventDate.isNotEmpty()) {
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
                val date = dateFormat.parse(eventDate)
                date?.let {
                    val startTime = it.time
                    val endTime = startTime + 60 * 60 * 1000 // 1 hora de duração

                    CalendarUtils.addEventToCalendar(
                        this,
                        "Novo Evento",
                        content,
                        "Localização",
                        startTime,
                        endTime
                    )
                }
            }
        }
    }

    private fun showDatePickerDialog() {
        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateInView()
        }

        DatePickerDialog(
            this,
            dateSetListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun updateDateInView() {
        val format = "dd/mm/yyyy"
        val sdf = SimpleDateFormat(format, Locale.US)
        eventDateEditText.setText(sdf.format(calendar.time))
    }
}



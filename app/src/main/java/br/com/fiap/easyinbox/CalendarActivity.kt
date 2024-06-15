package br.com.fiap.easyinbox

import android.os.Bundle
import android.widget.TextView
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CalendarActivity : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var selectedDateTextView: TextView
    private lateinit var eventsRecyclerView: RecyclerView
    private lateinit var eventsAdapter: EventsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        calendarView = findViewById(R.id.calendarView)
        selectedDateTextView = findViewById(R.id.selectedDateTextView)
        eventsRecyclerView = findViewById(R.id.eventsRecyclerView)

        eventsRecyclerView.layoutManager = LinearLayoutManager(this)
        eventsAdapter = EventsAdapter(getEventsForDate(calendarView.date))
        eventsRecyclerView.adapter = eventsAdapter

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${month + 1}/$year"
            selectedDateTextView.text = selectedDate
            updateEventsList(selectedDate)
        }
    }

    private fun updateEventsList(selectedDate: String) {
        // Atualize a lista de eventos com base na data selecionada
        eventsAdapter.updateEvents(getEventsForDate(selectedDate))
    }

    private fun getEventsForDate(date: Long): List<Event> {
        // Esta função deve retornar a lista de eventos para a data fornecida.
        // Aqui vamos usar dados fictícios para exemplo.
        return listOf(
            Event("FIAP", "28 Maio 2024")
        )
    }

    private fun getEventsForDate(date: String): List<Event> {
        // Esta função deve retornar a lista de eventos para a data fornecida.
        // Aqui vamos usar dados fictícios para exemplo.
        return listOf(
            Event("FIAP", date)
        )
    }
}

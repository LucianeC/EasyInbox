package br.com.fiap.easyinbox

import android.content.ContentValues
import android.content.Context
import android.provider.CalendarContract
import android.widget.Toast
import java.util.TimeZone

object CalendarUtils {

    fun addEventToCalendar(context: Context, title: String, description: String, location: String, startTime: Long, endTime: Long): Long {
        val cr = context.contentResolver
        val values = ContentValues().apply {
            put(CalendarContract.Events.DTSTART, startTime)
            put(CalendarContract.Events.DTEND, endTime)
            put(CalendarContract.Events.TITLE, title)
            put(CalendarContract.Events.DESCRIPTION, description)
            put(CalendarContract.Events.CALENDAR_ID, 1) // Certifique-se de que este calendário existe
            put(CalendarContract.Events.EVENT_TIMEZONE, TimeZone.getDefault().id)
            put(CalendarContract.Events.EVENT_LOCATION, location)
        }

        val uri = cr.insert(CalendarContract.Events.CONTENT_URI, values)
        val eventID = uri?.lastPathSegment?.toLong()
        if (eventID != null) {
            Toast.makeText(context, "Evento adicionado ao calendário com sucesso!", Toast.LENGTH_SHORT).show()
            return eventID
        } else {
            Toast.makeText(context, "Erro ao adicionar evento ao calendário", Toast.LENGTH_SHORT).show()
            return -1
        }
    }
}
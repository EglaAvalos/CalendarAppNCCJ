package mx.gibsicely.appcalendar

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import android.widget.PopupMenu
import android.widget.Toast


class CalendarActivity : AppCompatActivity() {

    private lateinit var daysOfWeekGrid: GridLayout
    private lateinit var calendarGrid: GridLayout
    private lateinit var monthYearText: TextView
    private lateinit var menuButton: ImageButton

    private val calendar: Calendar = Calendar.getInstance()

    private lateinit var eventoRepo: EventoRepository
    private lateinit var eventos: List<Evento>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eventoRepo = EventoRepository(applicationContext)
        eventos = eventoRepo.obtenerEventos() ?: emptyList()


        daysOfWeekGrid = findViewById(R.id.days_of_week)
        calendarGrid = findViewById(R.id.calendar_grid)
        monthYearText = findViewById(R.id.month_year)
        menuButton = findViewById(R.id.btn_menu)

        // Dibujar encabezado (una sola vez)
        drawDaysOfWeek()

        // Mostrar mes y año actual
        updateMonthYear()

        // Dibujar días del mes
        drawCalendar()

        menuButton.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }

    private fun updateMonthYear() {
        val currentMonth = calendar.get(Calendar.MONTH) + 1
        val currentYear = calendar.get(Calendar.YEAR)
        monthYearText.text = "${getMonthName(currentMonth)} $currentYear"
    }

    private fun drawDaysOfWeek() {
        daysOfWeekGrid.removeAllViews()
        val screenWidth = resources.displayMetrics.widthPixels
        val cellSize = screenWidth / 7
        val daysOfWeek = listOf("Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom")

        for ((i, day) in daysOfWeek.withIndex()) {
            val textView = TextView(this).apply {
                text = day
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
                setTextColor(Color.BLACK)
                setBackgroundColor(Color.LTGRAY)
                gravity = android.view.Gravity.CENTER
            }
            val params = GridLayout.LayoutParams().apply {
                width = cellSize
                height = cellSize
                rowSpec = GridLayout.spec(0)
                columnSpec = GridLayout.spec(i)
                setMargins(2, 2, 2, 2)
            }
            daysOfWeekGrid.addView(textView, params)
        }
    }

    private fun drawCalendar() {
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        val firstDayOfMonth = if (dayOfWeek == Calendar.SUNDAY) 6 else dayOfWeek - 2
        val numberOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        calendarGrid.removeAllViews()
        calendarGrid.columnCount = 7

        val screenWidth = resources.displayMetrics.widthPixels
        val cellSize = screenWidth / 7

        for (i in 0 until 42) {
            val dayButton = Button(this).apply {
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
                setBackgroundColor(Color.WHITE)
                setTextColor(Color.BLACK)
            }

            val row = (i + firstDayOfMonth) / 7
            val col = (i + firstDayOfMonth) % 7

            if (i >= firstDayOfMonth && i < firstDayOfMonth + numberOfDaysInMonth) {
                val dayOfMonth = i - firstDayOfMonth + 1
                val dayString = String.format("%04d-%02d-%02d", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, dayOfMonth)

                val eventosDelDia = eventos.filter { it.fecha == dayString }

                if (eventosDelDia.isNotEmpty()) {
                    dayButton.setBackgroundColor(Color.parseColor("#90EE90"))
                }

                dayButton.text = dayOfMonth.toString()

                // 👉 Aquí agregamos el listener
                dayButton.setOnClickListener { view ->
                    if (eventosDelDia.isNotEmpty()) {
                        val popupMenu = PopupMenu(this, view)
                        eventosDelDia.forEachIndexed { index, evento ->
                            popupMenu.menu.add(0, index, 0, evento.titulo)
                        }
                        popupMenu.setOnMenuItemClickListener { item ->
                            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
                            true
                        }
                        popupMenu.show()
                    } else {
                        Toast.makeText(this, "Sin eventos", Toast.LENGTH_SHORT).show()
                    }
                }

            } else {
                dayButton.text = ""
                dayButton.isEnabled = false
                dayButton.setBackgroundColor(Color.TRANSPARENT)
            }

            val params = GridLayout.LayoutParams().apply {
                width = cellSize
                height = cellSize
                rowSpec = GridLayout.spec(row)
                columnSpec = GridLayout.spec(col)
                setMargins(2, 2, 2, 2)
            }
            calendarGrid.addView(dayButton, params)
        }

    }

    private fun getMonthName(month: Int): String {
        return when (month) {
            1 -> "Enero"
            2 -> "Febrero"
            3 -> "Marzo"
            4 -> "Abril"
            5 -> "Mayo"
            6 -> "Junio"
            7 -> "Julio"
            8 -> "Agosto"
            9 -> "Septiembre"
            10 -> "Octubre"
            11 -> "Noviembre"
            12 -> "Diciembre"
            else -> ""
        }
    }
}

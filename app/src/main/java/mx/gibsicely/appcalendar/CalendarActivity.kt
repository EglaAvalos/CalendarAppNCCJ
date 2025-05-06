package mx.gibsicely.appcalendar

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class CalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarGrid = findViewById<GridLayout>(R.id.calendar_grid)
        val monthYearText = findViewById<TextView>(R.id.month_year)
        val menuButton = findViewById<ImageButton>(R.id.btn_menu)

        val calendar = Calendar.getInstance()
        val currentMonth = calendar.get(Calendar.MONTH) + 1
        val currentYear = calendar.get(Calendar.YEAR)

        monthYearText.text = "${getMonthName(currentMonth)} $currentYear"

        calendar.set(Calendar.DAY_OF_MONTH, 1)
        val firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK) - 1
        val numberOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        calendarGrid.removeAllViews()

        val screenWidth = resources.displayMetrics.widthPixels
        val cellSize = screenWidth / 7

        for (i in 0 until 42) {
            val dayButton = Button(this).apply {
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
                setBackgroundColor(Color.parseColor("#EEEEEE")) // Color visible para depuración
            }

            if (i >= firstDayOfMonth && i < firstDayOfMonth + numberOfDaysInMonth) {
                val dayOfMonth = i - firstDayOfMonth + 1
                dayButton.text = dayOfMonth.toString()
                dayButton.setOnClickListener {
                    // Aquí puedes manejar el clic de cada día
                }
            } else {
                dayButton.text = ""
                dayButton.isEnabled = false
            }

            val params = GridLayout.LayoutParams().apply {
                width = cellSize
                height = cellSize
                rowSpec = GridLayout.spec(i / 7)
                columnSpec = GridLayout.spec(i % 7)
                setMargins(4, 4, 4, 4)
            }

            calendarGrid.addView(dayButton, params)
        }

        menuButton.setOnClickListener {
            // Puedes abrir otra actividad aquí
            // startActivity(Intent(this, MenuActivity::class.java))
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

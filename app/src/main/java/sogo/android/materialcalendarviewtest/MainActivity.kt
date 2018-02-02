package sogo.android.materialcalendarviewtest

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.util.Log
import com.prolificinteractive.materialcalendarview.*
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters
import java.util.Calendar.*


class MainActivity : AppCompatActivity(), OnDateSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var calendarView = findViewById<MaterialCalendarView>(R.id.calendarView)
        calendarView.state().edit()
                .setFirstDayOfWeek(SATURDAY)
                .commit()

        calendarView.selectionMode = 3 //= range  1 = single


        val clear = findViewById<Button>(R.id.clearButton)

        clear.setOnClickListener() {
            calendarView.clearSelection()
        }

        calendarView.setOnDateChangedListener(this)


    }


    override fun onDateSelected(widget: MaterialCalendarView, @Nullable date: CalendarDay, selected: Boolean) {

        val selectedDate = date.calendar

        val startDate: Calendar = getInstance(TimeZone.getDefault())
        val endDate: Calendar = getInstance(TimeZone.getDefault())

        val selectedDayOfWeek = selectedDate.get(Calendar.DAY_OF_WEEK)  // Returns 3, for Tuesday etc.

        when (selectedDayOfWeek) {
            SUNDAY -> {
                startDate.time = date.date
                endDate.time = date.date

                startDate.add(DATE, -1)
                endDate.add(DATE, 5)

                val startCalDay = CalendarDay.from(startDate)
                val endCalDay = CalendarDay.from(endDate)

                calendarView.selectRange(startCalDay, endCalDay)
            }
            MONDAY -> {
                startDate.time = date.date
                endDate.time = date.date

                startDate.add(DATE, -2)
                endDate.add(DATE, 4)

                val startCalDay = CalendarDay.from(startDate)
                val endCalDay = CalendarDay.from(endDate)

                calendarView.selectRange(startCalDay, endCalDay)
            }
            TUESDAY -> {
                startDate.time = date.date
                endDate.time = date.date

                startDate.add(DATE, -3)
                endDate.add(DATE, 3)

                val startCalDay = CalendarDay.from(startDate)
                val endCalDay = CalendarDay.from(endDate)

                calendarView.selectRange(startCalDay, endCalDay)
            }
            WEDNESDAY -> {

                startDate.time = date.date
                endDate.time = date.date

                startDate.add(DATE, -4)
                endDate.add(DATE, 2)

                val startCalDay = CalendarDay.from(startDate)
                val endCalDay = CalendarDay.from(endDate)

                calendarView.selectRange(startCalDay, endCalDay)

            }
            THURSDAY -> {

                startDate.time = date.date
                endDate.time = date.date

                startDate.add(DATE, -5)
                endDate.add(DATE, 1)

                val startCalDay = CalendarDay.from(startDate)
                val endCalDay = CalendarDay.from(endDate)

                calendarView.selectRange(startCalDay, endCalDay)

            }
            FRIDAY -> {

                startDate.time = date.date
                endDate.time = date.date

                startDate.add(DATE, -6)
                endDate.add(DATE, 0)

                val startCalDay = CalendarDay.from(startDate)
                val endCalDay = CalendarDay.from(endDate)

                calendarView.selectRange(startCalDay, endCalDay)

            }
            SATURDAY -> {

                startDate.time = date.date
                endDate.time = date.date

                startDate.add(DATE, 0)
                endDate.add(DATE, 6)

                val startCalDay = CalendarDay.from(startDate)
                val endCalDay = CalendarDay.from(endDate)

                calendarView.selectRange(startCalDay, endCalDay)

            }

        }
    }
}

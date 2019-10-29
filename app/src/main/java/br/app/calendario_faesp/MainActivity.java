package br.app.calendario_faesp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final String MOTIVO_EVENTO = " Dia do Professor";
    final int DIA_EVENTO = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView calendarView = findViewById(R.id.calendarioView);
        List<EventDay> eventos = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, DIA_EVENTO);
        eventos.add(new EventDay(cal, R.drawable.ic_dot));

        calendarView.setEvents(eventos);

        calendarView.setOnDayClickListener(EventDay -> Toast.makeText(this, "Evento do dia: " + MOTIVO_EVENTO, Toast.LENGTH_SHORT).show());

    }

}

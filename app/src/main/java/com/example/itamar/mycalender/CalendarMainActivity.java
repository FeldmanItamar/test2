package com.example.itamar.mycalender;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;

public class CalendarMainActivity extends AppCompatActivity implements OnDateSetListener {

    private Button btDate;
    private TextView tvDate;
    private DatePickerDialog datePicker;
    private Calendar calendar;
    private int day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_main);

        btDate = (Button) findViewById(R.id.btDate);
        tvDate = (TextView) findViewById(R.id.tvDate);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker = new DatePickerDialog(
                this,
                myDateListener, // listener for the date
                year,
                month,
                day);

    }

    public void onClick(View v) {

        if (v == btDate) {
            datePicker.show();
            //showDate(year, month, day);
        }

    }

    private OnDateSetListener myDateListener = new OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {

            showDate(arg1, arg2 + 1, arg3);
            datePicker.hide();
        }
    };

    @Override
    public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {

        showDate(arg1, arg2+1, arg3);
    }

    public void showDate(int year, int monthOfYear, int dayOfMonth) {

        tvDate.setText("Date is: " + dayOfMonth + " " + monthOfYear + " " + year);

    }


}

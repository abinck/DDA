package edu.dda;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import edu.dda.nw.DDAClient;

public class ScheduleActivity extends AppCompatActivity {
    Button dateBT, timeBT;
    EditText dateET, fromTimeET, toTimeET;
    ;
    private int year, month, day, hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        dateET = (EditText) findViewById(R.id.date);
        fromTimeET = (EditText) findViewById(R.id.fromTime);
        toTimeET = (EditText) findViewById(R.id.toTime);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            boolean result = DDAClient.empLogout();
            if (result) {
                Intent intent = new Intent(ScheduleActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        } else if (id == R.id.action_exit) {
            boolean result = DDAClient.empLogout();
            if (result) {
                System.exit(0);
            }

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ScheduleActivity.this, DesktopCaptureActivity.class);
        startActivity(intent);
        finish();
    }

    public void getDate(View view) {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        dateET.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    public void getFromTime(View view) {

        // Get Current Time
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        fromTimeET.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }

    public void getToTime(View view) {
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        toTimeET.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }

    public void reset(View view) {
        clear();
    }

    public void scheduleNow(View view) {
        try {
            String date = dateET.getText().toString();
            String fromTime = fromTimeET.getText().toString();
            String toTime = toTimeET.getText().toString();
            if ("".equals(date)) {
                dateET.setError("Choose Date");
            } else if ("".equals(fromTime)) {
                fromTimeET.setError("Choose From Time");
            } else if ("".equals(fromTime)) {
                toTimeET.setError("Choose To Time");
            } else {
                boolean result = DDAClient.scheduleNow(date, fromTime, toTime);
                if (result) {
                    clear();
                    Toast.makeText(ScheduleActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ScheduleActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        dateET.setText(null);
        fromTimeET.setText(null);
        toTimeET.setText(null);
    }
}

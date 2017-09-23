package edu.dda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import edu.dda.nw.DDAClient;
import edu.dda.uiprocess.Requesting;
import edu.dda.utils.Variables;

public class DesktopCaptureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop_capture);
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
                Intent intent = new Intent(DesktopCaptureActivity.this, LoginActivity.class);
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
        Intent intent = new Intent(DesktopCaptureActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void requestCapture(View view) {
        new Requesting(DesktopCaptureActivity.this).execute();


    }

    public void scheduleNow(View view) {
        Intent intent = new Intent(DesktopCaptureActivity.this, ScheduleActivity.class);
        startActivity(intent);
        finish();
    }
}

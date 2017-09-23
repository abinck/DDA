package edu.dda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import edu.dda.nw.DDAClient;

public class HomeActivity extends AppCompatActivity {
    Button chatBT, fileBT, notiBT, captureBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        chatBT = (Button) findViewById(R.id.chat);
        fileBT = (Button) findViewById(R.id.file);
        notiBT = (Button) findViewById(R.id.noti);
        captureBT = (Button) findViewById(R.id.capture);
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
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        } else if (id == R.id.action_exit) {
            boolean result = DDAClient.empLogout();
            if (result) {
               finish();
            }

        }

        return super.onOptionsItemSelected(item);
    }

    public void notification(View view) {
        Intent intent = new Intent(HomeActivity.this, NotificationActivity.class);
        startActivity(intent);
        finish();
    }

    public void file(View view) {
        Intent intent = new Intent(HomeActivity.this, FileStoreActivity.class);
        startActivity(intent);
        finish();
    }

    public void chat(View view) {
        Intent intent = new Intent(HomeActivity.this, ChatActivity.class);
        startActivity(intent);
        finish();
    }

    public void desktopCapture(View view) {
        Intent intent = new Intent(HomeActivity.this, DesktopCaptureActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        boolean result = DDAClient.empLogout();
        if (result) {
            finish();
        }
    }
}

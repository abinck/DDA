package edu.dda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import edu.dda.adapters.NotificationListAdapter;
import edu.dda.models.NotificationModel;
import edu.dda.nw.DDAClient;

public class NotificationActivity extends AppCompatActivity {
    ListView notiListLV;
    private ArrayList<NotificationModel> notificationModels = null;
    NotificationListAdapter notificationListAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        notiListLV = (ListView) findViewById(R.id.notiList);
        notificationModels = DDAClient.getAllNotifications();
        notificationListAdapter = new NotificationListAdapter(this, notificationModels);
        notiListLV.setAdapter(notificationListAdapter);
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
                Intent intent = new Intent(NotificationActivity.this, LoginActivity.class);
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
        Intent intent = new Intent(NotificationActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}

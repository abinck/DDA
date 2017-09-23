package edu.dda;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

import edu.dda.adapters.FileListAdapter;
import edu.dda.models.FileStoreModel;
import edu.dda.nw.DDAClient;
import edu.dda.uiprocess.FileDownload;

public class FileStoreActivity extends AppCompatActivity {
    ListView fileListLV;
    private ArrayList<FileStoreModel> fileStoreModels = null;
    FileListAdapter fileListAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_store);
        fileListLV = (ListView) findViewById(R.id.fileList);
        fileStoreModels = DDAClient.getAllFilesByDept();
        fileListAdapter = new FileListAdapter(this, fileStoreModels);
        fileListLV.setAdapter(fileListAdapter);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        fileListLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int fileId = fileStoreModels.get(position).getId();

                builder.setTitle("ACTION");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Choose An Action");
                builder.setPositiveButton("DOWNLOAD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String savePath = Environment.getExternalStorageDirectory().getPath() + File.separator;
                        new FileDownload(FileStoreActivity.this, fileId, savePath).execute();

                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();

            }
        });
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
                Intent intent = new Intent(FileStoreActivity.this, LoginActivity.class);
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
        Intent intent = new Intent(FileStoreActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }


}

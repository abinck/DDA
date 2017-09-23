package edu.dda.uiprocess;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;

import edu.dda.nw.FileClient;
import edu.dda.utils.Variables;

/**
 * Created by pvr on 8/9/16.
 */
public class FileDownload extends AsyncTask<Void, Void, Void> {
    private Context context = null;
    private int fileId = 0;
    private String savePath = "";
    private ProgressDialog progressDialog;
    boolean result = false;

    public FileDownload(Context context, int fileId, String savePath) {
        this.context = context;
        this.fileId = fileId;
        this.savePath = savePath;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "File Downloading", "Please wait...", false, false);
    }

    @Override
    protected Void doInBackground(Void... params) {

        result = FileClient.downloadFile(Variables.sessionId, fileId, savePath);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
        if (result) {
            Toast.makeText(context, "Downloaded Successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Failed To Download", Toast.LENGTH_SHORT).show();
        }
    }
}

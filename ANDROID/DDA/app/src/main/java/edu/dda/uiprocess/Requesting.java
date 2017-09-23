package edu.dda.uiprocess;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import edu.dda.FullScreenCaptureActivity;
import edu.dda.nw.DDAClient;
import edu.dda.nw.RequestClient;

/**
 * Created by pvr on 29/9/16.
 */
public class Requesting extends AsyncTask<Void, Void, Void> {
    private Context context = null;
    private ProgressDialog progressDialog;
    boolean flag = false;

    public Requesting(Context context) {
        this.context = context;


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Your Request Is Processing", "Please wait...", false, false);
    }

    @Override
    protected Void doInBackground(Void... params) {

        boolean result = DDAClient.checkCaptureSchedule();
        if (result) {

            flag = true;

        } else {
            result = RequestClient.requestCapture();
            if (result) {
                flag = true;

            } else {

            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
        if (flag) {
            Intent intent = new Intent(context, FullScreenCaptureActivity.class);
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "Your Request Is Rejected By Admin!!! Please Contact Admin", Toast.LENGTH_SHORT).show();
        }
    }
}
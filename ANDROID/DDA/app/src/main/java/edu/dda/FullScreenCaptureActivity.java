package edu.dda;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import edu.dda.nw.MouseEventClient;
import edu.dda.nw.ScreenCaptureClient;
import edu.dda.utils.Variables;

public class FullScreenCaptureActivity extends Activity {
    static ImageView captureIV;
    private float initX = 0;
    private float initY = 0;
    private float xDistance = 0;
    private float yDistance = 0;
    private boolean mouseMoved = false;
    MouseEventClient eventClient = null;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_capture);
        captureIV = (ImageView) findViewById(R.id.capturedImage);
        ScreenCaptureClient client = new ScreenCaptureClient();
        eventClient = new MouseEventClient();

        captureIV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initX = event.getX();
                        initY = event.getY();
                        mouseMoved = false;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        xDistance = event.getX() - initX;
                        yDistance = event.getY() - initY;
                        initX = event.getX();
                        initY = event.getY();
                        if (xDistance != 0 || yDistance != 0) {

                            eventClient.moveMouse(xDistance, yDistance);
                        }
                        mouseMoved = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        if (!mouseMoved) {
                            eventClient.leftClickMouse();
                        }
                }
                return true;
            }
        });
    }

    public static Handler screenHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            updateImageView(Variables.capturedImage);


        }
    };

    public static void updateImageView(byte[] data) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPurgeable = true;
            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);
            Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * 2.9), (int) (bitmap.getHeight() * 2.7), true);
            captureIV.setImageBitmap(resizedBitmap);
            bitmap.recycle();
            bitmap = null;
            resizedBitmap = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rightClick(View view) {
        eventClient.rightClickMouse();
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press back again to exit from screen capture...", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}

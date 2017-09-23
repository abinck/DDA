package edu.dda.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.dda.R;
import edu.dda.models.NotificationModel;


/**
 * Created by pvr on 19/5/16.
 */
public class NotificationListAdapter extends ArrayAdapter<NotificationModel> {


    private final Activity context;
    private ArrayList<NotificationModel> notificationModels;


    public NotificationListAdapter(Activity context,
                                   ArrayList<NotificationModel> notificationModels) {
        super(context, R.layout.notification_list_row, notificationModels);
        this.context = context;
        this.notificationModels = notificationModels;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.notification_list_row, null, true);
        TextView msgNameTV = (TextView) rowView.findViewById(R.id.msgName);
        TextView msgTV = (TextView) rowView.findViewById(R.id.msg);
        TextView ntDateTV = (TextView) rowView.findViewById(R.id.ntDate);
        TextView ntTimeTV = (TextView) rowView.findViewById(R.id.ntTime);


        msgNameTV.setText("MESSAGE NAME: " + notificationModels.get(position).getMsgName());
        msgTV.setText("MESSAGE: " + notificationModels.get(position).getMsg());
        ntDateTV.setText("POSTED DATE: " + notificationModels.get(position).getNtDate());
        ntTimeTV.setText("POSTED TIME: " + notificationModels.get(position).getNtTime());

        return rowView;
    }
}

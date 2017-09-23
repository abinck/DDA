package edu.dda.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.dda.R;
import edu.dda.models.ChatHistoryModel;
import edu.dda.utils.Variables;

/**
 * Created by pvr on 22/9/16.
 */
public class ChatHistoryListAdapter extends ArrayAdapter<ChatHistoryModel> {

    private final Activity context;
    private ArrayList<ChatHistoryModel> chatHistoryModels;


    public ChatHistoryListAdapter(Activity context,
                                  ArrayList<ChatHistoryModel> chatHistoryModels) {
        super(context, R.layout.notification_list_row, chatHistoryModels);
        this.context = context;
        this.chatHistoryModels = chatHistoryModels;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.chat_history_list_row, null, true);
        TextView fromTV = (TextView) rowView.findViewById(R.id.from);
        TextView toTV = (TextView) rowView.findViewById(R.id.to);
        TextView msgTV = (TextView) rowView.findViewById(R.id.msg);
        TextView ctDateTV = (TextView) rowView.findViewById(R.id.ctDate);
        TextView ctTimeTV = (TextView) rowView.findViewById(R.id.ctTime);
        if (Variables.sessionId == chatHistoryModels.get(position).getFromId()) {
            fromTV.setText("FROM: " + "Me");
            toTV.setText("TO: " + "Admin");
        } else {
            fromTV.setText("FROM: " + "Admin");
            toTV.setText("TO: " + "Me");
        }
        msgTV.setText("MESSAGE: " + chatHistoryModels.get(position).getMsg());
        ctDateTV.setText("CHAT DATE: " + chatHistoryModels.get(position).getCtDate());
        ctTimeTV.setText("CHAT TIME: " + chatHistoryModels.get(position).getCtTime());

        return rowView;
    }
}

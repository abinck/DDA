package edu.dda.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import edu.dda.R;
import edu.dda.adapters.ChatHistoryListAdapter;
import edu.dda.models.ChatHistoryModel;
import edu.dda.nw.DDAClient;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatHistoryFragment extends Fragment {

    ListView chatHistoryListLV;
    private ArrayList<ChatHistoryModel> chatHistoryModels = null;
    ChatHistoryListAdapter chatHistoryListAdapter = null;

    public ChatHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat_history, container, false);

        chatHistoryListLV = (ListView) view.findViewById(R.id.chatHistoryList);
        chatHistoryModels = DDAClient.getEmpChatHistory();
        chatHistoryListAdapter = new ChatHistoryListAdapter(getActivity(), chatHistoryModels);
        chatHistoryListLV.setAdapter(chatHistoryListAdapter);
        return view;
    }

}

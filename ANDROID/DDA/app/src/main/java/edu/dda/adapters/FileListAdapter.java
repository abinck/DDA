package edu.dda.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.dda.R;
import edu.dda.models.FileStoreModel;

/**
 * Created by pvr on 8/9/16.
 */
public class FileListAdapter extends ArrayAdapter<FileStoreModel> {

    private final Activity context;
    private ArrayList<FileStoreModel> fileStoreModels;


    public FileListAdapter(Activity context,
                           ArrayList<FileStoreModel> fileStoreModels) {
        super(context, R.layout.file_list_row, fileStoreModels);
        this.context = context;
        this.fileStoreModels = fileStoreModels;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.file_list_row, null, true);
        TextView fileNameTV = (TextView) rowView.findViewById(R.id.fileName);
        TextView fileSizeTV = (TextView) rowView.findViewById(R.id.fileSize);
        double fileSize = Double.parseDouble(fileStoreModels.get(position).getFileSize()) / 1000000;
        fileNameTV.setText("FILE NAME: " + fileStoreModels.get(position).getFileName());
        fileSizeTV.setText("FILE SIZE: " + fileSize + " MB");


        return rowView;
    }
}

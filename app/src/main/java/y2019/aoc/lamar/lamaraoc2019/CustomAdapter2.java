package y2019.aoc.lamar.lamaraoc2019;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sarah on 9/20/2017.
 * this page contains the custom galley that extends
 */

public class CustomAdapter2 extends ArrayAdapter<HomeWork> {

    private int resourceLayout;
    private Context mContext;

    public CustomAdapter2(Context context, int resource, List<HomeWork> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    /*
    getView() method. This view is called when a listItem needs to be created and populated with the data.In this method first the View is inflated using the LayoutInflator.inflate() method. It is important that you check that if the view you are trying to inflate is new or reused
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(v == null)
            v = LayoutInflater.from(mContext).inflate(resourceLayout,parent,false);


        HomeWork p = getItem(position);

        if (p != null) {

            TextView textViewSubject=v.findViewById(R.id.textViewSubject);
            textViewSubject.setText(p.getSubject());

            CheckBox checkBoxIsDone=v.findViewById(R.id.checkBoxIsDone);
            checkBoxIsDone.setChecked(p.isDone());
        }

        return v;
    }

}

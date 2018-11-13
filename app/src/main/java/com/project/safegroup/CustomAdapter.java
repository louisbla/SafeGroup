package com.project.safegroup;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.safegroup.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    //String countryList[];
    //int flags[];
    ArrayList<String> countryList;
    ArrayList<Integer> flags;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, ArrayList<String> countryList, ArrayList<Integer> flags) {
        this.context = context;
        this.countryList = countryList;
        this.flags = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }
/*
    public CustomAdapter(Context applicationContext, String[] countryList, int[] flags) {
        this.context = context;
        this.countryList = countryList;
        this.flags = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }*/

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int i) {
        return countryList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final String element = countryList.get(i);
        final int icon = flags.get(i);

        view = inflter.inflate(R.layout.activity_listview, null);
        final TextView textView = (TextView) view.findViewById(R.id.textView);
        //textView.setClickable(true);
        textView.setText(countryList.get(i));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perfom_action(v, element);
            }
        });

        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        imageView.setImageResource(flags.get(i));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perfom_action(v, element);
            }
        });
        return view;
    }

    public void perfom_action(View view, String element){
        //System.out.println("VIEW = " + view.getContext().getApplicationContext().toString());
        //this.context.startActivity(new Intent(view.getContext().getApplicationContext() , GestionGroupActivity.class));
        Toast.makeText(view.getContext(), "Click sur \"" + element + "\"", Toast.LENGTH_SHORT).show();
        countryList.add(1, "test");
        flags.add(1, R.drawable.favorite_icon);
        this.notifyDataSetChanged();
    }
}
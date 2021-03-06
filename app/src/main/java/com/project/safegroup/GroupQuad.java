package com.project.safegroup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.safegroup.MainActivity;
import com.project.safegroup.R;

public class GroupQuad extends Fragment {
    private static final String TAG = "com.louis.safegroup.SafeQuad";
    private Button allButton;
    private Button favoriteButton;
    private Button partyButton;
    private Button preciseButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.group_quad,container,false);
        allButton = (Button) view.findViewById(R.id.all_button);
        favoriteButton = (Button) view.findViewById(R.id.favorite_button);
        partyButton = (Button) view.findViewById(R.id.party_button);
        preciseButton = (Button) view.findViewById(R.id.selectPrecisely_button);


        allButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).sendGeneralNotificationTo(false,false);

            }
        });

        favoriteButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).sendGeneralNotificationTo(true,false);
            }
        });

        partyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).sendGeneralNotificationTo(false,true);
            }
        });

        preciseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setGroup(3);
                ((MainActivity)getActivity()).setFragment(5);
            }
        });
        return view;
    }
}

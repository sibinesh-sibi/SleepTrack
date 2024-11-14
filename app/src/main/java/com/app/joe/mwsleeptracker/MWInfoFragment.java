package com.app.joe.mwsleeptracker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mbientlab.metawear.AsyncOperation;
import com.mbientlab.metawear.MetaWearBoard;

/**
 * MWInfoFragment
 *
 * This fragment is used to display the accelerometer data as it is received
 * from the MetaWear board.
 */

public class MWInfoFragment extends Fragment {

    public  MWInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mwinfo, container, false);
    }

    public void updateDeviceInfo(final float X, final float Y, final float Z){
        //Update textviews with accel data
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView tvAccelX = (TextView) getView().findViewById(R.id.tvInfoAccelX);
                tvAccelX.setText(Float.toString(X));

                TextView tvAccelY = (TextView) getView().findViewById(R.id.tvInfoAccelY);
                tvAccelY.setText(Float.toString(Y));

                TextView tvAccelZ = (TextView) getView().findViewById(R.id.tvInfoAccelZ);
                tvAccelZ.setText(Float.toString(Z));
            }
        });
    }
}

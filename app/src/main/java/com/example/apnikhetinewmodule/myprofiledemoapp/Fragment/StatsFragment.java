package com.example.apnikhetinewmodule.myprofiledemoapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apnikhetinewmodule.myprofiledemoapp.R;

/**
 * Created by gagandeep.k on 11/22/2017.
 */

public class StatsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.stats_fragment_lay, container, false);

        return v;
    }
}

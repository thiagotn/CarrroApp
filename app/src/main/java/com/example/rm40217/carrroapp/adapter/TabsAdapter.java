package com.example.rm40217.carrroapp.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.rm40217.carrroapp.R;
import com.example.rm40217.carrroapp.fragment.FragmentCarros;

/**
 * Created by rm40217 on 19/11/2015.
 */
public class TabsAdapter extends FragmentStatePagerAdapter {

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        FragmentCarros fragment = new FragmentCarros();
        Bundle args = new Bundle();
        switch(position) {
            case 0:
                args.putInt("tipo", R.raw.carros_classicos);
                break;
            case 1:
                args.putInt("tipo", R.raw.carros_esportivos);
                break;
            case 2:
                args.putInt("tipo", R.raw.carros_luxuosos);
                break;
        }
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

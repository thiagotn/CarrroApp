package com.example.rm40217.carrroapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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
        return new FragmentCarros();
    }

    @Override
    public int getCount() {
        return 3;
    }
}

package com.amadeus.feelens.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.amadeus.feelens.tabs.*;

public class MyPagerAdapter extends FragmentPagerAdapter{

    private String[] tabTitles;

    public MyPagerAdapter(FragmentManager fm, String[] tabTitles) {
        super(fm);
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new GridTab();

            case 1:
                return new AlbumTab();

            case 2:
                return new NotificationTab();
        }
        return null;
    }

    @Override
    public int getCount() {
        return this.tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.tabTitles[position];
    }
}

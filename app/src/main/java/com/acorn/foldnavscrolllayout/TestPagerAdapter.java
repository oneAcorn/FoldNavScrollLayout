package com.acorn.foldnavscrolllayout;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TestPagerAdapter extends FragmentStatePagerAdapter {
    private String[] titles=new String[]{"Tab1","Tab2","tab3","Tab4","Tab5","Tab6","Tab7"};

    public TestPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return TestFragment.newInstance();
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}

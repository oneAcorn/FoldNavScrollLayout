package com.acorn.foldnavscrolllayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout = findViewById(R.id.fold_tab_layout);
        vp = findViewById(R.id.fold_content_layout);

        vp.setAdapter(new TestPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(vp);
    }

}

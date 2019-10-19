package com.acorn.foldnavscrolllayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.acorn.library.FoldNavScrollLayout;
import com.acorn.library.IFoldNavListener;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout = findViewById(R.id.fold_tab_layout);
        vp = findViewById(R.id.fold_content_layout);
        FoldNavScrollLayout foldNavScrollLayout=findViewById(R.id.foldNavLayout);
        foldNavScrollLayout.setOnFoldNavListener(new IFoldNavListener() {
            @Override
            public void onNavFoldBegin() {
                Log.i("navfold","onNavFoldBegin");
                Toast.makeText(MainActivity.this,"onNavFoldBegin",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNavFoldFinish() {
                Log.i("navfold","onNavFoldFinish");
                Toast.makeText(MainActivity.this,"onNavFoldFinish",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNavExpandBegin() {
                Log.i("navfold","onNavExpandBegin");
                Toast.makeText(MainActivity.this,"onNavExpandBegin",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNavExpandFinish() {
                Log.i("navfold","onNavExpandFinish");
                Toast.makeText(MainActivity.this,"onNavExpandFinish",Toast.LENGTH_SHORT).show();
            }
        });

        vp.setAdapter(new TestPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(vp);
    }

}

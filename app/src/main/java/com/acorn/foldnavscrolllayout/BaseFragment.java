package com.acorn.foldnavscrolllayout;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Acorn on 2016/12/13.
 */

public abstract class BaseFragment extends Fragment {
    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == rootView) {
            rootView = inflater.inflate(getLayoutId(), container, false);
            findViews();
            setupListener();
        }
        return rootView;
    }

    protected abstract int getLayoutId();

    protected abstract void findViews();

    protected abstract void setupListener();

    protected final View findViewById(@IdRes int id) {
        return rootView.findViewById(id);
    }
}

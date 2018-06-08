package com.quarter_hour.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quarter_hour.R;
import com.quarter_hour.adapter.SecondAdapter;
import com.quarter_hour.base.BaseFragment;
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class An_Episode_02 extends BaseFragment {

    private RecyclerView episode_lv;
    private SecondAdapter secondAdapter;
    @Override
    protected int bindLayout() {
        return R.layout.an_episode_02;
    }

    @Override
    protected void initView() {
        episode_lv = findViewById(R.id.episode_lv);
    }

    @Override
    protected void initData() {
        episode_lv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        episode_lv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        secondAdapter = new SecondAdapter(getActivity());
        episode_lv.setAdapter(secondAdapter);
    }

    @Override
    protected void bindEvent() {

    }
}

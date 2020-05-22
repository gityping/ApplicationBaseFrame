package com.yping.applicationbaseframe.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.yping.applicationbaseframe.R;
import com.yping.applicationbaseframe.adapter.TitleFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryFragment extends Fragment {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private CategoryViewModel categoryViewModel;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"全部", "热门", "推荐", "资讯", "视频", "应用", "音乐", "娱乐"};
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        categoryViewModel =
                ViewModelProviders.of(this).get(CategoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this,root);
        categoryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                iniView(root);
            }
        });
        return root;
    }

    private void iniView(View root) {
        fragments.add(CommonFragment.newInstance("", 0));
        fragments.add(CommonFragment.newInstance("", 1));
        fragments.add(CommonFragment.newInstance("", 2));
        fragments.add(CommonFragment.newInstance("", 3));
        fragments.add(CommonFragment.newInstance("", 4));
        fragments.add(CommonFragment.newInstance("", 5));
        fragments.add(CommonFragment.newInstance("", 6));
        fragments.add(CommonFragment.newInstance("", 7));
        TitleFragmentPagerAdapter adapter = new TitleFragmentPagerAdapter(
                getChildFragmentManager(),
                fragments,
                titles
                );
        viewpager.setAdapter(adapter);
        tab.setupWithViewPager(viewpager);
        viewpager.setOffscreenPageLimit(5);
    }
}

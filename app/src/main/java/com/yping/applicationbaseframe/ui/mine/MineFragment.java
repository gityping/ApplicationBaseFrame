package com.yping.applicationbaseframe.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.yping.applicationbaseframe.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineFragment extends Fragment {

    @BindView(R.id.ll_user_info)
    LinearLayout llUserInfo;
    @BindView(R.id.tv_about)
    TextView tvAbout;
    private MineViewModel mineViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mineViewModel =
                ViewModelProviders.of(this).get(MineViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this,root);
        mineViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                initView();
            }

        });
        return root;
    }

    private void initView() {

    }

    @OnClick({R.id.ll_user_info, R.id.tv_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_user_info:
                startActivity(new Intent(getActivity(),UserInfoActivity.class));
                break;
            case R.id.tv_about:
                break;
        }
    }
}

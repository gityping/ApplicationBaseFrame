package com.yping.applicationbaseframe.ui.category;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.yping.applicationbaseframe.R;
import com.yping.applicationbaseframe.entity.TestEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommonFragment extends Fragment {
    private static String STR = "title";
    private static String FLAG = "flag";
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private View view;
    private int flag;
    private String title;
    private BaseQuickAdapter<TestEntity, BaseViewHolder> adapter;
    private List<TestEntity> list = new ArrayList<>();

    public static CommonFragment newInstance(String str, int flag) {
        Bundle bundle = new Bundle();
        bundle.putString(STR, str);
        bundle.putInt(FLAG, flag);
        CommonFragment fragment = new CommonFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_common, container, false);
        }
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            flag = bundle.getInt(FLAG);
            title = bundle.getString(STR);
        }
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //添加Android自带的分割线
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.custom_divider));
        recycleView.addItemDecoration(divider);
        initData();
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            TestEntity entity = new TestEntity();
            entity.setId(i + 1);
            entity.setName("Marchal" + i);
            entity.setPhone("1351234567" + i);
            list.add(entity);
        }
        setData();
    }

    private void setData() {
        adapter = new BaseQuickAdapter<TestEntity, BaseViewHolder>(R.layout.home_item, list) {
            @Override
            protected void convert(BaseViewHolder helper, TestEntity item) {
                int position = helper.getAdapterPosition();
                helper
                        .setText(R.id.tv_name, item.getName())
                        .setText(R.id.tv_phone, item.getPhone());
            }
        };
        View empty_layout = LayoutInflater.from(getActivity()).inflate(R.layout.empty_layout, null);
        adapter.setEmptyView(empty_layout);
        // 默认提供5种方法（渐显、缩放、从下到上，从左到右、从右到左）
        // adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        // 自定义动画如此轻松
        adapter.openLoadAnimation(new BaseAnimation() {
            @Override
            public Animator[] getAnimators(View view) {
                return new Animator[]{
                        ObjectAnimator.ofFloat(view, "scaleY", 1, 1.1f, 1),
                        ObjectAnimator.ofFloat(view, "scaleX", 1, 1.1f, 1)
                };
            }
        });
        recycleView.setAdapter(adapter);
        loadData();
        refreshData();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), CommonDetailsActivity.class));
            }
        });
    }

    private void refreshData() {
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                for (int i = 20; i < 30; i++) {
                    TestEntity entity = new TestEntity();
                    entity.setId(i + 1);
                    entity.setName("Marchal" + i);
                    entity.setPhone("1351234567" + i);
                    list.add(entity);
                }
                adapter.setNewData(list);
                refreshLayout.setRefreshing(false);
            }
        });
    }

    private void loadData() {
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                recycleView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 10; i < 20; i++) {
                            TestEntity entity = new TestEntity();
                            entity.setId(i + 1);
                            entity.setName("Marchal" + i);
                            entity.setPhone("1351234567" + i);
                            list.add(entity);
                        }
                        adapter.loadMoreComplete();
                        adapter.loadMoreEnd();
                        adapter.setNewData(list);
                    }
                }, 1000);
            }
        }, recycleView);
    }
}

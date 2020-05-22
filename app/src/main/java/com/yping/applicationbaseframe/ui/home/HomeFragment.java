package com.yping.applicationbaseframe.ui.home;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.ImageLoader;
import com.yping.applicationbaseframe.R;
import com.yping.applicationbaseframe.entity.TestEntity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private BaseQuickAdapter<TestEntity, BaseViewHolder> adapter;
    private List<TestEntity> list = new ArrayList<>();
    private View headerView;
    private Banner banner;
    private SwipeRefreshLayout refreshLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                initView(root);
            }
        });
        return root;
    }

    private void initView(View root) {
        recyclerView = root.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //添加Android自带的分割线
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.custom_divider));
        recyclerView.addItemDecoration(divider);
        refreshLayout = root.findViewById(R.id.refresh_layout);
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
        headerView = LayoutInflater.from(getActivity()).inflate(R.layout.header_layout, null);
        banner = headerView.findViewById(R.id.banner);
        initBanner();
        adapter.addHeaderView(headerView);
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
        recyclerView.setAdapter(adapter);
        loadData();
        refreshData();
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
                recyclerView.postDelayed(new Runnable() {
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
        }, recyclerView);
//        adapter.setOnLoadMoreListener(PAGE_SIZE, new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//                if (mCurrentCounter >= TOTAL_COUNTER) {
//                    mRecyclerView.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            mQuickAdapter.isNextLoad(false);
//                        }
//                    });
//                } else {
//                    // reqData
//                    mCurrentCounter = mQuickAdapter.getItemCount();
//                    mQuickAdapter.isNextLoad(true);
//                }
//            }
//        });
    }

    private void initBanner() {
        List<Integer> imgs = new ArrayList<>();
        imgs.add(R.mipmap.banner1);
        imgs.add(R.mipmap.banner2);
        imgs.add(R.mipmap.banner3);
        imgs.add(R.mipmap.banner4);
        imgs.add(R.mipmap.banner5);
        imgs.add(R.mipmap.banner6);
        imgs.add(R.mipmap.banner7);
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(imgs);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
//        banner.setBannerTitles(titles);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
            }
        });
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                //                banner.setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();
    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            Glide.with(context).load(path).into(imageView);
        }
    }
}

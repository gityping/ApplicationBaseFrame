package com.yping.applicationbaseframe;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private BottomNavigationView navView;
    private NavigationView navigationview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置状态栏透明
//        setStatus();
        navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_mine)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //设置侧滑菜单
        navigationview = (NavigationView) findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.tool_bar);
        //将ActionBar替换成Toolbar  将toolbar与ActionBar关联
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        //同步状态
        drawerToggle.syncState();
        //给侧滑控件设置监听
        drawerLayout.setDrawerListener(drawerToggle);
//        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
//            @Override
//            public void onDrawerSlide(@NonNull View view, float slideOffset) {
//                //滑动过程中回调，其中slideOffset的值为 0~1
////                View content = drawerLayout.getChildAt(0);
////                View menu = view;
////                float scale = 1 - slideOffset;//1~0
////                float leftScale = (float) (1f - 0.3 * scale);//1~0.7
////                //float rightScale = (float) (0.7f + 0.3 * scale);//0.7~1
////                menu.setScaleX(leftScale);//1~0.7
////                menu.setScaleY(leftScale);//1~0.7
////                //content.setScaleX(rightScale);
////                //content.setScaleY(rightScale);
////                content.setTranslationX(menu.getMeasuredWidth() * (1 - scale));//0~width
//            }
//
//            @Override
//            public void onDrawerOpened(@NonNull View view) {
//                //打开时回调
//
//            }
//
//            @Override
//            public void onDrawerClosed(@NonNull View view) {
//                //关闭时回调
//
//            }
//
//            @Override
//            public void onDrawerStateChanged(int i) {
//                //状态改变时回调
//
//            }
//        });



        /*---------------------------添加头布局和尾布局-----------------------------*/
        //获取xml头布局view
        View headerView = navigationview.getHeaderView(0);
        //添加头布局的另外一种方式
        //View headview=navigationview.inflateHeaderView(R.layout.navigationview_header);
        //寻找头部里面的控件
        ImageView imageView = headerView.findViewById(R.id.iv_head);
        Button btSetting = findViewById(R.id.footer_item_setting);
        btSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "点击了设置", Toast.LENGTH_LONG).show();
            }
        });
        Button btLoginOut = findViewById(R.id.footer_item_out);
        btLoginOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "点击了退出", Toast.LENGTH_LONG).show();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击了头像", Toast.LENGTH_LONG).show();
            }
        });
        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        });
        ColorStateList csl = (ColorStateList) getResources().getColorStateList(R.color.nav_menu_text_color);
        //设置item的条目颜色
        navigationview.setItemTextColor(csl);
        //去掉默认颜色显示原来颜色  设置为null显示本来图片的颜色
        navigationview.setItemIconTintList(csl);

        //设置单个消息数量
        LinearLayout llAndroid = (LinearLayout) navigationview.getMenu().findItem(R.id.single_1).getActionView();
        TextView msg = (TextView) llAndroid.findViewById(R.id.msg_bg);
        msg.setText("99+");

        //设置条目点击监听
        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //安卓
                Toast.makeText(getApplicationContext(), menuItem.getTitle(), Toast.LENGTH_LONG).show();
                //设置哪个按钮被选中
                menuItem.setChecked(true);
                //关闭侧边栏
                drawerLayout.closeDrawers();
                return false;
            }
        });

    }

    private void setStatus() {
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }


}

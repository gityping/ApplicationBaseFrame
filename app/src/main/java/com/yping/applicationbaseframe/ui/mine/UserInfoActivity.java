package com.yping.applicationbaseframe.ui.mine;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.makeramen.roundedimageview.RoundedImageView;
import com.yping.applicationbaseframe.R;
import com.yping.applicationbaseframe.util.GifSizeFilter;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.filter.Filter;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserInfoActivity extends AppCompatActivity {
    @BindView(R.id.iv_header)
    RoundedImageView ivHeader;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_age)
    TextView tvAge;
    private int REQUEST_CODE_CHOOSE = 1001;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_header, R.id.tv_name, R.id.tv_sex, R.id.tv_age})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_header:
                Matisse.from(UserInfoActivity.this)
                        .choose(MimeType.ofAll())
                        .countable(true)
                        .maxSelectable(9)//根据数量控制单选与多选
                        .showSingleMediaType(false)
                        .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
//                        .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
                        .showPreview(true) // Default is `true`
                        .forResult(REQUEST_CODE_CHOOSE);

                //参数很多，根据需要添加
//                PictureSelector.create(UserInfoActivity.this)
//                        .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
//                        .maxSelectNum(9)// 最大图片选择数量
//                        .minSelectNum(1)// 最小选择数量
//                        .imageSpanCount(4)// 每行显示个数
//                        .selectionMode(PictureConfig.SINGLE)// 多选 or 单选PictureConfig.MULTIPLE : PictureConfig.SINGLE
//                        .previewImage(true)// 是否可预览图片
//                        .isCamera(true)// 是否显示拍照按钮
//                        .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
//                        //.setOutputCameraPath("/CustomPath")// 自定义拍照保存路径
//                        .enableCrop(true)// 是否裁剪
//                        .compress(true)// 是否压缩
//                        //.sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
//                        .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
//                        .withAspectRatio(1, 1)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
//                        //.selectionMedia(selectList)// 是否传入已选图片
//                        //.previewEggs(false)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
//                        //.cropCompressQuality(90)// 裁剪压缩质量 默认100
//                        //.compressMaxKB()//压缩最大值kb compressGrade()为Luban.CUSTOM_GEAR有效
//                        //.compressWH() // 压缩宽高比 compressGrade()为Luban.CUSTOM_GEAR有效
//                        //.cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效
//                        .rotateEnabled(false) // 裁剪是否可旋转图片
//                        //.scaleEnabled()// 裁剪是否可放大缩小图片
//                        //.recordVideoSecond()//录制视频秒数 默认60s
//                        .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
                break;
            case R.id.tv_name:
                break;
            case R.id.tv_sex:
                break;
            case R.id.tv_age:
                TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tvAge.setText(date.getTime() + "");
                    }
                })
                        .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        //    .setContentSize(18)//滚轮文字大小
                        //    .setTitleSize(20)//标题文字大小
                        //    //.setTitleText("Title")//标题文字
                        //    .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                        //    .isCyclic(true)//是否循环滚动
                        //    //.setTitleColor(Color.BLACK)//标题文字颜色
                        //    .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                        //    .setCancelColor(Color.BLUE)//取消按钮文字颜色
                        //    //.setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
                        //    .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
                        ////    .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                        ////    .setRangDate(startDate,endDate)//起始终止年月日设定
                        //    //.setLabel("年","月","日","时","分","秒")//默认设置为年月日时分秒
                        .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        //.isDialog(true)//是否显示为对话框样式
                        .build();

                pvTime.show();
                break;
        }
    }

    List<Uri> mSelected;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data);
            Log.d("Matisse", "mSelected: " + mSelected);
            Glide.with(UserInfoActivity.this).load(mSelected.get(0)).apply(new RequestOptions().placeholder(R.mipmap.img_default).error(R.mipmap.img_default)).into(ivHeader);
        }
//        List<LocalMedia> images;
//        if (resultCode == RESULT_OK) {
//            if (requestCode == PictureConfig.CHOOSE_REQUEST) {// 图片选择结果回调
//
//                images = PictureSelector.obtainMultipleResult(data);
//                Glide.with(UserInfoActivity.this).load(images.get(0).getPath()).into(ivHeader);
////                selectList.addAll(images);
//
//                //selectList = PictureSelector.obtainMultipleResult(data);
//
//                // 例如 LocalMedia 里面返回三种path
//                // 1.media.getPath(); 为原图path
//                // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
//                // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
//                // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
//
//            }
//        }
    }

}

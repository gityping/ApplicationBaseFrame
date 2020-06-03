package com.yping.applicationbaseframe.ui.notifications;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.google.gson.Gson;
import com.yping.applicationbaseframe.R;
import com.yping.applicationbaseframe.entity.NotificationEntity;
import com.yping.applicationbaseframe.util.getLoacalJsonDataUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationsFragment extends Fragment {
    private String json = "{\n" +
            "  \"counts\": 20,\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"_id\": \"5e5533abefd6f28e2554f492\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-03-13 08:00:00\",\n" +
            "      \"desc\": \"当你要开口说话时，你所说的话，必须比沉默更有价值。 \u200B \u200B\u200B\u200B\u200B\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/21c417e3a84842bfa585dee686f6b992\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 0,\n" +
            "      \"publishedAt\": \"2020-03-13 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第23期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/21c417e3a84842bfa585dee686f6b992\",\n" +
            "      \"views\": 631\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e9591c60bd5529b54e712af\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-05-20 08:00:00\",\n" +
            "      \"desc\": \"希望下一次，能喜欢上一个也喜欢自己的人 \u200B\u200B\u200B\u200B。\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 0,\n" +
            "      \"publishedAt\": \"2020-05-20 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第91期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b\",\n" +
            "      \"views\": 286\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e959200ee6ba981da2af34d\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-05-22 08:00:00\",\n" +
            "      \"desc\": \"长不过执念，短不过善变。\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/d6bba8cf5b8c40f9ad229844475e9149\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 0,\n" +
            "      \"publishedAt\": \"2020-05-22 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第93期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/d6bba8cf5b8c40f9ad229844475e9149\",\n" +
            "      \"views\": 382\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e959107808d6d2fe6b56ed2\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-05-15 08:00:00\",\n" +
            "      \"desc\": \"爱一个人最好的方式， \\n是经营好自己； 爱人要有度，留一点自我， \\n才会有自尊，你的付出才会有人重视。 \u200B\u200B\u200B\u200B\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/92989b6a707b44dfb1c734e8d53d39a2\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 1,\n" +
            "      \"publishedAt\": \"2020-05-15 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第86期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/92989b6a707b44dfb1c734e8d53d39a2\",\n" +
            "      \"views\": 459\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e958fe40bd5529b54e712a6\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-04-30 08:00:00\",\n" +
            "      \"desc\": \"其实也不是什么忘不掉的人\\n只是对那场无结果的付出和被浪费的炽热的爱\\n耿耿于怀罢了\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/291ee91a554f4cd88bf9a09a9fa2e95e\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 0,\n" +
            "      \"publishedAt\": \"2020-04-30 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第71期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/291ee91a554f4cd88bf9a09a9fa2e95e\",\n" +
            "      \"views\": 246\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e55339cefd6f28e2554f48e\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-03-11 08:00:00\",\n" +
            "      \"desc\": \"时光太瘦，指缝太宽，不经意的一瞥，已隔经年。\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/94c30acee68340278dfc58e948109ab9\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 0,\n" +
            "      \"publishedAt\": \"2020-03-11 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第21期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/94c30acee68340278dfc58e948109ab9\",\n" +
            "      \"views\": 210\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e7785ba181a6495ef1172ad\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-03-29 08:00:00\",\n" +
            "      \"desc\": \"突如其来的脾气，往往是积攒很久了的委屈。❤\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/e6b78c1949d5438fa37ff2f272e5f1d0\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 0,\n" +
            "      \"publishedAt\": \"2020-03-29 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第39期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/e6b78c1949d5438fa37ff2f272e5f1d0\",\n" +
            "      \"views\": 648\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e958faf808d6d2fe6b56ecb\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-04-27 08:00:00\",\n" +
            "      \"desc\": \"相似的人适合玩闹/互补的人才能终老。 \u200B\u200B\u200B\u200B\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/4817628a6762410895f814079a6690a1\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 0,\n" +
            "      \"publishedAt\": \"2020-04-27 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第68期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/4817628a6762410895f814079a6690a1\",\n" +
            "      \"views\": 420\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e529d2a2adf62a2ba021cfb\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-03-01 08:00:00\",\n" +
            "      \"desc\": \"念念不忘的东西，一开始都美好的不像话。 \u200B\u200B\u200B\u200B\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/3e4423173d0a4c5e8447c0335b4458fc\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 1,\n" +
            "      \"publishedAt\": \"2020-03-01 08:00:00\",\n" +
            "      \"stars\": 4,\n" +
            "      \"title\": \"第11期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/3e4423173d0a4c5e8447c0335b4458fc\",\n" +
            "      \"views\": 991\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e8c80682bce50b3ceaa80ea\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-04-07 08:00:00\",\n" +
            "      \"desc\": \"当你越来越优秀的时候，就会遇见越来越好的人。\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/341ecaacdd7d4cc09cd0de100f3eab46\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 0,\n" +
            "      \"publishedAt\": \"2020-04-07 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第48期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/341ecaacdd7d4cc09cd0de100f3eab46\",\n" +
            "      \"views\": 441\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e72321065c5e56de1a75589\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-03-20 08:00:00\",\n" +
            "      \"desc\": \"心里藏着疲惫和委屈\\n面上却在尽力讨好生活\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/be3c70b17f364596b25f301a55164882\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 1,\n" +
            "      \"publishedAt\": \"2020-03-20 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第30期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/be3c70b17f364596b25f301a55164882\",\n" +
            "      \"views\": 791\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e77740db8ea09cade05263e\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-03-24 08:00:00\",\n" +
            "      \"desc\": \"心里藏着疲惫和委屈,\\n面上却在尽力讨好生活\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/b140f015a16e444aad6d76262f676a78\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 1,\n" +
            "      \"publishedAt\": \"2020-03-24 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第34期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/b140f015a16e444aad6d76262f676a78\",\n" +
            "      \"views\": 2012\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e5149256e7524f833c3f7a4\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-02-27 08:00:00\",\n" +
            "      \"desc\": \"原是今生今世已惘然， 山河岁月空惆怅， 而我，终将是要等着你的。\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/02eb8ca3297f4931ab64b7ebd7b5b89c\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 7,\n" +
            "      \"publishedAt\": \"2020-02-27 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第8期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/02eb8ca3297f4931ab64b7ebd7b5b89c\",\n" +
            "      \"views\": 2412\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e5149066e7524f833c3f7a2\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-02-26 08:00:00\",\n" +
            "      \"desc\": \"你看街上依旧繁花似锦，阳光依然璀璨温柔。总有一天，你会遇到一个彩虹般的人，从此以后，其他人不过是匆匆浮云。 \u200B\u200B\u200B\u200B\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/3a1997f4ecfb4a65ad84692fea3123bf\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 0,\n" +
            "      \"publishedAt\": \"2020-02-26 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第7期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/3a1997f4ecfb4a65ad84692fea3123bf\",\n" +
            "      \"views\": 429\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e958f2dee6ba981da2af33a\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-04-19 08:00:00\",\n" +
            "      \"desc\": \"对任何热爱的事情都要全力以赴/包括喜欢自己。 \u200B\u200B\u200B\u200B\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/a2d3115b8d464d93933e79e88af03580\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 2,\n" +
            "      \"publishedAt\": \"2020-04-19 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第60期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/a2d3115b8d464d93933e79e88af03580\",\n" +
            "      \"views\": 553\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e51493b6e7524f833c3f7a6\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-02-28 08:00:00\",\n" +
            "      \"desc\": \"曾踏月而来，只因你在山中。山风拂发、拂颈、拂裸露的肩膀，而月光衣我以华裳 。\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/89c170bf253346d98240d456cbc1c688\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 0,\n" +
            "      \"publishedAt\": \"2020-02-28 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第9期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/89c170bf253346d98240d456cbc1c688\",\n" +
            "      \"views\": 342\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e958ee017bf93950887f208\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-04-15 08:00:00\",\n" +
            "      \"desc\": \"愿所期之事皆能成，所念之人皆能到。 \",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/28fc02e86d584ff08802c8dcd9535b35\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 0,\n" +
            "      \"publishedAt\": \"2020-04-15 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第56期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/28fc02e86d584ff08802c8dcd9535b35\",\n" +
            "      \"views\": 387\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e959012808d6d2fe6b56ecc\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-05-03 08:00:00\",\n" +
            "      \"desc\": \"我们曾如此期待他人的认同，到最后才知道，世界是自己的，与他人毫无关系。\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/f7b320f1a89a4aaebadb1922c2a7a368\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 0,\n" +
            "      \"publishedAt\": \"2020-05-03 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第74期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/f7b320f1a89a4aaebadb1922c2a7a368\",\n" +
            "      \"views\": 223\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e958f7d808d6d2fe6b56ec9\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-04-24 08:00:00\",\n" +
            "      \"desc\": \"心里藏着小星星，生活才能亮晶晶。 \u200B\u200B\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/1a515f1508e345e2bf24673c2c2d50c4\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 0,\n" +
            "      \"publishedAt\": \"2020-04-24 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第65期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/1a515f1508e345e2bf24673c2c2d50c4\",\n" +
            "      \"views\": 312\n" +
            "    },\n" +
            "    {\n" +
            "      \"_id\": \"5e53d842773c439beff19bf6\",\n" +
            "      \"author\": \"鸢媛\",\n" +
            "      \"category\": \"Girl\",\n" +
            "      \"createdAt\": \"2020-03-10 08:00:00\",\n" +
            "      \"desc\": \"故人笑比庭中树，一日秋风一日疏。\",\n" +
            "      \"images\": [\n" +
            "        \"http://gank.io/images/59019eedff4540cd88c96cb96937465f\"\n" +
            "      ],\n" +
            "      \"likeCounts\": 0,\n" +
            "      \"publishedAt\": \"2020-03-10 08:00:00\",\n" +
            "      \"stars\": 1,\n" +
            "      \"title\": \"第20期\",\n" +
            "      \"type\": \"Girl\",\n" +
            "      \"url\": \"http://gank.io/images/30f70718ee274bb399a1069f9eb79ead\",\n" +
            "      \"views\": 199\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": 100\n" +
            "}";
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    private NotificationsViewModel notificationsViewModel;
    private BaseQuickAdapter<NotificationEntity.DataBean, BaseViewHolder> adapter;
    private List<NotificationEntity.DataBean> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        ButterKnife.bind(this, root);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                intiView();
            }
        });
        return root;
    }

    private void intiView() {
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recycleView.setLayoutManager(manager);

//        DividerItemDecoration divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
//        divider.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.custom_divider));
//        recycleView.addItemDecoration(divider);
        initData();
    }

    private void initData() {
        String jsonData = new getLoacalJsonDataUtil().getJson(getActivity(), "girl");
        Gson gson = new Gson();
        NotificationEntity data = gson.fromJson(json, NotificationEntity.class);

        adapter = new BaseQuickAdapter<NotificationEntity.DataBean, BaseViewHolder>(R.layout.item_notification, data.getData()) {
            @Override
            protected void convert(BaseViewHolder helper, NotificationEntity.DataBean item) {
                ImageView iv_cover = helper.getView(R.id.iv_cover);

                Glide.with(getActivity()).load(item.getUrl()).apply(new RequestOptions().placeholder(R.mipmap.img_default).error(R.mipmap.img_default)).into(iv_cover);
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
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), MoreToolsActivity.class));
            }
        });
    }
}

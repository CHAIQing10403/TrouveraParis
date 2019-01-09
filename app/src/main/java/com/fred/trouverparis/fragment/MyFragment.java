package com.fred.trouverparis.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fred.trouverparis.AboutUsActivity;
import com.fred.trouverparis.Adapter.FavoriteAdapter;
import com.fred.trouverparis.AroundBean;
import com.fred.trouverparis.AroundMeActivity;
import com.fred.trouverparis.FindSomeActivity;
import com.fred.trouverparis.MakeDecisionActivity;
import com.fred.trouverparis.PopularActivity;
import com.fred.trouverparis.R;

import java.util.ArrayList;
import java.util.List;

//Fragment是用来填充到ViewPager里的
public class MyFragment extends Fragment {

    public static final String POSITION = "POSITION";
    private String mPosition;
    private Context mContext;
    public RecyclerView favoriteRecyclerView;
    public static FavoriteAdapter favoriteAdapter;

    // 创建当前Fragment对象的方法
    public static MyFragment newInstance(String position) {
        MyFragment fragment = new MyFragment();
        // 将传进来的数据存在Bundle里然后再放到Argument里
        Bundle bundle = new Bundle();
        bundle.putString(POSITION, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    // Fragment的一个生命周期，通过该生命周期可以获取当绑定在当前Activity的对象
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 在该生命周期中取出数据。 之所以那么绕是因为上面的方法是static的
        if (getArguments() != null) {
            mPosition = getArguments().getString(POSITION);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 在该生命周期中根据传的值的不同显示不同的界面
        View myContainer;
        switch (mPosition) {
            case "Favorite":
                myContainer = inflater.inflate(R.layout.fragment_favorite, container, false);
                initContainer1(myContainer, mPosition); // 初始化不同界面的布局以及控件（下同）
                break;
            case "Home":
                myContainer = inflater.inflate(R.layout.fragment_home, container, false);
                initContainer2(myContainer, mPosition);
                break;
            case "Me":
                myContainer = inflater.inflate(R.layout.fragment_me, container, false);
                initContainer3(myContainer, mPosition);
                break;
            default:
                return null;
        }
        return myContainer;
    }

    // Favorite界面的布局
    private void initContainer1(View container, String title) {
        // 拿到该界面的控件
        TextView titleView = container.findViewById(R.id.tv_title);
        favoriteRecyclerView = container.findViewById(R.id.recycler_view);
        // 对控件进行初始化以及填充数据，设置适配器等操作
        LinearLayoutManager lm = new LinearLayoutManager(mContext);
        favoriteRecyclerView.setLayoutManager(lm);
        favoriteAdapter = new FavoriteAdapter(mContext);
        favoriteRecyclerView.setAdapter(favoriteAdapter);
        titleView.setText(title);
    }

    // HOME界面的布局
    private void initContainer2(View container, String title) {
        // 初始化各个按钮
        Button btnAround = container.findViewById(R.id.btn_around_me);
        Button btnFind = container.findViewById(R.id.btn_find_some);
        Button btnDecision = container.findViewById(R.id.btn_make_decision);
        Button btnPopular = container.findViewById(R.id.btn_popular);

        // 设置监听器，以此跳到不同的Activity
        btnAround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, AroundMeActivity.class));
            }
        });
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, FindSomeActivity.class));
            }
        });
        btnDecision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, MakeDecisionActivity.class));
            }
        });
        btnPopular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, PopularActivity.class));
            }
        });

    }

    // ME界面的布局
    private void initContainer3(View container, String title) {
        TextView titleView = container.findViewById(R.id.tv_title);
        titleView.setText(title);
        LinearLayout layoutAboutUs = container.findViewById(R.id.layout_about);
        // 当点击About Us的item时候跳转到AboutUsActivity
        layoutAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, AboutUsActivity.class));
            }
        });
    }
}

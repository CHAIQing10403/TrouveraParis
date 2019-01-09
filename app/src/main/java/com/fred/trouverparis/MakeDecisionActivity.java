package com.fred.trouverparis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MakeDecisionActivity extends AppCompatActivity {

    //初始化转盘控件
    private Lucky mLuckyPanView;
    private ImageView mStartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_decision);
        mLuckyPanView = findViewById(R.id.id_luckypan);
        mStartBtn = findViewById(R.id.id_start_btn);
        //给button加上点击事件，根据button当前的状态来判定显示内容
        mStartBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用isStart判断转盘是否处于开始状态
                if (!mLuckyPanView.isStart()) {
                    //给控件设置对应的资源
                    mStartBtn.setImageResource(R.drawable.stop);
                    //调用luckyStart方法让转盘开始转动
                    mLuckyPanView.luckyStart(1);
                } else {
                    //调用isShouldEnd判断转盘是否处于停止状态
                    if (!mLuckyPanView.isShouldEnd()) {
                        mStartBtn.setImageResource(R.drawable.start);
                        //调用luckyEnd方法告知转盘停止转动
                        mLuckyPanView.luckyEnd();
                    }
                }
            }
        });
    }
}

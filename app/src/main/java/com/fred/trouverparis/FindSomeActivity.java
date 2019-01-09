package com.fred.trouverparis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.fred.trouverparis.diglog.InvitationDialog;

public class FindSomeActivity extends AppCompatActivity implements View.OnClickListener {

    private InvitationDialog dialog;
    private String[] allInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_some);
        Button btn1 = findViewById(R.id.btn_add1);
        Button btn2 = findViewById(R.id.btn_add2);
        Button btn3 = findViewById(R.id.btn_add3);
        Button btnAdd = findViewById(R.id.btn_add_invitation);
        ImageView imgMe = findViewById(R.id.img_find_me);
        // 设置按钮的监听器
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        imgMe.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 加号的点击事件
            case R.id.btn_add_invitation:
                dialog = new InvitationDialog(this);
                // 将当前Activity的控件传过去，为了让其设置该界面的控件
                dialog.setLastViews(new View[]{findViewById(R.id.layout_last), findViewById(R.id.txt_name4),
                        findViewById(R.id.txt_res4), findViewById(R.id.txt_time4), findViewById(R.id.txt_content4)});
                if (InvitationDialog.allInfo != null) {
                    // 如果不为空就获取用户填写的数据
                    allInfo = InvitationDialog.allInfo;
                }
                // 显示dialog
                dialog.show();
                break;
                // 我的发布的点击事件
            case R.id.img_find_me:
                Intent intent = new Intent(this, MeInvitationActivity.class);
                if (allInfo != null) {
                    // 如果前面获取到数据了就传到下一个Activity
                    intent.putExtra("values", allInfo);
                }
                // 跳到我的发布的Activity
                startActivity(intent);
                break;
            default:
                Toast.makeText(this, "You have sent the invitation, waiting for reply!", Toast.LENGTH_SHORT).show();
        }
    }
}

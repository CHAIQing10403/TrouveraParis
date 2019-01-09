package com.fred.trouverparis.diglog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fred.trouverparis.R;


public class InvitationDialog extends Dialog {

    private static final String TAG = "InvitationDialog-vv";
    private View[] lastViews;
    private EditText editName;
    private EditText editRes;
    private EditText editTime;
    private EditText editContent;
    private Button btnCancel;
    private Button btnEnter;
    private TextView txtName1, resName1, txtTime1, txtContent1;
    private LinearLayout layout1;
    public static String[] allInfo = new String[4];

    public InvitationDialog(@NonNull Context context) {
        super(context, R.style.InvitationDialog);
        setContentView(R.layout.dialog_invitation);
        initView();
        setListener();
    }


    private void setListener() {
        // 取消按钮的点击事件
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); // 让当前Dialog消失
            }
        });
        // 确认按钮的点击事件
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 为前面Activity的控件设置用户输入的内容
                txtName1.setText(editName.getText().toString());
                resName1.setText(editRes.getText().toString());
                txtTime1.setText(editTime.getText().toString());
                txtContent1.setText(editContent.getText().toString());
                layout1.setVisibility(View.VISIBLE); // 并且让隐藏的layout可见
                // 将用户输入的数据存在当前的静态变量中，为了传到我的发布的Activity中
                allInfo[0] = editName.getText().toString();
                allInfo[1] = editRes.getText().toString();
                allInfo[2] = editTime.getText().toString();
                allInfo[3] = editContent.getText().toString();
                dismiss();
            }
        });
    }

    private void initView() {
        editName = findViewById(R.id.edit_name);
        editRes = findViewById(R.id.edit_res);
        editTime = findViewById(R.id.edit_time);
        editContent = findViewById(R.id.edit_content);
        btnCancel = findViewById(R.id.btn_cancel);
        btnEnter = findViewById(R.id.btn_enter);

    }


    private View[] getLastViews() {
        return lastViews;
    }

    public void setLastViews(View[] lastViews) {
        this.lastViews = lastViews;
        if (lastViews != null) {
            // 将上个Activity的控件赋值给当前类中
            layout1 = (LinearLayout) getLastViews()[0];
            txtName1 = (TextView) getLastViews()[1];
            resName1 = (TextView) getLastViews()[2];
            txtTime1 = (TextView) getLastViews()[3];
            txtContent1 = (TextView) getLastViews()[4];
        } else {
            Log.i(TAG, "lastViews:null ");
        }
    }

}

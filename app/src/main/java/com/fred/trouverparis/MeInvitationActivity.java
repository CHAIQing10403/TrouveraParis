package com.fred.trouverparis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MeInvitationActivity extends AppCompatActivity {
    private static final String TAG = "MeInvitationActivity-vv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_invitation);
        LinearLayout layout = findViewById(R.id.layout_last);
        TextView txtName = findViewById(R.id.txt_name4);
        TextView txtRes = findViewById(R.id.txt_res4);
        TextView txtTime = findViewById(R.id.txt_time4);
        TextView txtContent = findViewById(R.id.txt_content4);
        if (getIntent().getStringArrayExtra("values") != null) {
            // 拿到上个界面的数据
            Intent intent = getIntent();
            String[] data = intent.getStringArrayExtra("values");
            if (data.length != 0) {
                Log.i(TAG, "data:" + data.length);
                // 设置在这个界面的Activity上
                layout.setVisibility(View.VISIBLE);
                txtName.setText(data[0]);
                txtRes.setText(data[1]);
                txtTime.setText(data[2]);
                txtContent.setText(data[3]);
            }
        }
    }
}

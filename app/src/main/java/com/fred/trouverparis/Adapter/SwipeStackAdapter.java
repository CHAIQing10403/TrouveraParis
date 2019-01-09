package com.fred.trouverparis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fred.trouverparis.CardBean;
import com.fred.trouverparis.R;

import java.util.List;

// Popular界面的堆叠卡片的适配器
public class SwipeStackAdapter extends BaseAdapter {
    private List<CardBean> mData;
    private LayoutInflater layoutInflater;

    public SwipeStackAdapter(List<CardBean> data, Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // 返回卡片的数量
    @Override
    public int getCount() {
        return mData.size();
    }

    // 返回卡片
    @Override
    public String getItem(int position) {
        return mData.get(position).getName();
    }

    // 返回卡片当前的位置
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // 加载布局
        convertView = layoutInflater.inflate(R.layout.card_popular, parent, false);
        // 拿到布局里的控件
        ImageView imageView = convertView.findViewById(R.id.img_picture);
        TextView titleView = convertView.findViewById(R.id.tv_title);
        // 往控件中填充数据
        imageView.setBackgroundResource(mData.get(position).getDrawableId());
        titleView.setText(mData.get(position).getName());
        return convertView;
    }
}

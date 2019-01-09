package com.fred.trouverparis.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fred.trouverparis.AroundBean;
import com.fred.trouverparis.R;

import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private Context mContext;

    public static List<AroundBean>FavoriteLists = new ArrayList<>();


    //构造方法 获取当前上下文
    public FavoriteAdapter(Context context){
        this.mContext = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        View Item;
        TextView resImg;
        TextView resName;
        TextView resLocal;
        TextView resTime;
        TextView resComments;

        //实例化对应控件并绑定对应视图
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Item = itemView;
            resImg = Item.findViewById(R.id.res_pic);
            resName = Item.findViewById(R.id.res_name);
            resLocal = Item.findViewById(R.id.res_nation);
            resTime = Item.findViewById(R.id.res_time);
            resComments = Item.findViewById(R.id.comments);
        }
    }

    //给item绑定xml文件
    @NonNull
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_around_me,viewGroup,false);
        return new FavoriteAdapter.ViewHolder(view);
    }

    //给每个item设置数据
    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder viewHolder, int position) {
        AroundBean favorite = FavoriteLists.get(position);
        viewHolder.resTime.setText(favorite.getResPhone());
        viewHolder.resLocal.setText(favorite.getResLocal());
        viewHolder.resName.setText(favorite.getResName());
        viewHolder.resImg.setBackgroundResource(favorite.getImgId());
        viewHolder.resComments.setText(favorite.getResComments());
    }

    //返回总item数目
    @Override
    public int getItemCount() {
        return FavoriteLists.size();
    }
}

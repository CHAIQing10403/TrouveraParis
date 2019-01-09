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

import java.util.List;

public class AroundMeAdapter extends RecyclerView.Adapter<AroundMeAdapter.ViewHolder> {


    //初始化需要的基本信息
    private Context mcontext;
    private List<AroundBean> mlist;
    private OnItemClickListener mOnItemClickListener = null;
    private OnItemLongClickListener mOnItemLongClickListener = null;


    //构造方法传入上下文和list供adapter设置数据
    public AroundMeAdapter(Context context, List<AroundBean> list){
        this.mcontext = context;
        this.mlist = list;
    }

    //新建点击事件的listener，构建需要的click方法
    public interface OnItemClickListener{
        void onItemClick(Context context,double rawX,double rawY,String name);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }
    //新建长按事件的listener，构建需要的长按方法
    public interface OnItemLongClickListener{
        void onItemLongClick(Context context,int pic,String name,String loc,String num,String comments);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    //创建recyclerView的静态内部类
    static class ViewHolder extends RecyclerView.ViewHolder {

        View Item;
        TextView resImg;
        TextView resName;
        TextView resLocal;
        TextView resTime;
        TextView resComments;

        //初始化ViewHolder时获取相应控件
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

    //绑定item视图
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item_around_me,viewGroup,false);
        //通过绑定的item视图，构建viewHolder并返回此viewHolder
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        AroundBean around = mlist.get(position);
        //取出每个item中包含的信息，将其作为实际参数传入到自定义的点击事件方法中去
        final String name = mlist.get(position).getResName();
        final double rawX = mlist.get(position).getRawX();
        final double rawY = mlist.get(position).getRawY();
        final String num = mlist.get(position).getResPhone();
        final String loc = mlist.get(position).getResLocal();
        final int pic = mlist.get(position).getImgId();
        final String comments = mlist.get(position).getResComments();
        //利用Bean给每个item里的其他控件设置具体参数
        viewHolder.resTime.setText(around.getResPhone());
        viewHolder.resLocal.setText(around.getResLocal());
        viewHolder.resName.setText(around.getResName());
        viewHolder.resImg.setBackgroundResource(around.getImgId());
        viewHolder.resComments.setText(around.getResComments());
        //将拿到的上下文，横纵坐标，以及对应位置的名称传给ClickListener
        viewHolder.Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(mcontext,rawX,rawY,name);
                }
            }
        });
        //将取出的上下文及餐馆的具体信息传给LongClickListener
        viewHolder.Item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemLongClickListener != null){
                    mOnItemLongClickListener.onItemLongClick(mcontext,pic,name,loc,num,comments);
                }
                return true;
            }
        });
    }

    //返回餐馆列表长度
    @Override
    public int getItemCount() {
        return mlist.size();
    }
}

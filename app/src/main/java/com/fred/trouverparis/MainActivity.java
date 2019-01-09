package com.fred.trouverparis;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.fred.trouverparis.fragment.MyFragment;

public class MainActivity extends AppCompatActivity implements TabHost.TabContentFactory {

    private ViewPager mViewPager;
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView(); // 初始化控件
        initData(); // 初始化数据
    }

    private void initView() {
        // 初始化viewPager控件
        mViewPager = findViewById(R.id.view_pager);
        // 初始化mTabHost
        mTabHost = findViewById(R.id.tab_host);
        mTabHost.setup();
    }

    private void initData() {
        // 初始化主界面的底下三个icon资源
        int[] drawableIDs = {R.drawable.main_tab_icon_like, R.drawable.main_tab_icon_home, R.drawable.main_tab_icon_me};
        // 初始化主界面的底下三个icon对应的名字
        String[] titleIDs = {"FAVORITE", "HOME", "ME"};

        // 将数据加载到主界面底下的控件中
        for (int index = 0; index < titleIDs.length; index++) {
            // 拿到每个标签的布局
            View view = getLayoutInflater().inflate(R.layout.main_tab_layout, null, false);
            View tab = view.findViewById(R.id.tab_bg);
            ImageView icon = view.findViewById(R.id.main_tab_icon);
            TextView title = view.findViewById(R.id.main_tab_txt);
            // 往里面填充数据
            icon.setImageResource(drawableIDs[index]);
            title.setText(titleIDs[index]);
            tab.setBackgroundColor(getResources().getColor(R.color.white));

            // 为TabHost添加Tab
            mTabHost.addTab(
                    // 参数为Tag，是Tab的标记
                    mTabHost.newTabSpec(titleIDs[index])
                            // 将视图指定为选项卡指示符。
                            .setIndicator(view)
                            // 设置标签要显示的内容
                            .setContent(this)
            );
        }
        // 初始化三个fragment
        final MyFragment[] fragments = new MyFragment[]{
                MyFragment.newInstance("Favorite"),
                MyFragment.newInstance("Home"),
                MyFragment.newInstance("Me")
        };

        // 为viewPager设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments[i];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
        });

        //设置ViewPager和TabHost初始显示的界面为HOME
        mViewPager.setCurrentItem(1);
        mTabHost.setCurrentTab(1);

        // 设置ViewPager改变Tab跟着改变
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                // 设置当前的Tab与ViewPager的位置相对应
                if (mTabHost != null) {
                    mTabHost.setCurrentTab(i);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

        // 设置Tab改变ViewPager也跟着改变
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (mTabHost != null) {
                    // 获取当前Tab的位置
                    int position = mTabHost.getCurrentTab();
                    mViewPager.setCurrentItem(position);
                }
            }
        });
    }

    // 实现接口必须实现的方法
    @Override
    public View createTabContent(String tag) {
        View view = new View(this);
        // 将view隐藏起来，因为这里用ViewPager显示内容
        view.setMinimumHeight(0);
        view.setMinimumWidth(0);
        return view;
    }
}

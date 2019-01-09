package com.fred.trouverparis;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.fred.trouverparis.Adapter.AroundMeAdapter;
import com.fred.trouverparis.Adapter.FavoriteAdapter;
import com.fred.trouverparis.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class AroundMeActivity extends AppCompatActivity {

    private List<AroundBean> Aroundlists = new ArrayList<>();

    private List<AroundBean> FavoriteLists = new ArrayList<>();

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_around_me);
        initData();
        //设置一般
        recyclerView = findViewById(R.id.around_me_recycler);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
        AroundMeAdapter adapter = new AroundMeAdapter(this, Aroundlists);
        recyclerView.setAdapter(adapter);
        //给item设置点击事件，并将数据存入Bundle，再传入google地图的Activity
        adapter.setOnItemClickListener(new AroundMeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Context context, double rawX, double rawY, String name) {
                Intent intent = new Intent(context, MapsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putDouble("rawX", rawX);
                bundle.putDouble("rawY", rawY);
                intent.putExtra("values", bundle);
                startActivity(intent);
            }
        });
        //给item设置长按事件，在收藏列表加入对应的数据，并弹窗提示收藏成功
        adapter.setOnItemLongClickListener(new AroundMeAdapter.OnItemLongClickListener() {

            @Override
            public void onItemLongClick(Context context,int pic, String name, String loc, String num, String comments) {
                FavoriteAdapter.FavoriteLists.add(new AroundBean(pic, name, loc, num, comments));
                //通过Adapter提示相应视图已经改变
                MyFragment.favoriteAdapter.notifyDataSetChanged();
                Toast.makeText(context,"Collection success",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //创建餐馆对象并传入附近餐馆的基本数据
    private void initData() {
        AroundBean restaurant1 = new AroundBean(
                48.817935,
                2.283054,
                R.drawable.res1,
                "Le Pavillon de la Tourelle",
                "10 Rue Larmeroux, 92170 Vanves, France",
                "+33 1 46 42 15 59",
                "Le restaurant avait été privatisé par des amis. Très bel endroit. Menu d une qualité exceptionnelle servi par un personnel discret et attentif. Très bonne adresse à retenir"
        );
        AroundBean restaurant2 = new AroundBean(
                48.825365,
                2.247379,
                R.drawable.res2,
                "长安府Palais de Chang An",
                "3 Rue Yves Kermen, 92100 Boulogne-Billancourt, France",
                "+33 9 53 70 85 10",
                "Excellent family run noodle house, great value and really tasty food. We were excited to see a Chinese open up in the area and happier still that the food is great! Everything was fresh, they were making noodles to order and the taste of all the dishes we tried was excellent. Original, home made and authentic, good value and really tasty."
        );
        AroundBean restaurant3 = new AroundBean(
                48.829365,
                2.246901,
                R.drawable.res8,
                "Le 5",
                "5 Rue Molière, 92100 Boulogne-Billancourt, France",
                "+33 1 46 21 91 86",
                "Excellent endroit à Boulogne pour dîner. Depuis sa reprise c'est un franc succès. Accueil impeccable, service souriant,tjs arrangeant et au petit soin, le chef vient tjs vous saluer, cuisine top et très bon rapport qualité prix. Je recommande à 100°/!!!! Un grand bravo à Sébastien et son équipe! Continuez"
        );
        AroundBean restaurant4 = new AroundBean(
                48.839971,
                2.283582,
                R.drawable.res3,
                "Saturne",
                "153 Rue de Lourmel, 75015 Paris, France",
                "+33 1 45 00 86 40",
                "Super restaurant de vraie cuisine sichuanaise et d'autres régions de Chine (le superbe canard à la pekinoise et ses crêpes). Il est juste dommage que le service soit parfois très lent."
        );
        AroundBean restaurant5 = new AroundBean(
                48.833526,
                2.242430,
                R.drawable.res4,
                "Pedra Alta",
                "6 Avenue du Général Leclerc, 92100 Boulogne-Billancourt, France",
                "+33 1 46 03 54 04",
                "Étant connu pour être une référence dans les fruits de mer, la viande est simplement excellente: tendre et juteuse ! Très très copieux, une demi dose pour deux est suffisante ! Personnel sympathique et serviable, service assez rapide une fois à table mais faudra compter 1h de queue avant. Bon rapport qualité prix. Produits frais et de qualité. Je recommande"
        );
        AroundBean restaurant6 = new AroundBean(
                48.83501,
                2.289280,
                R.drawable.res5,
                "L'Insoumise",
                "15 Rue Auguste Chabrières, 75015 Paris, France",
                "+33 1 45 31 08 88",
                "Restaurant cosy, avec une déco délicate, une carte raccourcie qui justifie la fraîcheur des aliments. Plats préparés avec soin et vraiment bons ! Attention personnalisée du gérant qui est aux petits soins pour chaque table. Je recommande !"
        );
        AroundBean restaurant7 = new AroundBean(
                48.837085,
                2.278136,
                R.drawable.res6,
                "Pho 520",
                "85 Rue Leblanc, 75015 Paris, France",
                "+33 1 45 51 11 58",
                "Fast service, good food. Nice place for a quick, tasty, affordable lunch. Gets crowded, so be ready to rub elbows with your neighbor."
        );
        AroundBean restaurant8 = new AroundBean(
                48.810289,
                2.267455,
                R.drawable.res7,
                "Cuisine du Terroir Spécialités Aveyronnaises",
                "15 Rue Condorcet, 92140 Clamart, France",
                "+33 1 47 36 22 03",
                "Cuisine authentique et de qualité à un prix abordable. Service de qualité. On voit qu'on a affaire à des passionnés. Je recommande vivement cette adresse."
        );
        //将创建的餐馆对象加入到附近餐馆列表中去
        Aroundlists.add(restaurant1);
        Aroundlists.add(restaurant2);
        Aroundlists.add(restaurant3);
        Aroundlists.add(restaurant4);
        Aroundlists.add(restaurant5);
        Aroundlists.add(restaurant6);
        Aroundlists.add(restaurant7);
        Aroundlists.add(restaurant8);
    }
}

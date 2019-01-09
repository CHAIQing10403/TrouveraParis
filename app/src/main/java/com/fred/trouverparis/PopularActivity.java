package com.fred.trouverparis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.fred.trouverparis.Adapter.FavoriteAdapter;
import com.fred.trouverparis.Adapter.SwipeStackAdapter;
import com.fred.trouverparis.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

import link.fls.swipestack.SwipeStack;

public class PopularActivity extends AppCompatActivity {

    private List<CardBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);
        initData(); // 初始化数据
        final SwipeStack swipeStack = findViewById(R.id.swipeStack); // 拿到卡片堆叠的控件
        swipeStack.setAdapter(new SwipeStackAdapter(mData, this)); // 设置适配器
        // 设置卡片堆叠的监听器
        swipeStack.setListener(new SwipeStack.SwipeStackListener() {
            @Override
            public void onViewSwipedToLeft(int position) {

            }

            @Override
            public void onViewSwipedToRight(int position) {
                // 当用户往又滑动即喜欢该item的时候的逻辑
                addDataToFavorite(position);
                Toast.makeText(PopularActivity.this, "Collection success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStackEmpty() {
                swipeStack.resetStack();
            }
        });
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add(new CardBean(R.drawable.res1, "Le Pavillon de la Tourelle"));
        mData.add(new CardBean(R.drawable.res2, "长安府Palais de Chang An"));
        mData.add(new CardBean(R.drawable.res3, "Saturne"));
        mData.add(new CardBean(R.drawable.res4, "Pedra Alta"));
        mData.add(new CardBean(R.drawable.res5, "L'Insoumise"));
        mData.add(new CardBean(R.drawable.res6, "Pho 520"));
        mData.add(new CardBean(R.drawable.res7, "Cuisine du Terroir Spécialités Aveyronnaises"));
        mData.add(new CardBean(R.drawable.res8, "Le 5"));
    }

    // 将数据加到收藏中
    private void addDataToFavorite(int position) {
        switch (position) {
            case 0:
                FavoriteAdapter.FavoriteLists.add(new AroundBean(R.drawable.res1, "Le Pavillon de la Tourelle",
                        "10 Rue Larmeroux, 92170 Vanves, France", "+33 1 46 42 15 59",
                        "Le restaurant avait été privatisé par des amis. Très bel endroit. Menu d une qualité exceptionnelle servi par un personnel discret et attentif. Très bonne adresse à retenir"));
                break;
            case 1:
                FavoriteAdapter.FavoriteLists.add(new AroundBean(R.drawable.res2, "长安府Palais de Chang An",
                        "3 Rue Yves Kermen, 92100 Boulogne-Billancourt, France", "+33 9 53 70 85 10",
                        "Excellent family run noodle house, great value and really tasty food. We were excited to see a Chinese open up in the area and happier still that the food is great! Everything was fresh, they were making noodles to order and the taste of all the dishes we tried was excellent. Original, home made and authentic, good value and really tasty."));
                break;
            case 2:
                FavoriteAdapter.FavoriteLists.add(new AroundBean(R.drawable.res3, "Saturne",
                        "153 Rue de Lourmel, 75015 Paris, France", "+33 1 45 00 86 40",
                        "Super restaurant de vraie cuisine sichuanaise et d'autres régions de Chine (le superbe canard à la pekinoise et ses crêpes). Il est juste dommage que le service soit parfois très lent."));
                break;
            case 3:
                FavoriteAdapter.FavoriteLists.add(new AroundBean(R.drawable.res4, "Pedra Alta",
                        "6 Avenue du Général Leclerc, 92100 Boulogne-Billancourt, France", "+33 1 46 03 54 04",
                        "Étant connu pour être une référence dans les fruits de mer, la viande est simplement excellente: tendre et juteuse ! Très très copieux, une demi dose pour deux est suffisante ! Personnel sympathique et serviable, service assez rapide une fois à table mais faudra compter 1h de queue avant. Bon rapport qualité prix. Produits frais et de qualité. Je recommande"));
                break;
            case 4:
                FavoriteAdapter.FavoriteLists.add(new AroundBean(R.drawable.res5, "L'Insoumise",
                        "15 Rue Auguste Chabrières, 75015 Paris, France", "+33 1 45 31 08 88",
                        "Restaurant cosy, avec une déco délicate, une carte raccourcie qui justifie la fraîcheur des aliments. Plats préparés avec soin et vraiment bons ! Attention personnalisée du gérant qui est aux petits soins pour chaque table. Je recommande !"
                ));
                break;
            case 5:
                FavoriteAdapter.FavoriteLists.add(new AroundBean(R.drawable.res6, "Pho 520",
                        "85 Rue Leblanc, 75015 Paris, France", "+33 1 45 51 11 58",
                        "Fast service, good food. Nice place for a quick, tasty, affordable lunch. Gets crowded, so be ready to rub elbows with your neighbor."));
                break;
            case 6:
                FavoriteAdapter.FavoriteLists.add(new AroundBean(R.drawable.res7, "Cuisine du Terroir Spécialités Aveyronnaises",
                        "15 Rue Condorcet, 92140 Clamart, France", "+33 1 47 36 22 03",
                        "Cuisine authentique et de qualité à un prix abordable. Service de qualité. On voit qu'on a affaire à des passionnés. Je recommande vivement cette adresse."));
                break;
            case 7:
                FavoriteAdapter.FavoriteLists.add(new AroundBean(R.drawable.res8, "Le 5",
                        "5 Rue Molière, 92100 Boulogne-Billancourt, France", "+33 1 46 21 91 86",
                        "Excellent endroit à Boulogne pour dîner. Depuis sa reprise c'est un franc succès. Accueil impeccable, service souriant,tjs arrangeant et au petit soin, le chef vient tjs vous saluer, cuisine top et très bon rapport qualité prix. Je recommande à 100°/!!!! Un grand bravo à Sébastien et son équipe! Continuez"));
                break;
            default:
        }
        MyFragment.favoriteAdapter.notifyDataSetChanged();
    }
}

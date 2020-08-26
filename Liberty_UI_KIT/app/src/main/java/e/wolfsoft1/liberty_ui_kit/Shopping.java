package e.wolfsoft1.liberty_ui_kit;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

//import adapter.ShoppingAdapter;
import adapter.ViewPagerAdapter;
import me.relex.circleindicator.CircleIndicator;
//import model.ShoppingModel;

public class Shopping extends AppCompatActivity {
    private ViewPagerAdapter pagerAdapter;
    private ViewPager viewpager;
    ImageView leftNav, rightNav;

//    private ShoppingAdapter adapterRecycler1;
//    private RecyclerView recyclerview1;
//    private ArrayList<ShoppingModel> modelRecyclerArrayList1;

//    Integer[] shoppingimg ={R.drawable.taittinger,R.drawable.budweiser,R.drawable.rio,R.drawable.rio2};
//    String[] shoppingtext ={"$62.35","$84.99","$127.65","$71.50"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);


        viewpager = (ViewPager) findViewById(R.id.viewpager);

        leftNav = (ImageView) findViewById(R.id.left_nav);
        rightNav = (ImageView) findViewById(R.id.right_nav);
        // CircleIndicator indicator =(CircleIndicator) findViewById(R.id.indicator);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(pagerAdapter);
        //  indicator.setViewPager(viewpager);
        // pagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());


//


// Images left navigation
        leftNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = viewpager.getCurrentItem();
                if (tab > 0) {
                    tab--;
                    viewpager.setCurrentItem(tab);
                } else if (tab == 0) {
                    viewpager.setCurrentItem(tab);
                }
            }
        });

        // Images right navigatin
        rightNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = viewpager.getCurrentItem();
                tab++;
                viewpager.setCurrentItem(tab);
            }
        });


        //sp_car_model = (Spinner)view.findViewById(R.id.sp_car_model);


//        recyclerview1 = findViewById(R.id.recyclerview1);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(Shopping.this,2);
//        recyclerview1.setLayoutManager(layoutManager);
//        recyclerview1.setItemAnimator(new DefaultItemAnimator());
//
//        modelRecyclerArrayList1 = new ArrayList<>();
//
//
//        for (int i=0;i<shoppingimg.length;i++){
//            ShoppingModel food5_detail_model = new ShoppingModel(shoppingimg[i],shoppingtext[i]);
//
//            modelRecyclerArrayList1.add(food5_detail_model);
//
//        }
//        adapterRecycler1 = new ShoppingAdapter(Shopping.this,modelRecyclerArrayList1);
//        recyclerview1.setAdapter(adapterRecycler1);
//    }

//    public void onRightClick(View view) {
//        viewpager.arrowScroll(ViewPager.FOCUS_RIGHT);
//    }
//
//    public void onLeftClick(View view) {
//        viewpager.arrowScroll(ViewPager.FOCUS_LEFT);
//    }


    }
}
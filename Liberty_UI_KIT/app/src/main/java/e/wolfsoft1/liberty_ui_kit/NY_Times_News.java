package e.wolfsoft1.liberty_ui_kit;

import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import adapter.TabNyNews;

public class NY_Times_News extends AppCompatActivity {


    ViewPager viewPager1;
    TabLayout tabLayout1;
    TabNyNews adapter;

    private Typeface mTypeface;
    private Typeface mTypefaceBold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ny__times__news);


        tabLayout1 = findViewById(R.id.tablayout1);

        viewPager1 = findViewById(R.id.viewpager1);

        setCustomFontAndStyle(tabLayout1, 0);
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);


        tabLayout1.addTab(tabLayout1.newTab().setText("Newest"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Popular"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Trending"));

        Typeface mTypeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        ViewGroup vg = (ViewGroup) tabLayout1.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(mTypeface, Typeface.NORMAL);
                }
            }
        }

        adapter = new TabNyNews(getSupportFragmentManager(), tabLayout1.getTabCount());
        viewPager1.setAdapter(adapter);
        viewPager1.setOffscreenPageLimit(3);
        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));
        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


        private void setCustomFontAndStyle(TabLayout tabLayout, Integer position) {
            mTypeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
            mTypefaceBold = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
            ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
            int tabsCount = vg.getChildCount();
            for (int j = 0; j < tabsCount; j++) {
                ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
                int tabChildsCount = vgTab.getChildCount();
                for (int i = 0; i < tabChildsCount; i++) {
                    View tabViewChild = vgTab.getChildAt(i);
                    if (tabViewChild instanceof TextView) {
                        if (j == position) {
                            ((TextView) tabViewChild).setTypeface(mTypefaceBold, Typeface.NORMAL);
                        } else {
                            ((TextView) tabViewChild).setTypeface(mTypeface, Typeface.NORMAL);
                        }
                    }
                }


        }

    }
}

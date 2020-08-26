package e.wolfsoft1.liberty_ui_kit;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adapter.TabProfile;

public class Profile extends AppCompatActivity {
    ViewPager viewPager1;
    TabLayout tabLayout1;
    TabProfile adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        tabLayout1 = findViewById(R.id.tablayout1);

        viewPager1 = findViewById(R.id.viewpager1);

        tabLayout1.addTab(tabLayout1.newTab().setText("Posts"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Bookmarks"));
        tabLayout1.addTab(tabLayout1.newTab().setText("News"));

        adapter = new TabProfile(getSupportFragmentManager(),tabLayout1.getTabCount());
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
}

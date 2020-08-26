package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragments.Newest;
import fragments.Popular;
import fragments.Trending;


/**
 * Created by wolfsoft3 on 24/7/18.
 */

public class TabNyNews extends FragmentStatePagerAdapter {
    int numoftabs;

    public TabNyNews(FragmentManager fm, int  mnumoftabs ) {
        super(fm);
        this.numoftabs = mnumoftabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Popular tab1 = new Popular();
                return tab1;

            case 1:
                Popular tab2 = new Popular();
                return tab2;

            case 2:
                Popular tab3 = new Popular();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
            return numoftabs;
    }
}

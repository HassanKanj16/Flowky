package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragments.Budweiser;
import fragments.Rio;
import fragments.Rio2;
import fragments.Taittinger;


/**
 * Created by wolfsoft3 on 25/7/18.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
               Taittinger tab1 = new Taittinger();
                return tab1;

            case 1:
                Budweiser tab2 = new Budweiser();
                return tab2;

            case 2:
                Rio tab3 = new Rio();
                return tab3;

            case 3:
                Rio2 tab4 = new Rio2();
                return tab4;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}

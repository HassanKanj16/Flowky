package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragments.Hello;
import fragments.Simple;
import fragments.Worldwide;

public class Hello1Adapter extends FragmentStatePagerAdapter {
    public Hello1Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Simple tab1 = new Simple();
                return tab1;
            case 1:
                Hello tab2 = new Hello();
                return tab2;
            case 2:
                Hello tab3 = new Hello();
                return tab3;
            case 3:
                Hello tab4 = new Hello();
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

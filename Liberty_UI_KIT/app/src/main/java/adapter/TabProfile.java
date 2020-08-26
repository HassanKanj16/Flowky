package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragments.Bookmarks;
import fragments.Newest;
import fragments.News;
import fragments.Popular;
import fragments.Posts;
import fragments.Trending;

public class TabProfile extends FragmentStatePagerAdapter {

    int numoftabs;
    public TabProfile(FragmentManager fm, int mnumoftabs) {
        super(fm);
        this.numoftabs = mnumoftabs;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Bookmarks tab1 = new Bookmarks();
                return tab1;

            case 1:
                Bookmarks tab2 = new Bookmarks();
                return tab2;

            case 2:
                Bookmarks tab3 = new Bookmarks();
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

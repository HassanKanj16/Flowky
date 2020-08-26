package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapter.ProfileAdapter;
import e.wolfsoft1.liberty_ui_kit.R;
import model.ProfileModel;


public class Bookmarks extends Fragment {
    Integer[] bookimg = {R.drawable.rbcimg,R.drawable.news1,R.drawable.bbcworld,R.drawable.nbcnightly,R.drawable.rbcimg,R.drawable.news1};

    String[] booktext = {"A City Living\nUnder the\nShadow","One Problem\nfor Democratic\nLeaders","The Golden\nSecret to Better\nBreakfast","How to Plan\nYour First Ski \nVacation","How Social \nIsolation Is\nKilling Us","Use Labels to\nSort Messages\nin Facebook"};
    String[] booktext1 = {"RBC News","NY Times","BBC World","NBC Nightly","RBC News","BBC World"};


    private ProfileAdapter homepageAdapter;
    private RecyclerView recyclerview;
    private ArrayList<ProfileModel> bookmarksModelArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.profilerecyclerview,container,false);


        recyclerview = view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager( getContext(),2);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        bookmarksModelArrayList = new ArrayList<>();


        for (int i = 0; i < bookimg.length; i++) {
            ProfileModel view1 = new ProfileModel( bookimg[i],booktext[i],booktext1[i]);
            bookmarksModelArrayList.add(view1);
        }
        homepageAdapter = new ProfileAdapter(getActivity(),bookmarksModelArrayList);
        recyclerview.setAdapter(homepageAdapter);

        return view;
    }
}

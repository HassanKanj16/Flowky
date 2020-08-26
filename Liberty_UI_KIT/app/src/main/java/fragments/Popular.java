package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapter.NynewsAdapter;

import e.wolfsoft1.liberty_ui_kit.R;
import model.NynewsModel;

public class Popular extends Fragment{

    Integer[]  nyimg = {R.drawable.roadriding, R.drawable.food,R.drawable.hotelimg};
    Integer[] nyimg2 = {R.drawable.purledot,R.drawable.reddot,R.drawable.green_dot};

    String[] nytext1 =  {"Road Riding Essentials \nFor a 200km Ride","25 Foods You Don’t \nNeed to Buy Organic","Top 100 Beach Hotels,\nGuesthouses & Hostels"};
    String[] nytext2 = {"Lifestyle","Health","Travel"};



    private NynewsAdapter homepageAdapter;
    private RecyclerView recyclerview;
    private ArrayList<NynewsModel> nynewsModelArrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.nyrecycler,container,false);


        recyclerview = view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getContext());
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        nynewsModelArrayList = new ArrayList<>();


        for (int i = 0; i < nyimg.length; i++) {
            NynewsModel view1 = new NynewsModel( nyimg[i],nyimg2[i],nytext1[i],nytext2[i]);
            nynewsModelArrayList.add(view1);
        }
        homepageAdapter = new NynewsAdapter(getActivity(),nynewsModelArrayList);
        recyclerview.setAdapter(homepageAdapter);

        return view;
    }
}

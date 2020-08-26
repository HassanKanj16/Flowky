package e.wolfsoft1.liberty_ui_kit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


import adapter.libertyListRecycleAdapter;
import model.KwikListModelClass;

public class LibertyListActivity extends AppCompatActivity {


    private ArrayList<KwikListModelClass> kwikListModelClasses;
    private RecyclerView recyclerView;
    private libertyListRecycleAdapter bAdapter;

    private String txt[]={"1.SignUpW ith Social Activity","2.Login With SocialAccount","3.WorldWide Delivery","4.Liberty Home Settings",
    "5.Package Tracking","6.Shopping","7.NY Times News","8.Profile"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LibertyListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        kwikListModelClasses = new ArrayList<>();

        for (int i = 0; i < txt.length; i++) {
            KwikListModelClass beanClassForRecyclerView_contacts = new KwikListModelClass(txt[i]);
            kwikListModelClasses.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new libertyListRecycleAdapter(LibertyListActivity.this,kwikListModelClasses);
        recyclerView.setAdapter(bAdapter);


    }
}

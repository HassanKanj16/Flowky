package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


import e.wolfsoft1.liberty_ui_kit.Activity_Settings;
import e.wolfsoft1.liberty_ui_kit.liberty_media_account_main;
import e.wolfsoft1.liberty_ui_kit.NY_Times_News;
import e.wolfsoft1.liberty_ui_kit.Package_Tracking;
import e.wolfsoft1.liberty_ui_kit.Profile;
import e.wolfsoft1.liberty_ui_kit.R;
import e.wolfsoft1.liberty_ui_kit.Shopping;
import e.wolfsoft1.liberty_ui_kit.SignUp1;
import e.wolfsoft1.liberty_ui_kit.Worldwide_delivery;
import model.KwikListModelClass;



public class libertyListRecycleAdapter extends RecyclerView.Adapter<libertyListRecycleAdapter.MyViewHolder> {

    Context context;


    private List<KwikListModelClass> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView title;


        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);


        }

    }


    public libertyListRecycleAdapter(Context context, List<KwikListModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public libertyListRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kwik_list, parent, false);


        return new libertyListRecycleAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        KwikListModelClass lists = OfferList.get(position);
        holder.title.setText(lists.getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position == 0) {
                    Intent i = new Intent(context, SignUp1.class);
                    context.startActivity(i);
                } else if (position == 1) {
                    Intent i = new Intent(context, liberty_media_account_main.class);
                    context.startActivity(i);
                } else if (position == 2) {
                    Intent i = new Intent(context, Worldwide_delivery.class);
                    context.startActivity(i);
                } else if (position == 3) {
                    Intent i = new Intent(context, Activity_Settings.class);
                    context.startActivity(i);
                } else if (position == 4) {
                    Intent i = new Intent(context, Package_Tracking.class);
                    context.startActivity(i);
                } else if (position == 5) {
                    Intent i = new Intent(context, Shopping.class);
                    context.startActivity(i);
                } else if (position == 6) {
                    Intent i = new Intent(context, NY_Times_News.class);
                    context.startActivity(i);
                } else if (position == 7) {
                    Intent i = new Intent(context, Profile.class);
                    context.startActivity(i);

                }
            }

        });


    }


    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}



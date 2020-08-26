package adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

import e.wolfsoft1.liberty_ui_kit.Activity_Settings;
import e.wolfsoft1.liberty_ui_kit.R;
import model.LibertySettings_Model;
import model.NynewsModel;

public class LibertySetting_Adapter extends RecyclerView.Adapter<LibertySetting_Adapter.ViewHolder> {
  Context context;
  ArrayList<LibertySettings_Model> modelArrayList;
  Dialog slideDialog;




    @NonNull
    @Override
    public LibertySetting_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity__settings, parent, false);

        return new LibertySetting_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibertySetting_Adapter.ViewHolder holder, int position) {
        LibertySettings_Model modelfoodrecycler = modelArrayList.get(position);
        holder.market.setText(modelfoodrecycler.getMarket());


        holder.market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView market;
        public ViewHolder(View itemView) {
            super(itemView);


        }
    }


        }

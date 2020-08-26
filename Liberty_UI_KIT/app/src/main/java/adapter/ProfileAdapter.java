package adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import e.wolfsoft1.liberty_ui_kit.R;
import model.ProfileModel;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder> {
    Context context;
    private ArrayList<ProfileModel> bookmarksModelArrayList;

    int myPos = 0;


    public ProfileAdapter(Context context, ArrayList<ProfileModel> bookmarksModelArrayList) {
        this.context = context;
        this.bookmarksModelArrayList = bookmarksModelArrayList;
    }

    @NonNull
    @Override
    public ProfileAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profilerecyclerview_item, parent, false);

        return new ProfileAdapter.MyViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.MyViewHolder holder, final int position) {
        ProfileModel modelfoodrecycler = bookmarksModelArrayList.get(position);


        holder.bookimg.setImageResource(modelfoodrecycler.getBookimg());
        holder.booktext.setText(modelfoodrecycler.getBooktext());
        holder.booktext1.setText(modelfoodrecycler.getBooktext1());

//        holder.ll1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


        if (myPos == position){

            holder.ll1.setBackgroundResource(R.drawable.graycolor);
        }else {

            holder.ll1.setBackgroundResource(R.drawable.whitecolor);

        }


        holder.ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPos = position;
                notifyDataSetChanged();

            }


        });





    }

    @Override
    public int getItemCount() {
               return bookmarksModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView bookimg;
        TextView booktext,booktext1;
        LinearLayout ll1;
        public MyViewHolder(View itemView) {
            super(itemView);

            bookimg = itemView.findViewById(R.id.bookimg);

            booktext = itemView.findViewById(R.id.booktext);
            booktext1 = itemView.findViewById(R.id.booktext1);


            ll1 = itemView.findViewById(R.id.ll1);


        }
    }
}

package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import e.wolfsoft1.liberty_ui_kit.R;
import model.NynewsModel;

public class NynewsAdapter extends RecyclerView.Adapter<NynewsAdapter.MyViewHolder> {
    Context context;

    public NynewsAdapter(Context context, ArrayList<NynewsModel> nynewsModelArrayList) {
        this.context = context;
        this.nynewsModelArrayList = nynewsModelArrayList;
    }

    private ArrayList<NynewsModel>nynewsModelArrayList;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_ny_news_recyclerview, parent, false);

        return new NynewsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        NynewsModel modelfoodrecycler = nynewsModelArrayList.get(position);


        holder.nyimg.setImageResource(modelfoodrecycler.getNyimg());
        holder.nyimg2.setImageResource(modelfoodrecycler.getNyimg2());
        holder.nytext1.setText(modelfoodrecycler.getNytext1());
        holder.nytext2.setText(modelfoodrecycler.getNytext2());

    }

    @Override
    public int getItemCount() {
        return nynewsModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView nyimg,nyimg2;
        TextView nytext1,nytext2;
        public MyViewHolder(View itemView) {
            super(itemView);

            nyimg = itemView.findViewById(R.id.nyimg);
            nyimg2 = itemView.findViewById(R.id.nyimg2);
            nytext1 = itemView.findViewById(R.id.nytext1);
            nytext2 = itemView.findViewById(R.id.nytext2);
        }
    }
}

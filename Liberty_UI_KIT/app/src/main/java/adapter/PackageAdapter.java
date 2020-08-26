package adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import e.wolfsoft1.liberty_ui_kit.R;
import model.PackageModel;

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.MyViewHolder> {
    Context context;
    boolean showingfirst = false;
    private ArrayList<PackageModel>packageModelArrayList;

    public PackageAdapter(Context context, ArrayList<PackageModel> packageModelArrayList) {
        this.context = context;
        this.packageModelArrayList = packageModelArrayList;
    }

    @NonNull
    @Override
    public PackageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expandable_package, parent, false);

        return new PackageAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PackageAdapter.MyViewHolder holder, int position) {

        PackageModel modelfoodrecycler = packageModelArrayList.get(position);

        holder.hide.setText(modelfoodrecycler.getHide());

        holder.hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showingfirst) {
                    holder.hide.setText("Details");
                    holder.hide.setTextSize(15);
                    holder.hide.setTextColor(Color.parseColor("#0091ea"));
                    showingfirst = false;
                } else {
                    holder.hide.setText("Hide");
                    holder.hide.setTextSize(15);
                    holder.hide.setTextColor(Color.parseColor("#0091ea"));
                    showingfirst = true;
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return packageModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView hide;
        public MyViewHolder(View itemView) {
            super(itemView);
            hide = itemView.findViewById(R.id.hide);
        }
    }
}

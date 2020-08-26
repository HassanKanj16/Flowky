//package adapter;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//import e.wolfsoft1.liberty_ui_kit.R;
//import model.ShoppingModel;
//
//public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.MyViewHolder> {
//    Context context;
//    private ArrayList<ShoppingModel> shoppingModelArrayList;
//
//    public ShoppingAdapter(Context context, ArrayList<ShoppingModel> shoppingModelArrayList) {
//        this.context = context;
//        this.shoppingModelArrayList = shoppingModelArrayList;
//    }
//
//    @NonNull
//    @Override
//    public ShoppingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.shopping_item, parent, false);
//
//        return new ShoppingAdapter.MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ShoppingAdapter.MyViewHolder holder, int position) {
//        ShoppingModel modelfoodrecycler = shoppingModelArrayList.get(position);
//
//
//        holder.shoppingimg.setImageResource(modelfoodrecycler.getShoppingimg());
//        holder.shoppingtext.setText(modelfoodrecycler.getShoppingtext());
//    }
//
//    @Override
//    public int getItemCount() {
//        return shoppingModelArrayList.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        ImageView shoppingimg;
//        TextView shoppingtext;
//        public MyViewHolder(View itemView) {
//            super(itemView);
//
//            shoppingimg = itemView.findViewById(R.id.shoppingimg);
//            shoppingtext = itemView.findViewById(R.id.shoppingtext);
//        }
//    }
//}

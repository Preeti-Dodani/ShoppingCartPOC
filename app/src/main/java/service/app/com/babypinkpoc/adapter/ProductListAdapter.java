package service.app.com.babypinkpoc.adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import service.app.com.babypinkpoc.ProductDetailsFragment;
import service.app.com.babypinkpoc.R;
import service.app.com.babypinkpoc.model.Record;

import static service.app.com.babypinkpoc.Util.AppUtil.mContext;

/**
 * Created by Gudiya on 27/04/2018.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    public List<Record> recordList;
    public static Context mContext;
    public LayoutInflater mLayoutInflater;
    public String final_url;
    public String BASE_URL = "http://static-data.surge.sh";

    public ProductListAdapter(Context context, List<Record> recordList) {

        this.recordList = recordList;
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.grid_view_item,parent,false);
        ViewHolder viewHolder1 = new ViewHolder(view);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ProductListAdapter.ViewHolder holder, int position) {
        final_url = BASE_URL + recordList.get(position).getProductImageUrl().replace("{product.id}",recordList.get(position).getProductId());
        holder.descpritionTextView.setText(recordList.get(position).getProductDescription());
        holder.finalPriceTextView.setText(recordList.get(position).getSkuFinalPrice());
        holder.lastPriceTextView.setText(recordList.get(position).getSkuLastPrice());
        if((recordList.get(position).getProductTag())!= null){
            holder.mtagTextView.setVisibility(View.VISIBLE);

            holder.mtagTextView.setText(recordList.get(position).getProductTag());

        }else{
            holder.mtagTextView.setVisibility(View.INVISIBLE);


        }

        Picasso.with(mContext).load(final_url).resize(100, 100).into(holder.mproductPhoto);
        holder.lastPriceTextView.setPaintFlags(holder.lastPriceTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }


    @Override
    public int getItemCount() {
        return recordList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        private TextView displayNameTextView, descpritionTextView, finalPriceTextView, lastPriceTextView,mtagTextView;
        private ImageView mproductPhoto;

        public ViewHolder(final View itemView) {
            super(itemView);

            descpritionTextView = (TextView)itemView.findViewById(R.id.product_description);
            finalPriceTextView = (TextView)itemView.findViewById(R.id.product_final_price);
            lastPriceTextView = (TextView)itemView.findViewById(R.id.product_last_price);
            mproductPhoto = (ImageView)itemView.findViewById(R.id.product_photo);
            mtagTextView = (TextView)itemView.findViewById(R.id.product_tag);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Bundle bundle = new Bundle();
                    bundle.putString("PROD_DESC",descpritionTextView.getText().toString());
                    bundle.putString("PROD_AMOUNT",finalPriceTextView.getText().toString());
                    bundle.putString("PROD_IMAGE",final_url);

                    android.support.v4.app.FragmentManager manager = ((FragmentActivity)mContext).getSupportFragmentManager();
                    ProductDetailsFragment detailFragment = new ProductDetailsFragment();
                    detailFragment.setArguments(bundle);
                    manager.beginTransaction().replace(R.id.container,detailFragment).commit();




//                    FragmentManager manager = ((Activity) mContext).getFragmentManager();
//                    ProductDetailsFragment detailFragment = new ProductDetailsFragment();
//                    detailFragment.setArguments(bundle);
//                    manager.beginTransaction().addToBackStack("FeaturedItemFragment.class").replace(R.id.container,detailFragment).commit();

                }
            });


        }
    }
}

package service.app.com.babypinkpoc.view;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import service.app.com.babypinkpoc.ProductDetailsFragment;
import service.app.com.babypinkpoc.ProductDetailsFragmentView;
import service.app.com.babypinkpoc.R;
import service.app.com.babypinkpoc.Util.AppUtil;
import service.app.com.babypinkpoc.counterlistner;

/**
 * Created by Gudiya on 29/04/2018.
 */

public class AddToCart extends Fragment  implements ProductDetailsFragmentView,View.OnClickListener,counterlistner
{
    private TabLayout tabLayout;
    private ToggleButton mToggleButton;
    private ViewPager viewPager;
    private  Context mContext;
    private counterlistner counterListner;
    private ImageView mImagePhoto;

    private ImageButton mbuttonIncrease,mbuttonDecrease;
    private TextView mTextViewcount,mtextViewProdDesc,mtextViewPrice;
    int prodcount = 0 ;
    public AddToCart() {
       // Toast.makeText(getActivity(),"AddToCart",Toast.LENGTH_SHORT).show();

        // Required empty public constructor
    }

    public static AddToCart newInstance(String param1, String param2) {
        AddToCart fragment = new AddToCart();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

          //  String parameter = getArguments().getString("parameter");
          //  Toast.makeText(getActivity(),"parameter"+parameter,Toast.LENGTH_SHORT).show();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_addto_cart, container, false);
        //mToggleButton = (ToggleButton)view.findViewById(R.id.);

        mtextViewProdDesc = (TextView)view.findViewById(R.id.prod_details_desc);
        mtextViewProdDesc.setText(AppUtil.Prod_desc);
        mtextViewPrice = (TextView)view.findViewById(R.id.prod_details_price);
        mtextViewPrice.setText(AppUtil.Prod_price);
      //  mImagePhoto = (ImageView)view.findViewById(R.id.imageView3);

        if(AppUtil.final_url_iamge !=null){

        }




        mbuttonDecrease =(ImageButton) view.findViewById(R.id.btn_descrese_count);
        mbuttonIncrease =(ImageButton) view.findViewById(R.id.btn_increase_count);
        mTextViewcount = (TextView)view.findViewById(R.id.display_count);
        mbuttonDecrease.setOnClickListener(this);
        mbuttonIncrease.setOnClickListener(this);

        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        try {
            counterListner = (counterlistner) mContext;
            counterListner.updateCounter(prodcount);
        } catch (ClassCastException e) {
            throw new ClassCastException(mContext.toString() + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void productdetailslistner(String s) {
    //    Toast.makeText(getActivity(),"s"+s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTrigger() {

    }

    @Override
    public void onClick(View view) {
        int v = view.getId();
        switch(v){
            case R.id.btn_increase_count:
                prodcount++;
                mTextViewcount.setText(String.valueOf(prodcount));
                counterListner.updateCounter(prodcount);
                break;

            case R.id.btn_descrese_count:
                prodcount--;
                if(prodcount < 0 ){
                    prodcount = 0 ;
                    mTextViewcount.setText(String.valueOf(prodcount));
                    counterListner.updateCounter(prodcount);
                }else{
                    mTextViewcount.setText(String.valueOf(prodcount));
                    counterListner.updateCounter(prodcount);
                }

                break;

        }

    }

    @Override
    public void updateCounter(int value) {
           //counterListner.updateCounter();
    }
}

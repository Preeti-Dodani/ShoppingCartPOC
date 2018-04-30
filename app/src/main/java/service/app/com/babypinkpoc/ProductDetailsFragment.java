package service.app.com.babypinkpoc;

import android.content.Context;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import service.app.com.babypinkpoc.Util.AppUtil;
import service.app.com.babypinkpoc.view.AddToCart;
import service.app.com.babypinkpoc.view.AddToCartView;


public class ProductDetailsFragment extends Fragment  {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    MyInterface mCallback;
    private final static String FRAGMENT_TAG = "FRAGMENTB_TAG"; // using uppercase since it's a constant


    private  String mProductDesc,mProductPrice,mProdUrl;

    public interface MyInterface {
        public void onTrigger();
    }


    public ProductDetailsFragment() {
        // Required empty public constructor
    }

    public static ProductDetailsFragment newInstance(String param1, String param2) {
       ProductDetailsFragment fragment = new ProductDetailsFragment();
        Bundle args = new Bundle();
             return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_details, container, false);
        Bundle b = getArguments();
        String tag = "android:switcher:" + R.id.viewpager + ":" + 1;

        if(b!=null){
            mProductDesc = b.getString("PROD_DESC");
            AppUtil.Prod_desc = mProductDesc;
         mProductPrice = b.getString("PROD_AMOUNT");
            AppUtil.Prod_price = mProductDesc;
              mProdUrl = b.getString("PROD_IMAGE");
            AppUtil.final_url_iamge= mProdUrl;
//            AddToCart f = (AddToCart)getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
//          String v ="preeti";
//        f.productdetailslistner(v);

        }
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new AddToCart(), "ADD TO CART");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

//    @Override
//    public void productdetailslistner(String s) {
////        String tag = "android:switcher:" + R.id.viewpager + ":" + 1;
////         AddToCart c =new AddToCart();
////        c
////        AddToCart f = (AddToCart)getFragmentManager().findFragmentByTag(tag);
////           String v ="preeti";
////        f.productdetailslistner(v);
//    }

    class ViewPagerAdapter extends FragmentPagerAdapter {


        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        public ViewPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }
          @Override
        public Fragment getItem(int position) {
//        String tag = "android:switcher:" + R.id.viewpager + ":" + 1;
//
//        AddToCart f = (AddToCart)getFragmentManager().findFragmentByTag(tag);
//           String v ="preeti";
//        f.productdetailslistner(v);
         return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
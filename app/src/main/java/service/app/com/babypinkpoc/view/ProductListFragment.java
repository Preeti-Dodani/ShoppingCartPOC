package service.app.com.babypinkpoc.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import service.app.com.babypinkpoc.CountriesActivity;
import service.app.com.babypinkpoc.MainActivity;
import service.app.com.babypinkpoc.ProductListInteractor;
import service.app.com.babypinkpoc.R;
import service.app.com.babypinkpoc.adapter.CategoryAdapter;
import service.app.com.babypinkpoc.adapter.CountryListAdapter;
import service.app.com.babypinkpoc.adapter.ProductListAdapter;
import service.app.com.babypinkpoc.model.CategoryData;
import service.app.com.babypinkpoc.model.Record;
import service.app.com.babypinkpoc.model.RecordsList;
import service.app.com.babypinkpoc.presenter.ProductListPresenter;
import service.app.com.babypinkpoc.presenter.ProductListPresenterImpl;
import service.app.com.babypinkpoc.presenter.countryPresenter;
import service.app.com.babypinkpoc.presenter.countryPresenterImpl;

import static service.app.com.babypinkpoc.Util.AppUtil.mContext;


public class ProductListFragment extends Fragment implements ProductListFragmentView {

    private RecyclerView mRecyclerView;
    private ProductListPresenter mProductListPresenter;
    private ArrayList<Record> mRecords = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context mContext;
    private Spinner mcategorySpinner;
    int flag= 0;
    private ArrayList<CategoryData> categoryDataArrayList = new ArrayList<>();




    public ProductListFragment() {
        // Required empty public constructor
    }

    public static ProductListFragment newInstance(String param1, String param2) {
        ProductListFragment fragment = new ProductListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        //Toast.makeText(getActivity(),"gfragmnet",Toast.LENGTH_SHORT).show();

        mProductListPresenter = new ProductListPresenterImpl(this);
        mProductListPresenter.fetchProductList(getActivity());
        mProductListPresenter.fetchCategoryList(getActivity());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_product_list, container, false);
       /// setHasOptionsMenu(true);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.product_recycle_view);
        mcategorySpinner = (Spinner)view.findViewById(R.id.product_category_spinner);
        return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hidePorogress() {

    }

    @Override
    public void loadProductList(ArrayList<Record> recordLists) {
        mLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ProductListAdapter(getActivity(),recordLists);
        mRecyclerView.setAdapter(mAdapter);

        //mAdapter.notifyDataSetChanged();
      //mRecords = recordLists;
        Log.d("call","call"+ mRecords);

         //Toast.makeText(getActivity(),"Data" + mRecords.size(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadCategoryData(ArrayList<CategoryData> categoryDatas) {

        categoryDataArrayList = categoryDatas;
        CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(), categoryDataArrayList);

        mcategorySpinner.setAdapter(categoryAdapter);
        mcategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            int id = adapterView.getId();
            int cat_id =  categoryDataArrayList.get(i).getId();
           // Toast.makeText(getActivity(),"call" + cat_id,Toast.LENGTH_SHORT).show();
            mProductListPresenter.fetchCategoryProduct(getActivity(),String.valueOf(cat_id));
            //mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }


    });
    }



    @Override
    public void notify(ArrayList<Record> recordLists) {

    }


}

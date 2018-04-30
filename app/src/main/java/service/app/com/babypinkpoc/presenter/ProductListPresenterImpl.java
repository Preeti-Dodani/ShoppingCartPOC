package service.app.com.babypinkpoc.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import service.app.com.babypinkpoc.CallBackListener;
import service.app.com.babypinkpoc.ProductInteractorImpl;
import service.app.com.babypinkpoc.ProductListInteractor;
import service.app.com.babypinkpoc.Util.AppUtil;
import service.app.com.babypinkpoc.countryInteractorImpl;
import service.app.com.babypinkpoc.model.CategoryData;
import service.app.com.babypinkpoc.model.CountryPojo;
import service.app.com.babypinkpoc.model.ProductList;
import service.app.com.babypinkpoc.model.Record;
import service.app.com.babypinkpoc.view.CountriesView;
import service.app.com.babypinkpoc.view.ProductListFragment;

import static service.app.com.babypinkpoc.Util.AppUtil.mContext;

/**
 * Created by Gudiya on 27/04/2018.
 */

public class ProductListPresenterImpl implements ProductListPresenter {

    private ProductListFragment mproductListFragment;
    private ProductListInteractor mProductListInteractor;


    public ProductListPresenterImpl(ProductListFragment productListFragment) {
        Log.d("countryPresenterImpl", "countryPresenterImpl");
        this.mproductListFragment = productListFragment;
         mProductListInteractor = new ProductInteractorImpl();
    }


    @Override
    public void fetchProductList(Context mcontext) {
        mProductListInteractor.callApiProductList(mcontext,new CallBackListener() {
            @Override
            public void onSuccess(Context context, Object data) {

                // Log.d("fetchProductList","fetchProductList" + data.toString());
                mproductListFragment.loadProductList((ArrayList<Record>) data);

            }

            @Override
            public void onFailure() {

            }
        });
    }

    @Override
    public void fetchCategoryList(Context mcontext) {
        mProductListInteractor.callApiProductCategoryList(mcontext,new CallBackListener() {
            @Override
            public void onSuccess(Context context, Object data) {

                // Log.d("fetchProductList","fetchProductList" + data.toString());
                mproductListFragment.loadCategoryData((ArrayList<CategoryData>) data);

            }

            @Override
            public void onFailure() {

            }
        });
    }

    @Override
    public void fetchCategoryProduct(Context mcontext, String category_id) {
       mProductListInteractor.callApiCategoryProductData(mcontext,category_id, new CallBackListener() {
           @Override
           public void onSuccess(Context context, Object data) {
               mproductListFragment.loadProductList((ArrayList<Record>) data);

           }

           @Override
           public void onFailure() {

           }
       });
    }


}

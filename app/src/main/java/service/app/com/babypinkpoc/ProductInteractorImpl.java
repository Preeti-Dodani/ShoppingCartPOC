package service.app.com.babypinkpoc;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.Query;
import service.app.com.babypinkpoc.model.ContentModel;
import service.app.com.babypinkpoc.model.ProductList;
import service.app.com.babypinkpoc.model.Record;
import service.app.com.babypinkpoc.model.RecordsList;
import service.app.com.babypinkpoc.network.api.RestClient;

/**
 * Created by Gudiya on 27/04/2018.
 */

public class ProductInteractorImpl implements ProductListInteractor {

    @Override
    public void callApiProductList(final Context mContext, final CallBackListener callBackListener) {
        RestClient.getmBmsApi().fetchProduct( new Callback<ProductList>() {

            @Override
            public void success(ProductList recordsList, Response response) {
               callBackListener.onSuccess(mContext,recordsList.getRecords().get(0).getAttributes().getRecords());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public void callApiProductCategoryList(final Context mContext, final  CallBackListener callBackListener) {
        RestClient.getmBmsApi().fetchCategory( new Callback<ContentModel>() {

            @Override
            public void success(ContentModel contentModel, Response response) {
                callBackListener.onSuccess(mContext,contentModel.getContents());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public void callApiCategoryProductData(final Context mContext, String cat,final CallBackListener callBackListener) {
        RestClient.getmBmsApi().fetchProductByCategory(cat,new Callback<ProductList>() {
            @Override
            public void success(ProductList recordsList, Response response) {
                String data = recordsList.getRecords().get(0).getAttributes().getRecords().get(0).getProductDescription();
                Toast.makeText(mContext,"size" + data,Toast.LENGTH_SHORT).show();
                callBackListener.onSuccess(mContext, recordsList.getRecords().get(0).getAttributes().getRecords());
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }
}

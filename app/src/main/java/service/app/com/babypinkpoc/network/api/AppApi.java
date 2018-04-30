package service.app.com.babypinkpoc.network.api;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.mime.MultipartTypedOutput;
import service.app.com.babypinkpoc.model.ContentModel;
import service.app.com.babypinkpoc.model.ProductList;
import service.app.com.babypinkpoc.model.Record;
import service.app.com.babypinkpoc.model.RecordsList;

/**
 * Created by Gudiya on 27/04/2018.
 */

public interface AppApi {
    @GET("/products/products.101")
    public void fetchProduct(Callback<ProductList> callback);

    @GET("/categories.json")
    public void fetchCategory(Callback<ContentModel> callback);

    @GET("/products/products.{id}.json")
    public void fetchProductByCategory(@Path("id") String cat_id, Callback<ProductList> callback);

}

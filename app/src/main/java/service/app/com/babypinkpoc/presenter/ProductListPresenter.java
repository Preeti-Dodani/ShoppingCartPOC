package service.app.com.babypinkpoc.presenter;

import android.content.Context;

/**
 * Created by Gudiya on 27/04/2018.
 */

public interface ProductListPresenter {
    public void fetchProductList(Context mcontext);
    public void fetchCategoryList(Context mcontext);
    public void fetchCategoryProduct(Context mcontext,String category_id);

}

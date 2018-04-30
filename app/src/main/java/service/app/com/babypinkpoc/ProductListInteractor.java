package service.app.com.babypinkpoc;

import android.content.Context;

/**
 * Created by Gudiya on 27/04/2018.
 */

public interface ProductListInteractor {

    public void callApiProductList(Context mContext,CallBackListener callBackListener);
    public void callApiProductCategoryList(Context mContext,CallBackListener callBackListener);
    public void callApiCategoryProductData(Context mContext,String id,CallBackListener callBackListener);

}

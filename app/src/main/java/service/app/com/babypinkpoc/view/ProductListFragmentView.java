package service.app.com.babypinkpoc.view;

import java.util.ArrayList;
import java.util.List;

import service.app.com.babypinkpoc.model.CategoryData;
import service.app.com.babypinkpoc.model.ProductList;
import service.app.com.babypinkpoc.model.Record;
import service.app.com.babypinkpoc.model.RecordsList;

/**
 * Created by Gudiya on 27/04/2018.
 */

public interface ProductListFragmentView {
    public void showProgress();
    public void hidePorogress();
    public void loadProductList(ArrayList<Record> recordLists);
    public void loadCategoryData(ArrayList<CategoryData> recordLists);
    public void notify(ArrayList<Record> recordLists);

}

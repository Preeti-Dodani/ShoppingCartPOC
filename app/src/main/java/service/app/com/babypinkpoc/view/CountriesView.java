package service.app.com.babypinkpoc.view;

import java.util.ArrayList;

import service.app.com.babypinkpoc.model.ContryModel;

/**
 * Created by Gudiya on 24/04/2018.
 */

public interface CountriesView {

    public void showSpinner();
    public void hideSpinner();

    public void getCountriesListData(ArrayList<ContryModel> data);
}

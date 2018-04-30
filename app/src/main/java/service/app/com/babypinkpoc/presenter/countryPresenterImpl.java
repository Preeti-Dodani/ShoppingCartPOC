package service.app.com.babypinkpoc.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;

import service.app.com.babypinkpoc.CallBackListener;
import service.app.com.babypinkpoc.MainActivity;
import service.app.com.babypinkpoc.countryInteractor;
import service.app.com.babypinkpoc.countryInteractorImpl;
import service.app.com.babypinkpoc.model.ContryModel;
import service.app.com.babypinkpoc.view.CountriesView;

/**
 * Created by Gudiya on 24/04/2018.
 */

public class countryPresenterImpl implements countryPresenter, countryInteractor.onCountryFinishedListener {

    CountriesView mCountriesView;
    countryInteractor mcountryInteractor;


    public countryPresenterImpl(CountriesView mcountriesView) {
        Log.d("countryPresenterImpl", "countryPresenterImpl");
        this.mCountriesView = mcountriesView;
        mcountryInteractor = new countryInteractorImpl();
    }


    @Override
    public void setCountryList(Context mcontext) {
        try {
            mcountryInteractor.fetchJSONCountries(mcontext,new CallBackListener() {
                @Override
                public void onSuccess(Context context, Object data) {
                    mCountriesView.getCountriesListData((ArrayList<ContryModel>) data);
               }

                @Override
                public void onFailure() {

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
 }

    @Override
    public void btnApply(Context mcontext) {
        Intent  i = new Intent(mcontext, MainActivity.class);
        mcontext.startActivity(i);
    }


    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure(String message) {

    }
}

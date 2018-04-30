package service.app.com.babypinkpoc;

import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import service.app.com.babypinkpoc.Util.AppUtil;
import service.app.com.babypinkpoc.model.ContryModel;
import service.app.com.babypinkpoc.model.CountryPojo;

/**
 * Created by Gudiya on 24/04/2018.
 */

public class countryInteractorImpl implements  countryInteractor{


    @Override
    public void fetchJSONCountries(Context mContext,CallBackListener callBackListener) throws JSONException {
        if(mContext != null){
            CountryPojo countryPojo = new Gson().fromJson(AppUtil.readJsonCountries(mContext), CountryPojo.class);
            if(countryPojo != null){
                callBackListener.onSuccess(mContext,countryPojo.getCountry());
            }

        }
  }
}

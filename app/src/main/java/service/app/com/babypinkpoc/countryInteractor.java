package service.app.com.babypinkpoc;

import android.content.Context;

import org.json.JSONException;

/**
 * Created by Gudiya on 24/04/2018.
 */

public interface countryInteractor {

    interface  onCountryFinishedListener{
        public void onSuccess();
        public void onFailure(String message);
    }

    public void fetchJSONCountries(Context mContext,CallBackListener callListener) throws JSONException;
}

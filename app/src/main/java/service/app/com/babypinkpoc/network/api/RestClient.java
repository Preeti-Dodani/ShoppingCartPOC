package service.app.com.babypinkpoc.network.api;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Gudiya on 27/04/2018.
 */

public class RestClient {

    private static String URL = "http://static-data.surge.sh//";
    private static AppApi mAppApi;
    public static AppApi getmBmsApi() {

        if(mAppApi==null){
            setupRestClient();
        }

        return mAppApi;
    }


    private static void setupRestClient() {
        OkHttpClient okClient = new OkHttpClient();

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(URL)


                .setClient(new OkClient(okClient))
                .setLogLevel(RestAdapter.LogLevel.FULL);

        RestAdapter restAdapter = builder.build();
        mAppApi = restAdapter.create(AppApi.class);
    }
}

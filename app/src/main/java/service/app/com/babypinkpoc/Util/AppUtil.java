package service.app.com.babypinkpoc.Util;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Gudiya on 23/04/2018.
 */

public class AppUtil {

    public static String Prod_desc ="prod_desc";
    public static String Prod_price ="prod_price";

    public static String final_url_iamge ="prod_image";

    public static Context mContext;
    public static String readJsonCountries(Context context){
        mContext = context;


        String json = null;
        try {
            InputStream is = mContext.getAssets().open("countries.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }



}

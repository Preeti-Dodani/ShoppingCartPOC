package service.app.com.babypinkpoc;

import android.content.Context;

/**
 * Created by Gudiya on 24/04/2018.
 */
public interface CallBackListener {
    public void onSuccess(Context context, Object data);
    public void onFailure();

}

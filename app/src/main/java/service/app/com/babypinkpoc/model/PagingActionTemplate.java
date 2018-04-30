package service.app.com.babypinkpoc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Gudiya on 27/04/2018.
 */

public class PagingActionTemplate {
    @SerializedName("label")
    @Expose
    private Object label;
    @SerializedName("navigationState")
    @Expose
    private String navigationState;

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public String getNavigationState() {
        return navigationState;
    }

    public void setNavigationState(String navigationState) {
        this.navigationState = navigationState;
    }
}

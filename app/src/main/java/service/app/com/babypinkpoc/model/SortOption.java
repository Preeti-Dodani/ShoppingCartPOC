package service.app.com.babypinkpoc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Gudiya on 27/04/2018.
 */

public class SortOption {
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("selected")
    @Expose
    private Boolean selected;
    @SerializedName("navigationState")
    @Expose
    private String navigationState;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getNavigationState() {
        return navigationState;
    }

    public void setNavigationState(String navigationState) {
        this.navigationState = navigationState;
    }
}

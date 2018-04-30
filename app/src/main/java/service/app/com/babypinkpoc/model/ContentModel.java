package service.app.com.babypinkpoc.model;

import android.icu.util.ULocale;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Gudiya on 28/04/2018.
 */

public class ContentModel {
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("@type")
    @Expose
    private String type;
    @SerializedName("contents")
    @Expose
    private List<CategoryData> contents = null;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CategoryData> getContents() {
        return contents;
    }

    public void setContents(List<CategoryData> contents) {
        this.contents = contents;
    }
}

package service.app.com.babypinkpoc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Gudiya on 27/04/2018.
 */

public class RecordsList {
    @SerializedName("numRecords")
    @Expose
    private Integer numRecords;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;

    public Integer getNumRecords() {
        return numRecords;
    }

    public void setNumRecords(Integer numRecords) {
        this.numRecords = numRecords;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

}

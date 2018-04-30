package service.app.com.babypinkpoc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gudiya on 24/04/2018.
 */

public class CountryPojo  {
    @SerializedName("country")
    @Expose
    private ArrayList<ContryModel> country = null;

    public ArrayList<ContryModel> getCountry() {
        return country;
    }

    public void setCountry(ArrayList<ContryModel> country) {
        this.country = country;
    }

}

package service.app.com.babypinkpoc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Gudiya on 24/04/2018.
 */

public class ContryModel implements Serializable {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("states")
    @Expose
    private ArrayList<String> states = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getStates() {
        return states;
    }

    public void setStates(ArrayList<String> states) {
        this.states = states;
    }


}

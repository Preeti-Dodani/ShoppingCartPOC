package service.app.com.babypinkpoc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Gudiya on 27/04/2018.
 */

public class Attributes {
    @SerializedName("Brand")
    @Expose
    private String brand;
    @SerializedName("sku.unit_of_measure")
    @Expose
    private String skuUnitOfMeasure;
    @SerializedName("records")
    @Expose
    private List<Record> records = null;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSkuUnitOfMeasure() {
        return skuUnitOfMeasure;
    }

    public void setSkuUnitOfMeasure(String skuUnitOfMeasure) {
        this.skuUnitOfMeasure = skuUnitOfMeasure;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}

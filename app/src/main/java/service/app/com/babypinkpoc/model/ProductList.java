package service.app.com.babypinkpoc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gudiya on 27/04/2018.
 */

public class ProductList  {

    @SerializedName("recsPerPage")
    @Expose
    private Integer recsPerPage;
    @SerializedName("totalNumRecs")
    @Expose
    private Integer totalNumRecs;
    @SerializedName("firstRecNum")
    @Expose
    private Integer firstRecNum;
    @SerializedName("lastRecNum")
    @Expose
    private Integer lastRecNum;
    @SerializedName("pagingActionTemplate")
    @Expose
    private PagingActionTemplate pagingActionTemplate;
    @SerializedName("sortOptions")
    @Expose
    private List<SortOption> sortOptions = null;
    @SerializedName("records")
    @Expose
    private ArrayList<RecordsList> records = null;

    public Integer getRecsPerPage() {
        return recsPerPage;
    }

    public void setRecsPerPage(Integer recsPerPage) {
        this.recsPerPage = recsPerPage;
    }

    public Integer getTotalNumRecs() {
        return totalNumRecs;
    }

    public void setTotalNumRecs(Integer totalNumRecs) {
        this.totalNumRecs = totalNumRecs;
    }

    public Integer getFirstRecNum() {
        return firstRecNum;
    }

    public void setFirstRecNum(Integer firstRecNum) {
        this.firstRecNum = firstRecNum;
    }

    public Integer getLastRecNum() {
        return lastRecNum;
    }

    public void setLastRecNum(Integer lastRecNum) {
        this.lastRecNum = lastRecNum;
    }

    public PagingActionTemplate getPagingActionTemplate() {
        return pagingActionTemplate;
    }

    public void setPagingActionTemplate(PagingActionTemplate pagingActionTemplate) {
        this.pagingActionTemplate = pagingActionTemplate;
    }

    public List<SortOption> getSortOptions() {
        return sortOptions;
    }

    public void setSortOptions(List<SortOption> sortOptions) {
        this.sortOptions = sortOptions;
    }

    public ArrayList<RecordsList> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<RecordsList> records) {
        this.records = records;
    }

}

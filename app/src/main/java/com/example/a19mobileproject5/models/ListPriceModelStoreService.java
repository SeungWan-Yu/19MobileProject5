
package com.example.a19mobileproject5.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListPriceModelStoreService {

    @SerializedName("list_total_count")
    @Expose
    private int listTotalCount;
    @SerializedName("RESULT")
    @Expose
    private RESULT rESULT;
    @SerializedName("row")
    @Expose
    private List<Row> row = null;

    public int getListTotalCount() {
        return listTotalCount;
    }

    public void setListTotalCount(int listTotalCount) {
        this.listTotalCount = listTotalCount;
    }

    public RESULT getRESULT() {
        return rESULT;
    }

    public void setRESULT(RESULT rESULT) {
        this.rESULT = rESULT;
    }

    public List<Row> getRow() {
        return row;
    }

    public void setRow(List<Row> row) {
        this.row = row;
    }

}

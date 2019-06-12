
package com.example.a19mobileproject5.models;


import com.google.gson.annotations.SerializedName;

public class StoresModels {

    @SerializedName("ListPriceModelStoreService")
    private ListPriceModelStoreService listPriceModelStoreService;

    public ListPriceModelStoreService getListPriceModelStoreService() {
        return listPriceModelStoreService;
    }

    public void setListPriceModelStoreService(ListPriceModelStoreService listPriceModelStoreService) {
        this.listPriceModelStoreService = listPriceModelStoreService;
    }

}

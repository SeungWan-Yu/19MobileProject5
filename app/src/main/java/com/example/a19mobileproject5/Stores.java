package com.example.a19mobileproject5;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Stores {
    public char getsHPHOTO;
    @SerializedName("ListPriceModelStoreService")
    @Expose
    ListPriceModelStoreService listPriceModelStoreService;
    private char sHNAME;
    private char sHINFO;

    public char getsHNAME() {
        return sHNAME;
    }

    public char getsHINFO() {
        return sHINFO;
    }

    public class ListPriceModelStoreService {

        @SerializedName("list_total_count")
        @Expose
        List_total_count listTotalCount;
        @SerializedName("RESULT")
        @Expose
        RESULT rESULT;
        @SerializedName("row")
        @Expose
        Row row;

        public class List_total_count {
            @SerializedName("listTotalCount")
            Integer listTotalCount;

            public Integer getListTotalCount() {
                return listTotalCount;
            }
        }

        public class RESULT {

            @SerializedName("CODE")
            @Expose
            String cODE;
            @SerializedName("MESSAGE")
            @Expose
            String mESSAGE;

            public String getmESSAGE() {
                return mESSAGE;
            }
        }

        public List<Row> Row = new ArrayList<>();
        public List<Row> getRow() {return Row;}

        public class Row {

            @SerializedName("SH_ID")
            @Expose
            String sHID;
            @SerializedName("SH_NAME")
            @Expose
            String sHNAME;
            @SerializedName("INDUTY_CODE_SE")
            @Expose
            String iNDUTYCODESE;
            @SerializedName("INDUTY_CODE_SE_NAME")
            @Expose
            String iNDUTYCODESENAME;
            @SerializedName("SH_ADDR")
            @Expose
            String sHADDR;
            @SerializedName("SH_PHONE")
            @Expose
            String sHPHONE;
            @SerializedName("SH_WAY")
            @Expose
            String sHWAY;
            @SerializedName("SH_INFO")
            @Expose
            String sHINFO;
            @SerializedName("SH_PRIDE")
            @Expose
            String sHPRIDE;
            @SerializedName("SH_RCMN")
            @Expose
            Double sHRCMN;
            @SerializedName("SH_PHOTO")
            @Expose
            String sHPHOTO;
            @SerializedName("BASE_YM")
            @Expose
            String bASEYM;

            public String getsHID() {
                return sHID;
            }

            public String getsHNAME() {
                return sHNAME;
            }

            public String getiNDUTYCODESE() {
                return iNDUTYCODESE;
            }

            public String getiNDUTYCODESENAME() {
                return iNDUTYCODESENAME;
            }

            public String getsHADDR() {
                return sHADDR;
            }

            public String getsHPHONE() {
                return sHPHONE;
            }

            public String getsHWAY() {
                return sHWAY;
            }

            public String getsHINFO() {
                return sHINFO;
            }

            public String getsHPRIDE() {
                return sHPRIDE;
            }

            public Double getsHRCMN() {
                return sHRCMN;
            }

            public String getsHPHOTO() {
                return sHPHOTO;
            }

            public String getbASEYM() {
                return bASEYM;
            }

            public Row getRow() {return row;}
        }
        public ListPriceModelStoreService getlistPriceModelStoreService(){return listPriceModelStoreService;}
    }
}

package com.example.a19mobileproject5.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Row {

    @SerializedName("SH_ID")
    @Expose
    private String sHID;
    @SerializedName("SH_NAME")
    @Expose
    private String sHNAME;
    @SerializedName("INDUTY_CODE_SE")
    @Expose
    private String iNDUTYCODESE;
    @SerializedName("INDUTY_CODE_SE_NAME")
    @Expose
    private String iNDUTYCODESENAME;
    @SerializedName("SH_ADDR")
    @Expose
    private String sHADDR;
    @SerializedName("SH_PHONE")
    @Expose
    private String sHPHONE;
    @SerializedName("SH_WAY")
    @Expose
    private String sHWAY;
    @SerializedName("SH_INFO")
    @Expose
    private String sHINFO;
    @SerializedName("SH_PRIDE")
    @Expose
    private String sHPRIDE;
    @SerializedName("SH_RCMN")
    @Expose
    private int sHRCMN;
    @SerializedName("SH_PHOTO")
    @Expose
    private String sHPHOTO;
    @SerializedName("BASE_YM")
    @Expose
    private String bASEYM;

    public String getSHID() {
        return sHID;
    }

    public void setSHID(String sHID) {
        this.sHID = sHID;
    }

    public String getSHNAME() {
        return sHNAME;
    }

    public void setSHNAME(String sHNAME) {
        this.sHNAME = sHNAME;
    }

    public String getINDUTYCODESE() {
        return iNDUTYCODESE;
    }

    public void setINDUTYCODESE(String iNDUTYCODESE) {
        this.iNDUTYCODESE = iNDUTYCODESE;
    }

    public String getINDUTYCODESENAME() {
        return iNDUTYCODESENAME;
    }

    public void setINDUTYCODESENAME(String iNDUTYCODESENAME) {
        this.iNDUTYCODESENAME = iNDUTYCODESENAME;
    }

    public String getSHADDR() {
        return sHADDR;
    }

    public void setSHADDR(String sHADDR) {
        this.sHADDR = sHADDR;
    }

    public String getSHPHONE() {
        return sHPHONE;
    }

    public void setSHPHONE(String sHPHONE) {
        this.sHPHONE = sHPHONE;
    }

    public String getSHWAY() {
        return sHWAY;
    }

    public void setSHWAY(String sHWAY) {
        this.sHWAY = sHWAY;
    }

    public String getSHINFO() {
        return sHINFO;
    }

    public void setSHINFO(String sHINFO) {
        this.sHINFO = sHINFO;
    }

    public String getSHPRIDE() {
        return sHPRIDE;
    }

    public void setSHPRIDE(String sHPRIDE) {
        this.sHPRIDE = sHPRIDE;
    }

    public int getSHRCMN() {
        return sHRCMN;
    }

    public void setSHRCMN(int sHRCMN) {
        this.sHRCMN = sHRCMN;
    }

    public String getSHPHOTO() {
        return sHPHOTO;
    }

    public void setSHPHOTO(String sHPHOTO) {
        this.sHPHOTO = sHPHOTO;
    }

    public String getBASEYM() {
        return bASEYM;
    }

    public void setBASEYM(String bASEYM) {
        this.bASEYM = bASEYM;
    }

}

package com.thedufresnegroup.adufres.betterdiagnostics;

public class TroubleCode {
    private String category;
    private String code;
    private String desc;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public TroubleCode(String category, String code, String desc) {
        this.category = category;
        this.code = code;
        this.desc = desc;
    }

    public TroubleCode() {}


}

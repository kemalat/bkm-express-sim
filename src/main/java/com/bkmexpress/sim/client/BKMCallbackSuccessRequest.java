package com.bkmexpress.sim.client;

import java.io.Serializable;

public class BKMCallbackSuccessRequest implements Serializable {

    private String t;
    private String posMessage;
    private String xid;
    private String md;
    private String ts;
    private String s;

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getPosMessage() {
        return posMessage;
    }

    public void setPosMessage(String posMessage) {
        this.posMessage = posMessage;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}

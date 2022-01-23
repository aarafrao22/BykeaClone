package com.aaraf.bykea;

public class RvModel {
    String Name, Url;

    public RvModel() {
    }

    public RvModel(String name, String url) {
        Name = name;
        Url = url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}

package com.example.a09_asyncservice.data.service;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ServiceResult {

    private Status status = new Status();
    private JsonObject data;
    private JsonArray dataArray;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }

    public JsonArray getDataArray() {
        return dataArray;
    }

    public void setDataArray(JsonArray dataArray) {
        this.dataArray = dataArray;
    }

    public class Status
    {
        int code;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        String value;
    }

    public enum Error {
        NoInternetConnection("İnternet Bağlantısı Yok", 0),
        UnknownError("Bilinmeyen Hata", 1),
        ServiceError("Servis Hatası", 2),
        ParseError("Parse Hatası", 3);

        private String stringValue;
        private int intValue;

        private Error(String toString, int value) {
            stringValue = toString;
            intValue = value;
        }

        @Override
        public String toString() {
            return stringValue;
        }

        public int toInt(){return intValue;}
    }
}


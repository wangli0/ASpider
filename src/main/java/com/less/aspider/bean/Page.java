package com.less.aspider.bean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by deeper on 2017/12/19.
 */

public class Page {

    private Request originRequest;

    private String url;

    private String refererUrl;

    private boolean skip;

    private Map<String, Object> fields;

    private boolean downloadSuccess;

    private List<Request> targetRequests = new ArrayList<Request>();

    private String rawText;

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public void setDownloadSuccess(boolean downloadSuccess) {
        this.downloadSuccess = downloadSuccess;
    }

    public boolean isDownloadSuccess() {
        return downloadSuccess;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public boolean isSkip() {
        return skip;
    }

    public void addTargetRequest(Request request) {
        if (null != request) {
            targetRequests.add(request);
        }
    }

    public void addTargetRequestsNoReferer(String ...urls) {
        for (String url : urls) {
            targetRequests.add(new Request(url));
        }
    }

    public void addTargetRequestsHasReferer(List<String> urls,String refererUrl) {
        for (String url : urls) {
            targetRequests.add(new Request(url,refererUrl));
        }
    }

    public List<Request> getTargetRequests() {
        return targetRequests;
    }

    public <T> T getField(String key) {
        Object o = fields.get(key);
        if (o == null) {
            return null;
        }
        return (T) fields.get(key);
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public <T> void putField(String key, T value) {
        if (fields == null) {
            fields = new LinkedHashMap<String, Object>();
        }
        fields.put(key, value);
    }

    public void setRawText(String text) {
        this.rawText = text;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRefererUrl(String refererUrl) {
        this.refererUrl = refererUrl;
    }

    public String getRefererUrl() {
        return refererUrl;
    }

    public Request getOriginRequest() {
        return originRequest;
    }

    public void setOriginRequest(Request originRequest) {
        this.originRequest = originRequest;
    }
}

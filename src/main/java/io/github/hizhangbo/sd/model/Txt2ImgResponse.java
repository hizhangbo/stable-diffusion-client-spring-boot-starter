package io.github.hizhangbo.sd.model;

import com.alibaba.fastjson2.JSONObject;

import java.util.List;

public class Txt2ImgResponse {
    private List<String> images;
    private JSONObject parameters;
    private JSONObject info;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public JSONObject getParameters() {
        return parameters;
    }

    public void setParameters(JSONObject parameters) {
        this.parameters = parameters;
    }

    public JSONObject getInfo() {
        return info;
    }

    public void setInfo(JSONObject info) {
        this.info = info;
    }
}

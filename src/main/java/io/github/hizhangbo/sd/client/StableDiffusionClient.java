package io.github.hizhangbo.sd.client;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONValidator;
import io.github.hizhangbo.sd.model.Estimation;
import io.github.hizhangbo.sd.model.ProgressResponse;
import io.github.hizhangbo.sd.model.SDModelItem;
import io.github.hizhangbo.sd.model.SamplerItem;
import io.github.hizhangbo.sd.property.StableDiffusionProperties;
import io.github.hizhangbo.sd.util.APIConst;
import io.github.hizhangbo.sd.util.HttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StableDiffusionClient {

    private final StableDiffusionProperties stableDiffusionProperties;

    public StableDiffusionClient(StableDiffusionProperties stableDiffusionProperties) {
        this.stableDiffusionProperties = stableDiffusionProperties;
    }

    public List<SamplerItem> getSampler() throws IOException {
        String response = HttpClient.doGet(stableDiffusionProperties.getServerUrl() + APIConst.GET_SAMPLERS);
        if (JSONValidator.from(response).validate()) {
            return JSONArray.parseArray(response, SamplerItem.class);
        }

        return new ArrayList<>();
    }

    public JSONObject getCmdFlags() throws IOException {
        String response = HttpClient.doGet(stableDiffusionProperties.getServerUrl() + APIConst.GET_CMD_FLAGS);
        if (JSONValidator.from(response).validate()) {
            return JSONObject.parseObject(response);
        }
        return new JSONObject();
    }

    public List<SDModelItem> getSdModels() throws IOException {
        String response = HttpClient.doGet(stableDiffusionProperties.getServerUrl() + APIConst.GET_SD_MODELS);
        if (JSONValidator.from(response).validate()) {
            return JSONArray.parseArray(response, SDModelItem.class);
        }
        return new ArrayList<>();
    }

    public Estimation getQueueStatus() throws IOException {
        String response = HttpClient.doGet(stableDiffusionProperties.getServerUrl() + APIConst.GET_QUEUE_STATUS);
        if (JSONValidator.from(response).validate()) {
            return JSONObject.parseObject(response, Estimation.class);
        }
        return null;
    }

    public ProgressResponse getProgressResponse() throws IOException {
        String response = HttpClient.doGet(stableDiffusionProperties.getServerUrl() + APIConst.GET_PROGRESS);
        if (JSONValidator.from(response).validate()) {
            return JSONObject.parseObject(response, ProgressResponse.class);
        }
        return null;
    }
}

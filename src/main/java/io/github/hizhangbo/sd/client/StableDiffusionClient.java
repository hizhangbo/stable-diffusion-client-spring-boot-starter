package io.github.hizhangbo.sd.client;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONValidator;
import io.github.hizhangbo.sd.model.*;
import io.github.hizhangbo.sd.util.APIConst;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StableDiffusionClient {

    private final HttpClient httpClient;

    public StableDiffusionClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public List<SamplerItem> getSampler() throws IOException {
        String response = httpClient.doGet(APIConst.GET_SAMPLERS);
        if (JSONValidator.from(response).validate()) {
            return JSONArray.parseArray(response, SamplerItem.class);
        }

        return new ArrayList<>();
    }

    public JSONObject getCmdFlags() throws IOException {
        String response = httpClient.doGet(APIConst.GET_CMD_FLAGS);
        if (JSONValidator.from(response).validate()) {
            return JSONObject.parseObject(response);
        }
        return new JSONObject();
    }

    public List<SDModelItem> getSdModels() throws IOException {
        String response = httpClient.doGet(APIConst.GET_SD_MODELS);
        if (JSONValidator.from(response).validate()) {
            return JSONArray.parseArray(response, SDModelItem.class);
        }
        return new ArrayList<>();
    }

    public ProgressResponse getProgressResponse() throws IOException {
        String response = httpClient.doGet(APIConst.GET_PROGRESS);
        if (JSONValidator.from(response).validate()) {
            return JSONObject.parseObject(response, ProgressResponse.class);
        }
        return null;
    }

    public String postOptions(Options options) throws IOException {
        String response = httpClient.doPost(APIConst.POST_OPTIONS, JSONObject.toJSONString(options));
        return response;
    }

    public Estimation getQueueStatus() throws IOException {
        String response = httpClient.doGet(APIConst.GET_QUEUE_STATUS);
        if (JSONValidator.from(response).validate()) {
            return JSONObject.parseObject(response, Estimation.class);
        }
        return null;
    }
}

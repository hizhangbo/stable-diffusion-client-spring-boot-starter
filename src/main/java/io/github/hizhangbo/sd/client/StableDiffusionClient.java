package io.github.hizhangbo.sd.client;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONValidator;
import io.github.hizhangbo.sd.model.*;
import io.github.hizhangbo.sd.util.APIConst;
import io.github.hizhangbo.sd.util.ImageUtil;
import org.apache.hc.core5.http.NoHttpResponseException;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public Options getOptions() throws IOException {
        String response = httpClient.doGet(APIConst.GET_OPTIONS);
        if (JSONValidator.from(response).validate()) {
            return JSONObject.parseObject(response, Options.class);
        }
        return null;
    }

    public String postOptions(Options options) throws IOException {
        String response = httpClient.doPost(APIConst.POST_OPTIONS, JSONObject.toJSONString(options));
        return response;
    }

    public List<File> postTxt2Img(Txt2ImgRequest request) throws IOException, InterruptedException {
        String response = "";
        try {
            response = httpClient.doPost(APIConst.POST_TXT2IMG, JSONObject.toJSONString(request));
        } catch (NoHttpResponseException e) {
            // 3秒后重试
            TimeUnit.SECONDS.sleep(3);
            response = httpClient.doPost(APIConst.POST_TXT2IMG, JSONObject.toJSONString(request));
        }
        final JSONObject jsonResponse = JSONObject.parseObject(response);

        List<File> result = new ArrayList<>();
        if (jsonResponse.containsKey("images")) {
            final JSONArray imageArray = jsonResponse.getJSONArray("images");

            if (!CollectionUtils.isEmpty(imageArray)) {
                for (Object o : imageArray) {
                    final String image = o.toString();
                    final File localImage = ImageUtil.base64ToWebP(image, httpClient.savePath);
                    result.add(localImage);
                }
            }
        }

        return result;
    }

    public Estimation getQueueStatus() throws IOException {
        String response = httpClient.doGet(APIConst.GET_QUEUE_STATUS);
        if (JSONValidator.from(response).validate()) {
            return JSONObject.parseObject(response, Estimation.class);
        }
        return null;
    }
}

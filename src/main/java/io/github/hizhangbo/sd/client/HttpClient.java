package io.github.hizhangbo.sd.client;

import io.github.hizhangbo.sd.property.StableDiffusionProperties;
import io.github.hizhangbo.sd.util.MediaTypeConst;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpClient {

    private final StableDiffusionProperties stableDiffusionProperties;
    private final String serverUrl;

    public HttpClient(StableDiffusionProperties stableDiffusionProperties) {
        this.stableDiffusionProperties = stableDiffusionProperties;
        serverUrl = stableDiffusionProperties.getServerUrl();
    }

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            // 连接超时
            .connectTimeout(10, TimeUnit.SECONDS)
            // 写入超时 请求体较大时，有可能触发
            .writeTimeout(10, TimeUnit.SECONDS)
            // 读取超时 服务端响应时间
            .readTimeout(10, TimeUnit.HOURS)
            .build();

    public String doGet(String api) throws IOException {
        Request request = new Request.Builder().url(serverUrl + api).build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }

    public String doPost(String api, String json) throws IOException {
        RequestBody jsonBody = RequestBody.create(MediaTypeConst.JSON, json);
        return createRequest(api, jsonBody);
    }

    public String doPost(String api, Map<String, String> paramsMap) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : paramsMap.keySet()) {
            builder.add(key, paramsMap.get(key));
        }
        RequestBody formBody = builder.build();
        return createRequest(api, formBody);
    }

    @NotNull
    private String createRequest(String api, RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(serverUrl + api)
                .post(body)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }
}

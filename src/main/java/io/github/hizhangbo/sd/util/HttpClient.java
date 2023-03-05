package io.github.hizhangbo.sd.util;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;

public class HttpClient {
    private static final OkHttpClient okHttpClient = new OkHttpClient();

    public static String doGet(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }

    public static String doPost(String url, String json) throws IOException {
        RequestBody jsonBody = RequestBody.create(json, MediaTypeConst.JSON);
        return createRequest(url, jsonBody);
    }

    public static String doPost(String url, Map<String, String> paramsMap) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : paramsMap.keySet()) {
            builder.add(key, paramsMap.get(key));
        }
        RequestBody formBody = builder.build();
        return createRequest(url, formBody);
    }

    @NotNull
    private static String createRequest(String url, RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(url)
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

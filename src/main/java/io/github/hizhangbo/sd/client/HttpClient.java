package io.github.hizhangbo.sd.client;

import io.github.hizhangbo.sd.property.StableDiffusionProperties;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.fluent.Executor;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.util.Timeout;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

public class HttpClient {

    private final StableDiffusionProperties stableDiffusionProperties;
    private final String serverUrl;
    public final String savePath;

    private final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(Timeout.ofSeconds(10))
            .setResponseTimeout(Timeout.ofHours(1))
            .build();

    private final CloseableHttpClient client = HttpClients.custom()
            .setDefaultRequestConfig(requestConfig)
            .build();

    private final Executor executor = Executor.newInstance(client);

    public HttpClient(StableDiffusionProperties stableDiffusionProperties) {
        this.stableDiffusionProperties = stableDiffusionProperties;
        serverUrl = stableDiffusionProperties.getServerUrl();
        savePath = stableDiffusionProperties.getSavePath();
    }

    public String doGet(String api) throws IOException {
        return executor
                .execute(setBasicAuthenticationHeader(Request.get(serverUrl + api)))
                .returnContent()
                .asString(StandardCharsets.UTF_8);
    }

    public String doPost(String api, String json) throws IOException {
        return executor
                .execute(setBasicAuthenticationHeader(Request.post(serverUrl + api).bodyString(json, ContentType.APPLICATION_JSON)))
                .returnContent()
                .asString(StandardCharsets.UTF_8);
    }

    public String doPost(String api, List<NameValuePair> params) throws IOException {
        final Form bodyForm = Form.form();
        for (NameValuePair param : params) {
            bodyForm.add(param.getName(), param.getValue());
        }

        return executor
                .execute(setBasicAuthenticationHeader(Request.post(serverUrl + api).bodyForm(bodyForm.build())))
                .returnContent()
                .asString(StandardCharsets.UTF_8);
    }

    private Request setBasicAuthenticationHeader(Request request) {
        if (stableDiffusionProperties.getAuth()) {
            String username = stableDiffusionProperties.getUsername();
            String password = stableDiffusionProperties.getPassword();

            String valueToEncode = username + ":" + password;
            String basicHeaderValue = "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
            request.setHeader("Authorization", basicHeaderValue);
        }
        return request;
    }
}

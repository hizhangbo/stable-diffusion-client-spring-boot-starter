package io.github.hizhangbo.sd.client;

import io.github.hizhangbo.sd.property.StableDiffusionProperties;
import io.github.hizhangbo.sd.util.APIConst;
import io.github.hizhangbo.sd.util.HttpClient;

import java.io.IOException;

public class StableDiffusionClient {

    private final StableDiffusionProperties stableDiffusionProperties;

    public StableDiffusionClient(StableDiffusionProperties stableDiffusionProperties) {
        this.stableDiffusionProperties = stableDiffusionProperties;
    }

    public String getSampler() throws IOException {
        return HttpClient.doGet(stableDiffusionProperties.getServerUrl() + APIConst.GET_SAMPLERS);
    }

    public String getCmdFlags() throws IOException {
        return HttpClient.doGet(stableDiffusionProperties.getServerUrl() + APIConst.GET_CMD_FLAGS);
    }

    public String getSdModels() throws IOException {
        return HttpClient.doGet(stableDiffusionProperties.getServerUrl() + APIConst.GET_SD_MODELS);
    }

    public String getQueueStatus() throws IOException {
        return HttpClient.doGet(stableDiffusionProperties.getServerUrl() + APIConst.GET_QUEUE_STATUS);
    }
}

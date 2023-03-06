package io.github.hizhangbo.sd.model;

/**
 * Example
 *   {
 *     "title": "v1-5-pruned-emaonly.safetensors [6ce0161689]",
 *     "model_name": "v1-5-pruned-emaonly",
 *     "hash": "6ce0161689",
 *     "sha256": "6ce0161689b3853acaa03779ec93eafe75a02f4ced659bee03f50797806fa2fa",
 *     "filename": "/home/larryzhang/stable-diffusion-webui/models/Stable-diffusion/v1-5-pruned-emaonly.safetensors",
 *     "config": null
 *   }
 */
public class SDModelItem {

    private String title;
    private String model_name;
    private String hash;
    private String sha256;
    private String filename;
    private String config;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}

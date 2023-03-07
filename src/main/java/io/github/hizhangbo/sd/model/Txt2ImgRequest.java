package io.github.hizhangbo.sd.model;

public class Txt2ImgRequest {
    private String prompt;
    private String negative_prompt;
    private Long seed = -1L;
    private String sampler_name;
    private String sampler_index;
    private Integer batch_size;
    private Integer steps;
    private Integer cfg_scale;
    private Integer width;
    private Integer height;
    private Boolean restore_faces;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getNegative_prompt() {
        return negative_prompt;
    }

    public void setNegative_prompt(String negative_prompt) {
        this.negative_prompt = negative_prompt;
    }

    public Long getSeed() {
        return seed;
    }

    public void setSeed(Long seed) {
        this.seed = seed;
    }

    public String getSampler_name() {
        return sampler_name;
    }

    public void setSampler_name(String sampler_name) {
        this.sampler_name = sampler_name;
    }

    public String getSampler_index() {
        return sampler_index;
    }

    public void setSampler_index(String sampler_index) {
        this.sampler_index = sampler_index;
    }

    public Integer getBatch_size() {
        return batch_size;
    }

    public void setBatch_size(Integer batch_size) {
        this.batch_size = batch_size;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Integer getCfg_scale() {
        return cfg_scale;
    }

    public void setCfg_scale(Integer cfg_scale) {
        this.cfg_scale = cfg_scale;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getRestore_faces() {
        return restore_faces;
    }

    public void setRestore_faces(Boolean restore_faces) {
        this.restore_faces = restore_faces;
    }
}

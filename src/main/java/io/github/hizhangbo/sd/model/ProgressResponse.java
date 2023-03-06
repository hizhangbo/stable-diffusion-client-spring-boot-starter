package io.github.hizhangbo.sd.model;

public class ProgressResponse {

    private Double progress;
    private Double eta_relative;
    private State state;
    private String current_image;
    private String textinfo;

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public Double getEta_relative() {
        return eta_relative;
    }

    public void setEta_relative(Double eta_relative) {
        this.eta_relative = eta_relative;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCurrent_image() {
        return current_image;
    }

    public void setCurrent_image(String current_image) {
        this.current_image = current_image;
    }

    public String getTextinfo() {
        return textinfo;
    }

    public void setTextinfo(String textinfo) {
        this.textinfo = textinfo;
    }

    public static class State {
        private Boolean skipped;
        private Boolean interrupted;
        private String job;
        private Integer job_count;
        private String job_timestamp;
        private Long job_no;
        private Integer sampling_step;
        private Integer sampling_steps;

        public Boolean getSkipped() {
            return skipped;
        }

        public void setSkipped(Boolean skipped) {
            this.skipped = skipped;
        }

        public Boolean getInterrupted() {
            return interrupted;
        }

        public void setInterrupted(Boolean interrupted) {
            this.interrupted = interrupted;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public Integer getJob_count() {
            return job_count;
        }

        public void setJob_count(Integer job_count) {
            this.job_count = job_count;
        }

        public String getJob_timestamp() {
            return job_timestamp;
        }

        public void setJob_timestamp(String job_timestamp) {
            this.job_timestamp = job_timestamp;
        }

        public Long getJob_no() {
            return job_no;
        }

        public void setJob_no(Long job_no) {
            this.job_no = job_no;
        }

        public Integer getSampling_step() {
            return sampling_step;
        }

        public void setSampling_step(Integer sampling_step) {
            this.sampling_step = sampling_step;
        }

        public Integer getSampling_steps() {
            return sampling_steps;
        }

        public void setSampling_steps(Integer sampling_steps) {
            this.sampling_steps = sampling_steps;
        }
    }

}

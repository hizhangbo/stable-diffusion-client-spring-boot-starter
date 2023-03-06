package io.github.hizhangbo.sd.model;

public class Estimation {

    private String msg;
    private String rank;
    private Integer queue_size;
    private Double avg_event_process_time;
    private Double avg_event_concurrent_process_time;
    private String rank_eta;
    private String queue_eta;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Integer getQueue_size() {
        return queue_size;
    }

    public void setQueue_size(Integer queue_size) {
        this.queue_size = queue_size;
    }

    public Double getAvg_event_process_time() {
        return avg_event_process_time;
    }

    public void setAvg_event_process_time(Double avg_event_process_time) {
        this.avg_event_process_time = avg_event_process_time;
    }

    public Double getAvg_event_concurrent_process_time() {
        return avg_event_concurrent_process_time;
    }

    public void setAvg_event_concurrent_process_time(Double avg_event_concurrent_process_time) {
        this.avg_event_concurrent_process_time = avg_event_concurrent_process_time;
    }

    public String getRank_eta() {
        return rank_eta;
    }

    public void setRank_eta(String rank_eta) {
        this.rank_eta = rank_eta;
    }

    public String getQueue_eta() {
        return queue_eta;
    }

    public void setQueue_eta(String queue_eta) {
        this.queue_eta = queue_eta;
    }
}

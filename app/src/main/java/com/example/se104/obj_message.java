package com.example.se104;

public class obj_message {
    private Integer type;
    private String content;
    private String time;

    public obj_message(Integer type, String content, String time) {
        this.type = type;
        this.content = content;
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

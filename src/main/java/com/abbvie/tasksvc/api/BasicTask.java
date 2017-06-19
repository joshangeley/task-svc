package com.abbvie.tasksvc.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class BasicTask {
    private long id;

    @Length(max = 3)
    private String content;

    public BasicTask() {
        // Jackson deserialization
    }

    public BasicTask(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}

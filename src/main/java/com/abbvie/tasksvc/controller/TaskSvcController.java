package com.abbvie.tasksvc.controller;

import com.codahale.metrics.annotation.Timed;
import com.abbvie.tasksvc.model.BasicTask;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
public class TaskSvcController {
    private final String template;
    private final String taskDescription;
    private final AtomicLong counter;

    public TaskSvcController(String template, String taskDescription) {
        this.template = template;
        this.taskDescription = taskDescription;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public BasicTask getTaskJSON(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(taskDescription));
        return new BasicTask(counter.incrementAndGet(), value);
    }
}

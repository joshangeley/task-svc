package com.abbvie.tasksvc.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path(value = "/health")
@Produces(MediaType.APPLICATION_JSON)
public class HealthCheckController {

    @GET
    public Map<String, Object> get() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "active");

        return map;
    }
}

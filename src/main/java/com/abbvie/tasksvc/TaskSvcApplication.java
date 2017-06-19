package com.abbvie.tasksvc;

import com.abbvie.tasksvc.controller.HealthCheckController;
import com.abbvie.tasksvc.controller.TaskSvcController;
import com.abbvie.tasksvc.health.TemplateHealthCheck;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by joshua.angeley on 6/19/17.
 */
public class TaskSvcApplication extends Application<TaskSvcConfiguration> {
    public static void main(String[] args) throws Exception {
        new TaskSvcApplication().run(args);
    }

    @Override
    public String getName() {
        return "task-svc application";
    }

    @Override
    public void initialize(Bootstrap<TaskSvcConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(TaskSvcConfiguration configuration,
                    Environment environment) {
        final TaskSvcController resource = new TaskSvcController("Description %s", "This is a task");
        final HealthCheckController health = new HealthCheckController();
        environment.jersey().register(resource);
        environment.jersey().register(health);
    }


}

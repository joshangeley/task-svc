package com.abbvie.tasksvc;

import com.abbvie.tasksvc.controller.TaskSvcResource;
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
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<TaskSvcConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(TaskSvcConfiguration configuration,
                    Environment environment) {
        final TaskSvcResource resource = new TaskSvcResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }


}

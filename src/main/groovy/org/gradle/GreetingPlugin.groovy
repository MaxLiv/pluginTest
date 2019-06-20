package org.gradle

import org.gradle.api.Project
import org.gradle.api.Plugin

class GreetingPlugin implements Plugin<Project> {
    void apply(Project project) {

        project.getExtensions().create('settings', Settings.class)
        project.getTasks().create("greet", GreetingTask.class)
        project.getTasks().create("getConfig", GetConfigTask.class)

    }
}


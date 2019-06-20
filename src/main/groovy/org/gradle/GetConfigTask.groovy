package org.gradle

import groovy.json.JsonSlurper
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GetConfigTask extends DefaultTask {

    @TaskAction
    def getConfig() {
        if (project.hasProperty("profile")) {
            def profile = project.property("profile")
            def jsonSlurper = new JsonSlurper()
            def path = project.extensions.settings.configDir + profile + '.json'
            println "Config for ${profile} in ${path}"
            project.extensions.settings.config = jsonSlurper.parseText(project.file(path).text)
        } else {
            println 'There is no such profile'
        }
    }
}

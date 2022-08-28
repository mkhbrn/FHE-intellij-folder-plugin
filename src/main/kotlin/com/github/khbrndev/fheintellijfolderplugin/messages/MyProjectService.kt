package com.github.khbrndev.fheintellijfolderplugin.messages

import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
        println(MyBundle.message("applicationService"))
    }
}

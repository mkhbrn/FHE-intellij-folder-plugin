package com.github.khbrndev.fheintellijfolderplugin.services

import com.github.khbrndev.fheintellijfolderplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}

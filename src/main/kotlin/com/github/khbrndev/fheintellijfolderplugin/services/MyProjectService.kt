package com.github.khbrndev.fheintellijfolderplugin.services

import com.intellij.openapi.project.Project
import com.github.khbrndev.fheintellijfolderplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}

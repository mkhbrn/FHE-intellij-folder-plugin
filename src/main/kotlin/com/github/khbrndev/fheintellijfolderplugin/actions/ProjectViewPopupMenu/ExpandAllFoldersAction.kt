package com.github.khbrndev.fheintellijfolderplugin.actions.ProjectViewPopupMenu

import com.github.khbrndev.fheintellijfolderplugin.Settings
import com.intellij.ide.projectView.ProjectView
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class ExpandAllFoldersAction : AnAction() {

    override fun actionPerformed(action: AnActionEvent) {
        Settings.isComposed = false

        if(action.project != null){
            ProjectView.getInstance(action.project!!).refresh()

        }

        println("action Performed by ${this.javaClass.name}")
    }

    override fun update(e: AnActionEvent) {
        super.update(e)

        println("Hello Update ${this.javaClass.name}")
    }
}
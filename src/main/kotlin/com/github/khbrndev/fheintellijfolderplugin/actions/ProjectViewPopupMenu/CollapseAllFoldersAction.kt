package com.github.khbrndev.fheintellijfolderplugin.actions.ProjectViewPopupMenu

import com.github.khbrndev.fheintellijfolderplugin.MyTreeStructureProvider
import com.github.khbrndev.fheintellijfolderplugin.Settings
import com.intellij.ide.projectView.ProjectView
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.jetbrains.rd.util.string.println

class CollapseAllFoldersAction : AnAction() {

    /**
     * do heavy lifting here
     * called when menu item is clicked
     */
    override fun actionPerformed(action: AnActionEvent) {
        Settings.isComposed = true
//        action.project?.projectFile?.refresh(false,true)


        if(action.project != null){
            ProjectView.getInstance(action.project!!).refresh()

        }
        println("action Performed by ${this.javaClass.name}")

    }

    /**
     * here only light operations
     * called each time the menu is opend
     */
    override fun update(e: AnActionEvent) {
        super.update(e)
        println("Hello Update ${this.javaClass.name}")
    }
}
package com.github.khbrndev.fheintellijfolderplugin.actions.ProjectViewPopupMenu

import com.github.khbrndev.fheintellijfolderplugin.Settings
import com.intellij.ide.projectView.ProjectView
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys

class ExpandAllFoldersAction : AnAction() {

    override fun actionPerformed(action: AnActionEvent) {
        if (action.project != null) {
            val element = action.getData(CommonDataKeys.VIRTUAL_FILE)
            element?.url?.let { url -> Settings.removeFolderFromFolderList(url) }
//            element?.url?.let { Settings.composedFolderList.remove(it) }
            ProjectView.getInstance(action.project!!).refresh()

        }

        println("action Performed by ${this.javaClass.name}")
    }

    override fun update(e: AnActionEvent) {
        super.update(e)

        println("Hello Update ${this.javaClass.name}")
    }
}
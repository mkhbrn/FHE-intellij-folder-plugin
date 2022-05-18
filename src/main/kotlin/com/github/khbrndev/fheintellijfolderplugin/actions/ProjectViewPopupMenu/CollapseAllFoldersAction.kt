package com.github.khbrndev.fheintellijfolderplugin.actions.ProjectViewPopupMenu

import com.github.khbrndev.fheintellijfolderplugin.Settings
import com.intellij.ide.projectView.ProjectView
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys

class CollapseAllFoldersAction : AnAction() {

    /**
     * do heavy lifting here
     * called when menu item is clicked
     */
    override fun actionPerformed(action: AnActionEvent) {
//        action.project?.projectFile?.refresh(false,true)
        val file = action.getData(CommonDataKeys.PSI_FILE)
//        val element = action.getData((CommonDataKeys.PSI_ELEMENT))
        val element = action.getData(CommonDataKeys.VIRTUAL_FILE)
        println("fileType = ${file?.fileType}")
        println("fileName = ${file?.name}")

        println("elementType = ${element?.canonicalFile?.name}")
        println("elementPath = ${element?.canonicalPath}")


        println("elementUrl = ${element?.url}")
        println("elementPath = ${element?.canonicalPath}")

        element?.url?.let { Settings.composedFolderList.add(it) }
        if (action.project != null) {
            ProjectView.getInstance(action.project!!).refresh()

        }
        println("action Performed by ${this.javaClass.name}")

    }

    /**
     * here only light operations
     * called each time the menu is opend
     */
    override fun update(action: AnActionEvent) {
        super.update(action)
        println("Hello Update ${this.javaClass.name}")
    }
}
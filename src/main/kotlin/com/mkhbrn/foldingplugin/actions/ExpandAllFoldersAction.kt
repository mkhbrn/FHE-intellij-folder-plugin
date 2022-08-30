package com.mkhbrn.foldingplugin.actions

import com.mkhbrn.foldingplugin.settings.SettingsState
import com.intellij.ide.projectView.ProjectView
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys

class ExpandAllFoldersAction : AnAction() {

    override fun actionPerformed(action: AnActionEvent) {
        if (action.project != null) {
            val element = action.getData(CommonDataKeys.VIRTUAL_FILE)


            element?.url?.let { SettingsState.getInstance().removeElementFromFoldedFolderList(it) }
//            element?.url?.let { url -> Settings.removeFolderFromFolderList(url) }
//            element?.url?.let { Settings.composedFolderList.remove(it) }

            ProjectView.getInstance(action.project!!).refresh()

        }

        println("action Performed by ${this.javaClass.name}")
    }

    override fun update(action: AnActionEvent) {
        super.update(action)

        val element = action.getData(CommonDataKeys.VIRTUAL_FILE)
        val fileIsNotAFolder: Boolean = action.getData(CommonDataKeys.PSI_FILE)?.fileType != null
        val fileIsInFoldedFolderList: Boolean =
            element?.url?.let { SettingsState.getInstance().foldedFolderListContains(it) } == true

        // only show menu item if it's a folder and not already in the folded folders list
        if (fileIsNotAFolder or !fileIsInFoldedFolderList) {
            action.presentation.isEnabled = false
        }
        println("Hello Update ${this.javaClass.name}")
    }
}
package com.mkhbrn.foldingplugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.mkhbrn.foldingplugin.Util
import com.mkhbrn.foldingplugin.settings.SettingsState

class CollapseAllFoldersAction : AnAction() {


    override fun actionPerformed(action: AnActionEvent) {
        val file = action.getData(CommonDataKeys.PSI_FILE)
        val element = action.getData(CommonDataKeys.VIRTUAL_FILE)
        println("fileType = ${file?.fileType}")
        println("fileName = ${file?.name}")

        println("elementType = ${element?.canonicalFile?.name}")
        println("elementPath = ${element?.canonicalPath}")

        println("elementUrl = ${element?.url}")
        println("elementPath = ${element?.canonicalPath}")


        element?.url?.let { SettingsState.getInstance().addElementToFoldedFolderList(it) }
        Util.refreshProjectView()

        println("action Performed by ${this.javaClass.name}")
    }


    override fun update(action: AnActionEvent) {
        super.update(action)

        val element = action.getData(CommonDataKeys.VIRTUAL_FILE)
        val fileIsNotAFolder: Boolean = action.getData(CommonDataKeys.PSI_FILE)?.fileType != null
        val fileIsInFoldedFolderList: Boolean =
            element?.url?.let { SettingsState.getInstance().foldedFolderListContains(it) } == true

        // only show menu item if it's a folder and not already in the folded folders list
        if (fileIsNotAFolder or fileIsInFoldedFolderList) {
            action.presentation.isEnabled = false
        }
        println("Hello Update ${this.javaClass.name}")
    }
}
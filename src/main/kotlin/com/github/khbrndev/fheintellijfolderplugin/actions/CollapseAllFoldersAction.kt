package com.github.khbrndev.fheintellijfolderplugin.actions

import com.github.khbrndev.fheintellijfolderplugin.Util
import com.github.khbrndev.fheintellijfolderplugin.settings.SettingsState
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


        element?.url?.let { SettingsState.getInstance().addElementToFoldedFolderList(it) }


//        element?.url?.let { url -> Settings.addFolderToList(url) }
//        element?.url?.let { Settings.composedFolderList.add(it) }

        Util.refreshProjectView()
        println("action Performed by ${this.javaClass.name}")

    }

    /**
     * here only light operations
     * called each time the menu is opend
     */
    // TODO: man darf nur auf Ordner klicken um das auszuführen
    //  nicht auf Dateien!
    override fun update(action: AnActionEvent) {
        super.update(action)
        val element = action.getData(CommonDataKeys.VIRTUAL_FILE)
        if (element?.url?.let { SettingsState.getInstance().foldedFolderListContains(it) } == true) {
            action.presentation.isEnabled = false
        }
        println("Hello Update ${this.javaClass.name}")
    }
}
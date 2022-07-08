package com.github.khbrndev.fheintellijfolderplugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys

class CollapseFileAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val element = e.getData(CommonDataKeys.VIRTUAL_FILE)
        println("Hello actionPerformed ${element?.url}")

    }

    override fun update(action: AnActionEvent) {
        super.update(action)

        val element = action.getData(CommonDataKeys.VIRTUAL_FILE)
        println("Hello Update ${element?.url}")
    }
}
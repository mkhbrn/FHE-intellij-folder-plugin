package com.github.khbrndev.fheintellijfolderplugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class MyProjectViewPopupMenuAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        println("action Performed")

    }

    override fun update(e: AnActionEvent) {
        super.update(e)
        println("Hello Update")
    }
}
package com.github.khbrndev.fheintellijfolderplugin.nodes

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.PsiFileNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile

class FoldingNode(project: Project?, value: PsiFile, viewSettings: ViewSettings?, private val presentedName: String) :
    PsiFileNode(
        project, value,
        viewSettings
    ) {

    /**
     * show custom name in file explorer
     * tab-layout name stays the same
     */
    override fun update(data: PresentationData) {
        super.update(data)
//        println("update called : $presentedName")
        data.presentableText = presentedName
    }
}
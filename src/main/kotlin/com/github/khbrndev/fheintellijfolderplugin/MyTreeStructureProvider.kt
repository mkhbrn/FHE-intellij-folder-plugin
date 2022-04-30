package com.github.khbrndev.fheintellijfolderplugin

import com.intellij.ide.projectView.TreeStructureProvider
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.PsiFileNode
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.fileTypes.PlainTextFileType
import com.jetbrains.rd.util.string.println
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

class MyTreeStructureProvider : TreeStructureProvider {


    @Nullable
    override fun getData(selected: MutableCollection<AbstractTreeNode<*>>, dataId: String): Any? {
        return null
    }

    override fun modify(
        parent: AbstractTreeNode<*>,
        children: MutableCollection<AbstractTreeNode<*>>,
        settings: ViewSettings?
    ): MutableCollection<AbstractTreeNode<*>> {

        val nodes = ArrayList<AbstractTreeNode<*>>()
        for (child in children) {
            if (child is PsiFileNode) {
                val file = child.virtualFile
                if(Settings.isComposed){
                    continue
                }
//                if (file != null && !file.isDirectory && file.fileType !is PlainTextFileType) {
//                    continue
//                }
                println("modify in TreeStructure called")
            }
            nodes.add(child)
        }
        return nodes
    }


}
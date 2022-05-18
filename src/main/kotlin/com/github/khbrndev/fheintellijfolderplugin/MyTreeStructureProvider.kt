package com.github.khbrndev.fheintellijfolderplugin

import com.intellij.ide.projectView.TreeStructureProvider
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.psi.PsiFile
import org.jetbrains.annotations.Nullable

class MyTreeStructureProvider : TreeStructureProvider {


    @Nullable
    override fun getData(selected: MutableCollection<AbstractTreeNode<*>>, dataId: String): Any? {
        return null
    }

    /**
     * goes through all files/folders from project to the lowest level/layer file
     *
     * expects all children of the current folder/file in return
     */
    override fun modify(
        parent: AbstractTreeNode<*>,
        children: MutableCollection<AbstractTreeNode<*>>,
        settings: ViewSettings?
    ): MutableCollection<AbstractTreeNode<*>> {
        println("MODIFY Called for ${parent.name} type = ${parent.value}")

        val project = Util.getCurrentProject()
        val nodes = ArrayList<AbstractTreeNode<*>>()
        for (child in children) {
            val nodeValue = child.value
            println("child = ${child.name} value = ${child.value}")
            if (nodeValue is PsiFile) {
                println("child ${child.name} is a PsiFile")
                val file = nodeValue.virtualFile
                // if file is in composed list -> dont show it
                var fileNameString = file?.url

                if (Settings.composedFolderList.contains(fileNameString)) {


                    println("FILE  ${fileNameString}is in composed folder")
                    val splitName = nodeValue.name.split("__")

                    val myFileNode = FileNode(project, nodeValue, settings, splitName[splitName.size - 1])
                    myFileNode.presentation.presentableText = splitName[splitName.size - 1]
                    println("FileName = ${myFileNode.presentation.presentableText}")

                    nodes.add(myFileNode)

                    println("modified file added")
                    continue

                }

            }
            nodes.add(child)
        }
        return nodes
    }


}
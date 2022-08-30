package com.mkhbrn.foldingplugin

import com.mkhbrn.foldingplugin.nodes.FoldingNode
import com.mkhbrn.foldingplugin.nodes.GroupNavigation
import com.mkhbrn.foldingplugin.nodes.GroupNode
import com.mkhbrn.foldingplugin.settings.SettingsState
import com.intellij.ide.projectView.TreeStructureProvider
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiFile
import org.jetbrains.annotations.Nullable

class MyTreeStructureProvider : TreeStructureProvider {


    override fun modify(
        parent: AbstractTreeNode<*>,
        children: Collection<AbstractTreeNode<*>>,
        viewSettings: ViewSettings
    ): Collection<AbstractTreeNode<*>> {
        println("parentName = " + parent.name)
        if (parent.value is PsiDirectory) {
            val directory = parent.value as PsiDirectory
            val path = directory.virtualFile.url
            println("Filename = $path")
//            if(Settings.composedFolderList.size != 0) {
//                println("SetingsElement = ${Settings.composedFolderList[0]}")
//            }
            //TODO: aktuell können nur ganze Ordner in die Liste eingetragen werden
            //  später soll das auch 1 oder Mehrstufig für einzelne Dateien/ alle mit dem gleichen prefix funktionieren
            if (SettingsState.getInstance().foldedFolderListContains(path) == true) {
                return createComposedFiles(path, children, viewSettings)
            }
        }
        return children
    }

    private fun createComposedFiles(
        directory: String,
        fileNodes: Collection<AbstractTreeNode<*>>,
        viewSettings: ViewSettings
    ): Collection<AbstractTreeNode<*>> {
        val result = LinkedHashMap<String, AbstractTreeNode<*>>()

        //guard clauses
        val project: Project? = Util.getCurrentProject()
        if (project == null) {
            //TODO -> sollte fileNodes sein?!
            return result.values
        }
        val delimiter: String = "__"
//            val maxFoldingDepth: Int = SettingConfigurable.getMaxFoldingDepth()

        for (node in fileNodes) {
            val nodeValue = node.value

            // current child is a folder
            if (nodeValue is PsiDirectory) {
                result[nodeValue.virtualFile.name] = node
                continue
            }

            // current child is a file
            if (nodeValue is PsiFile) {
                val psiFile = nodeValue
                val fileName = psiFile.name
//                    val nameArr: Array<String> = splitFileName(fileName, delimiter, maxFoldingDepth)
                val nameArr = fileName.split(this.getSeparator())

                // file has no delimiter
                if (nameArr.size == 1) {
                    result[fileName] = node
                    continue
                }

                // create root node
                var directoryNode = result[nameArr[0]] as GroupNode?
                if (directoryNode == null) {
                    directoryNode = GroupNode(
                        project, viewSettings, GroupNavigation(directory, nameArr[0]),
                        nameArr[0]
                    )
                    result[nameArr[0]] = directoryNode
                } else {

                    println("GroupNode was NOT null -> ${directoryNode.name}")
                }

                // create subgroup node
                val forLength = nameArr.size - 1
                for (i in 1 until forLength) {
                    println("nameArr = ${nameArr[i]}")
                    var childNode = directoryNode!!.getGroupChild(nameArr[i])
                    if (childNode == null) {
                        childNode = GroupNode(
                            project, viewSettings, GroupNavigation(
                                directory,
                                nameArr[i], directoryNode.value
                            ), nameArr[i]
                        )
                        directoryNode.addChild(childNode)
                    }
                    directoryNode = childNode
                }
                // create file node
                //println("current Added File = ${psiFile.name}")
                directoryNode!!.addChild(FoldingNode(project, psiFile, viewSettings, nameArr[nameArr.size - 1]))
            }

        }
        // might be deleted later
        return result.values
    }


    @Nullable
    override fun getData(selected: MutableCollection<AbstractTreeNode<*>>, dataId: String): Any? {
        return null
    }

    private fun getSeparator(): String {
        var separator = SettingsState.getInstance().getSeparators()
        if (separator == "") {
            separator = " "
        }
        return separator
    }


}
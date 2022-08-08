package com.github.khbrndev.fheintellijfolderplugin

import com.github.khbrndev.fheintellijfolderplugin.settings.SettingsState
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
            if (Settings.composedFolderListContains(path)) {
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

    fun getSeparator(): String {
        return SettingsState.getInstance().separators
    }


/*

    /**
     * goes through all files/folders from project to the lowest level/layer file
     *
     * @return all children of the current folder/file
     */
    override fun modify(
        parent: AbstractTreeNode<*>,
        children: MutableCollection<AbstractTreeNode<*>>,
        settings: ViewSettings?
    ): MutableCollection<AbstractTreeNode<*>> {
//        println("MODIFY Called for ${parent.name} type = ${parent.value}")

        if(parent.value !is PsiDirectory){
            return children
        }
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
                println("canonicalFile : ${file.canonicalFile}")
                println("canonicalPath : ${file.canonicalPath}")
                println("presentable url : ${file.presentableUrl}")
                println("presentable name : ${file.presentableName}")
                println("path : ${file.path}")
                println("project presentableurl : ${project?.presentableUrl}")
                println("project?.basePatho : ${project?.basePath}")
                println("project?.projectFilePath : ${project?.projectFilePath}")
                if (Settings.composedFolderList.contains(fileNameString)) {

                    println("nodeValue.name ${nodeValue.name}")
                    println("FILE  ${fileNameString}is in composed folder")
                    val splitName = nodeValue.name.split("__")

                    var directoryNode = GroupNode(project, settings, GroupNavigation(fileNameString!!,splitName[0]),splitName[0])
                    nodes.add(directoryNode)
                    for ((index, value) in splitName.withIndex()){
                        println("Im at Index:$index")
                        if(index == 0 || index == splitName.size){
                            continue
                        }
                        if(index == splitName.size -1){
                            val myFileNode = FoldingNode(project, nodeValue, settings, splitName[splitName.size - 1])
                            directoryNode.addChild(myFileNode)
                            myFileNode.presentation.presentableText = splitName[splitName.size - 1]
                            println("FileName = ${myFileNode.presentation.presentableText}")
                            continue
                        }

                        val childNode = GroupNode(project, settings, GroupNavigation(fileNameString,splitName[index]),splitName[index])
                        directoryNode.addChild(childNode)
                        directoryNode = childNode
                    }


//                    nodes.add(myFileNode)

                    println("modified file added")
                    continue

                }

            }
            nodes.add(child)
        }
        return nodes
    }


 */


}
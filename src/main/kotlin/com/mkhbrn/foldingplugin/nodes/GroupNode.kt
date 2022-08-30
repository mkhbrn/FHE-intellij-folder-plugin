package com.mkhbrn.foldingplugin.nodes

import com.google.common.base.CaseFormat
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.projectView.ProjectViewNode
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile


class GroupNode(project: Project?, viewSettings: ViewSettings?, value: GroupNavigation?, private val mName: String) :
    ProjectViewNode<GroupNavigation?>(project, value!!, viewSettings) {

    /**
     * make folder name camelCase if it contains 1 "_"
     */
    private val mDisplayName: String = if (!mName.contains("_")) mName else CaseFormat.LOWER_UNDERSCORE.to(
        CaseFormat.UPPER_CAMEL,
        mName
    )


    private val mChildNodeList: MutableMap<String?, AbstractTreeNode<*>> = LinkedHashMap()

    override fun getName(): String {
        return mName
    }

    private val displayName: String
        get() {
            val childNode = getSingleChildNodeOrNull()
            return if (childNode == null) mDisplayName else mDisplayName + "." + childNode.displayName
        }

    fun getGroupChild(name: String?): GroupNode? {
        if (name.isNullOrBlank()) {
            return null
        }
        if (mChildNodeList[name] == null) {
            return null
        }
        return mChildNodeList[name] as GroupNode
    }

    fun addChild(node: GroupNode) {
        mChildNodeList[node.name] = node
    }

    fun addChild(node: FoldingNode) {
        mChildNodeList[node.value.name] = node
    }

    /**
     * Should compact middle directories?
     */
    private fun getSingleChildNodeOrNull(): GroupNode? {
        if (mChildNodeList.size == 1) {
            val node = mChildNodeList.values.iterator().next()
            if (node is GroupNode) {
                return node
            }
        }
        return null
    }

    /**
     * childnodes contain file?
     */
    override fun contains(file: VirtualFile): Boolean {
        for (childNode in mChildNodeList.values) {
            val treeNode = childNode as ProjectViewNode<*>
            if (treeNode.contains(file)) {
                return true
            }
        }
        return false
    }

    override fun getChildren(): Collection<AbstractTreeNode<*>> {
        val childNode = getSingleChildNodeOrNull()
        return childNode?.children ?: mChildNodeList.values
    }

    /**
     * called each time the project structure is altered
     * (update UI)
     */
    override fun update(presentation: PresentationData) {
        presentation.presentableText = displayName
        presentation.setIcon(AllIcons.Nodes.Folder)
    }

}

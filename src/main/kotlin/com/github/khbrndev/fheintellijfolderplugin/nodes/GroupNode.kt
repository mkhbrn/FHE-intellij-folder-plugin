package com.github.khbrndev.fheintellijfolderplugin.nodes

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
    private val mDisplayName: String
    private val mChildNodeList: MutableMap<String?, AbstractTreeNode<*>> = LinkedHashMap()
    override fun getName(): String? {
        return mName
    }

    val displayName: String
        get() {
            val childNode = shouldCompactMiddleDirectories()
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

    private fun shouldCompactMiddleDirectories(): GroupNode? {
        if (mChildNodeList.size == 1) {
            val node = mChildNodeList.values.iterator().next()
            if (node is GroupNode) {
                return node
            }
        }
        return null
    }

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
        val childNode = shouldCompactMiddleDirectories()
        return childNode?.children ?: mChildNodeList.values
    }

    override fun update(presentation: PresentationData) {
        presentation.presentableText = displayName
        presentation.setIcon(AllIcons.Nodes.Folder)
    }

    init {
        // if name contains _, we display it as upper camel style, for example story_board -> StoryBoard
        // else just display it
        mDisplayName = if (!mName.contains("_")) mName else CaseFormat.LOWER_UNDERSCORE.to(
            CaseFormat.UPPER_CAMEL,
            mName
        )
    }
}

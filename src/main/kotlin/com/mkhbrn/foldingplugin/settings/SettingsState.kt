package com.mkhbrn.foldingplugin.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

/**
 * Persisted Storage that is saved in workspace between restarts
 *
 * is a Service/ serviceImplementation
 */
@State(
    name = "com.github.khbrndev.fheintellijfolderplugin.settings.SettingsState",
    storages = [Storage("FoldingPlugin.xml")]
)
class SettingsState : PersistentStateComponent<SettingsState.State> {


    class State {
        var separators: String = "__"

        var foldedFolderList: MutableSet<String> = mutableSetOf()
    }

    private var myState = State()

    override fun getState(): State? {
        return myState
    }

    override fun loadState(state: State) {
        myState = state
    }


    companion object {
        fun getInstance(): SettingsState {
            return ApplicationManager.getApplication().getService(SettingsState::class.java)
        }
    }


    fun addElementToFoldedFolderList(filepath: String) {
        if (this.getState()?.foldedFolderList?.contains(filepath) == true) {
            return
        }
        this.getState()?.foldedFolderList?.add(filepath)
    }

    fun removeElementFromFoldedFolderList(filePath: String) {
        this.getState()?.foldedFolderList?.remove(filePath)
    }

    fun foldedFolderListContains(filePath: String): Boolean? {
        return this.getState()?.foldedFolderList?.contains(filePath)
    }

    fun getSeparators(): String {
        return this.myState.separators
    }

    fun setSeparators(separators: String) {
        this.myState.separators = separators
    }

}
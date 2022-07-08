package com.github.khbrndev.fheintellijfolderplugin.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

/**
 * Persisted Storage that is saved in workspace between restarts
 */
@State(
    name = "com.github.khbrndev.fheintellijfolderplugin.settings.SettingsState",
    storages = [Storage("FoldingPlugin.xml")]
)
class SettingsState : PersistentStateComponent<SettingsState> {


    var separators: String = "__"

    var foldedFolders: List<String> = mutableListOf()


    companion object {
        fun getInstance(): SettingsState {
            return ApplicationManager.getApplication().getService(SettingsState::class.java)
        }
    }

    override fun getState(): SettingsState? {
        return this
    }

    override fun loadState(state: SettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }


}
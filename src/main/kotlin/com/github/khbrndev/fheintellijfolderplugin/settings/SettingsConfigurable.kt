package com.github.khbrndev.fheintellijfolderplugin.settings

import com.intellij.openapi.options.Configurable
import org.jetbrains.annotations.Nls
import javax.swing.JComponent

/**
 * Settings UI and Persistent Storage Controller
 */
class SettingsConfigurable : Configurable{

    private lateinit var mySettingsComponent: SettingsComponent

    // A default constructor with no arguments is required because this implementation
    // is registered as an applicationConfigurable EP
    @Nls(capitalization = Nls.Capitalization.Title)
    override fun getDisplayName():  String? {
        return "Khbrn - Folding"
    }

    override fun createComponent(): JComponent? {
        mySettingsComponent = SettingsComponent()
        return mySettingsComponent.getPanel()
    }

    override fun isModified(): Boolean {
        val settings = SettingsState.getInstance()
        var modified: Boolean = !mySettingsComponent.mySeparatorTextField.equals(settings.separators)
        return modified
    }

    override fun apply() {
        val settings = SettingsState.getInstance()
        settings.separators = mySettingsComponent.mySeparatorTextField.text
    }

    override fun reset() {
        val settings = SettingsState.getInstance()
        mySettingsComponent.mySeparatorTextField.text = settings.separators
    }

    override fun getHelpTopic(): String? {
        super.getHelpTopic()
        return "Hopefully this should help you, soon"
    }

}

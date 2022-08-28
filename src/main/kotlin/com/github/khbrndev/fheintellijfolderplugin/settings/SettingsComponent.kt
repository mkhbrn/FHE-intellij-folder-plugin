package com.github.khbrndev.fheintellijfolderplugin.settings

import com.intellij.ui.components.*
import com.intellij.util.ui.FormBuilder
import javax.swing.JPanel

/**
 * UI and Input fields of Settigns Page
 */
class SettingsComponent {

    private val myMainPanel: JPanel

    private val separatorTextField = JBTextField("")
    private val separatorLabel = JBLabel("Enter Separator: ")


    init {
        myMainPanel = FormBuilder()
            .addLabeledComponent(separatorLabel, separatorTextField, 1, false)
            .addTooltip("Please only enter one separator")
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    fun getPanel(): JPanel? {
        return myMainPanel
    }

}
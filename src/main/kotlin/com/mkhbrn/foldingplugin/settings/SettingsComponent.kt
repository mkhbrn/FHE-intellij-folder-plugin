package com.mkhbrn.foldingplugin.settings

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JPanel

/**
 * UI and Input fields of Settigns Page
 */
class SettingsComponent {

    private val myMainPanel: JPanel

    val separatorTextField = JBTextField("")
    val separatorLabel = JBLabel("Enter Separator: ")


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
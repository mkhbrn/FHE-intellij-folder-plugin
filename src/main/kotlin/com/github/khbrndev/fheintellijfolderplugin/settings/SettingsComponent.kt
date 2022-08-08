package com.github.khbrndev.fheintellijfolderplugin.settings

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JPanel

/**
 * UI and Input fields of Settigns Page
 */
class SettingsComponent {

    private val myMainPanel: JPanel

    val mySeparatorTextField = JBTextField()

    init {
        myMainPanel = FormBuilder()
            .addLabeledComponent(JBLabel("Enter Separator: "), mySeparatorTextField,1, false)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    fun getPanel(): JPanel? {
        return myMainPanel
    }

}
package com.github.khbrndev.fheintellijfolderplugin.settings

import com.intellij.openapi.ui.JBMenuItem
import com.intellij.openapi.ui.JBPopupMenu
import com.intellij.ui.components.JBBox
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBCheckBoxMenuItem
import com.intellij.ui.components.JBComboBoxLabel
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBLabelDecorator
import com.intellij.ui.components.JBLayeredPane
import com.intellij.ui.components.JBList
import com.intellij.ui.components.JBLoadingPanel
import com.intellij.ui.components.JBMenu
import com.intellij.ui.components.JBPasswordField
import com.intellij.ui.components.JBRadioButton
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.components.JBTabbedPane
import com.intellij.ui.components.JBTextArea
import com.intellij.ui.components.JBTextField
import com.intellij.ui.components.JBTreeTable
import com.intellij.ui.components.JBViewport
import com.intellij.ui.tabs.impl.JBTabsImpl
import com.intellij.util.text.JBDateFormat
import com.intellij.util.ui.FormBuilder
import com.intellij.util.ui.JBCachingScalableIcon
import com.intellij.util.ui.JBDimension
import com.intellij.util.ui.JBEmptyBorder
import com.intellij.util.ui.JBFont
import com.intellij.util.ui.JBHtmlEditorKit
import com.intellij.util.ui.JBImageIcon
import com.intellij.util.ui.JBInsets
import com.intellij.util.ui.JBPoint
import com.intellij.util.ui.JBRectangle
import java.awt.Color
import javax.swing.JButton
import javax.swing.JComponent
import javax.swing.JPanel

/**
 * UI and Input fields of Settigns Page
 */
class SettingsComponent {

    private val myMainPanel: JPanel

    val mySeparatorTextField = JBTextField("")
    val jbLabel = JBLabel("Label Text")
    val jbButton = JButton("Button Text")
    val jbCheckBox = JBCheckBox("CheckBox Text",true)
    val jbCheckBoxMenuItem = JBCheckBoxMenuItem()
    val jbPasswordField = JBPasswordField()
    val jbRadioButton1 = JBRadioButton("Radio1")
    val jbRadioButton2 = JBRadioButton("Radio2")
    val jbTextArea = JBTextArea()

    init {
        myMainPanel = FormBuilder()
            .addLabeledComponent(JBLabel("Enter Separator: "), mySeparatorTextField,1, false)
            .addTooltip("Separator cannot be empty!")
            .addComponent(jbLabel)
            .addComponent(jbButton)
            .addComponent(jbCheckBox)
            .addComponent(jbCheckBoxMenuItem)
            .addComponent(jbPasswordField)
            .addComponent(jbRadioButton1)
            .addComponent(jbRadioButton2)
            .addComponent(jbTextArea)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    fun getPanel(): JPanel? {
        return myMainPanel
    }

}
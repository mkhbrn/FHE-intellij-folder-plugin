package com.github.khbrndev.fheintellijfolderplugin

class GroupNavigation @JvmOverloads constructor(
    var directory: String,
    private val prefix: String,
    private val parent: GroupNavigation? = null
) {

}
package com.github.khbrndev.fheintellijfolderplugin.nodes

class GroupNavigation @JvmOverloads constructor(
    var directory: String,
    private val prefix: String,
    private val parent: GroupNavigation? = null
) {

}
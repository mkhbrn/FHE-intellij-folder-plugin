package com.github.khbrndev.fheintellijfolderplugin

class Settings {

    companion object {
        private val composedFolderList = mutableListOf<String>()

        fun addFolderToList(folderString: String){
            if(this.composedFolderList.contains(folderString)){
                return
            }
            this.composedFolderList.add(folderString)
        }

        fun removeFolderFromFolderList(folderString: String){
            this.composedFolderList.remove(folderString)
        }

        fun composedFolderListContains(folderString: String): Boolean{
            return this.composedFolderList.contains(folderString)
        }
    }


}
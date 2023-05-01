package com.github.kakiageseiro.stringhighlighter

import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.FileEditorManagerEvent
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.vfs.VirtualFile

class FileOpenEventListener : FileEditorManagerListener {
    override fun fileOpened(source: FileEditorManager, file: VirtualFile) {
        // ファイルが開かれたときの処理
        source.selectedTextEditor?.let { StringHighlighter().run(it) }
    }

    override fun fileClosed(source: FileEditorManager, file: VirtualFile) {
        // ファイルが閉じられたとき用
    }

    override fun selectionChanged(event: FileEditorManagerEvent) {
        // ファイルエディタの選択されたとき用
    }
}

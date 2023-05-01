package com.github.kakiageseiro.stringhighlighter

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.markup.HighlighterLayer
import com.intellij.openapi.editor.markup.HighlighterTargetArea
import com.intellij.openapi.editor.markup.RangeHighlighter
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.ui.JBColor

class StringHighlighter {
    fun run(editor: Editor) {
        // 現在開いているエディタのドキュメントという概念から、特定の文字列を探す
        val document: Document? = editor?.let { editor -> editor.document }
        val text = document!!.text
        val target = "example"
        val index = text.indexOf(target)
        if (index < 0) {
            println("なにもなかった")
            return
        } // 見つからなかったら何もしない

        // 色を返るためのマークアップモデルという概念を取得する
        val markupModel = editor.markupModel

        // 背景色を黄色にする属性を作る
        val attributes: TextAttributes = TextAttributes()
        attributes.backgroundColor = JBColor.YELLOW

        // マークアップモデルの中にある特定の文字列をハイライトする
        val highlighter: RangeHighlighter = markupModel.addRangeHighlighter(
                index, index + target.length, HighlighterLayer.SELECTION - 1, attributes,
                HighlighterTargetArea.EXACT_RANGE)
    }
}

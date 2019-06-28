package ru.s4nchez.liblint.java

import com.android.tools.lint.detector.api.*

class JavaIssue {

    companion object {
        val correctClickListenerImplementation = Implementation(CorrectClickListenerDetector::class.java, Scope.JAVA_FILE_SCOPE)

        val ISSUE_CLICK_LISTENER = Issue.create(
            id = "UnsafeClickListener",
            briefDescription = "Unsafe click listener",
            explanation = """"
        This check ensures you call click listener that is throttled
        instead of a normal one which does not prevent double clicks.
        """.trimIndent(),
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = correctClickListenerImplementation
        )
    }
}
package ru.s4nchez.liblint.java

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue
import ru.s4nchez.liblint.java.JavaIssue.Companion.ISSUE_CLICK_LISTENER

class MyIssueRegistry : IssueRegistry() {

    override val issues: List<Issue> = listOf(ISSUE_CLICK_LISTENER)
}
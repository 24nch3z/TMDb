package ru.s4nchez.liblint.presenter;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class PresenterUnbindMissingRegistry extends IssueRegistry {

    @NotNull
    @Override
    public List<Issue> getIssues() {
        return Arrays.asList(PresenterUnbindMissingIssue.ISSUE);
    }
}

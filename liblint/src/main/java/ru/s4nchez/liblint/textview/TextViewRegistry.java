package ru.s4nchez.liblint.textview;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class TextViewRegistry extends IssueRegistry {

    static final String EXPLANATION = "TextView ISSUE explanation";

    @NotNull
    @Override
    public List<Issue> getIssues() {
        return Arrays.asList(ISSUE);
    }

    public static final Issue ISSUE = Issue.create(
            "TextViewIssueee",
            "TextView ISSUE description",
            "TextView ISSUE explanation",
            Category.TYPOGRAPHY,
            4,
            Severity.WARNING,
            new Implementation(
                    TextViewDetector.class,
                    Scope.RESOURCE_FILE_SCOPE)
    );
}

package ru.s4nchez.liblint.button;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class ButtonRegistry extends IssueRegistry {

    static final String EXPLANATION = "Button ISSUE explanation";

    @NotNull
    @Override
    public List<Issue> getIssues() {
        return Arrays.asList(ISSUE);
    }

    public static final Issue ISSUE = Issue.create(
            "ButtonIssueee",
            "Button ISSUE description",
            "Button ISSUE explanation",
            Category.TYPOGRAPHY,
            5,
            Severity.WARNING,
            new Implementation(
                    ButtonDetector.class,
                    Scope.RESOURCE_FILE_SCOPE)
    );
}

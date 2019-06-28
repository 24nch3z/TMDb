package ru.s4nchez.liblint.presenter;

import com.android.tools.lint.detector.api.*;

public class PresenterUnbindMissingIssue {

    static final String ID = "PresenterUnbindMissingIssue";
    static final String DESCRIPTION = "Отсутствует отписка презентера";
    static final String EXPLANATION = "Братец, тебе было бы неплохо прописать presenter.unbind(), смекаешь?";
    static final Category CATEGORY = Category.TYPOGRAPHY;
    static final int PRIORITY = 5;
    static final Severity SEVERITY = Severity.WARNING;

    public static final Issue ISSUE = Issue.create(
            ID,
            DESCRIPTION,
            EXPLANATION,
            CATEGORY,
            PRIORITY,
            SEVERITY,
            new Implementation(
                    PresenterUnbindMissingDetector.class,
                    Scope.ALL)
    );
}

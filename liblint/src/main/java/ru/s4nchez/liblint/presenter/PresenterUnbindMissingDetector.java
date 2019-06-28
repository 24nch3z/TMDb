package ru.s4nchez.liblint.presenter;

import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Detector.UastScanner;
import com.android.tools.lint.detector.api.JavaContext;
import com.intellij.psi.*;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class PresenterUnbindMissingDetector extends Detector implements UastScanner {

    @Nullable
    @Override
    public List<String> getApplicableMethodNames() {
        return Collections.singletonList("ew");
    }

//    @Nullable
//    @Override
//    public List<String> getApplicableReferenceNames() {
//        return Collections.singletonList("ew");
//    }

//    @Override
//    public void visitReference(@NotNull JavaContext context, @Nullable JavaElementVisitor visitor, @NotNull PsiJavaCodeReferenceElement reference, @NotNull PsiElement referenced) {
//        context.report(
//                PresenterUnbindMissingIssue.ISSUE,
//                context.getLocation(referenced),
//                PresenterUnbindMissingIssue.EXPLANATION
//        );
//    }

    @Override
    public void visitMethod(@NotNull JavaContext context, @Nullable JavaElementVisitor visitor, @NotNull PsiMethodCallExpression call, @NotNull PsiMethod method) {
        context.report(
                PresenterUnbindMissingIssue.ISSUE,
                context.getLocation(method),
                PresenterUnbindMissingIssue.EXPLANATION
        );
    }
}

package ru.s4nchez.liblint.button;

import com.android.annotations.Nullable;
import com.android.tools.lint.detector.api.ResourceXmlDetector;
import com.android.tools.lint.detector.api.XmlContext;

import org.w3c.dom.Element;

import java.util.Collection;
import java.util.Collections;

public class ButtonDetector extends ResourceXmlDetector {

    static final String BUTTON = "Button";

    @Nullable
    @Override
    public Collection<String> getApplicableElements() {
        return Collections.singletonList(BUTTON);
    }

    @Override
    public void visitElement(XmlContext context, Element element) {
        context.report(
                ButtonRegistry.ISSUE,
                context.getLocation(element),
                ButtonRegistry.EXPLANATION);
    }
}

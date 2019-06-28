package ru.s4nchez.liblint.textview;

import com.android.annotations.Nullable;
import com.android.tools.lint.detector.api.ResourceXmlDetector;
import com.android.tools.lint.detector.api.XmlContext;

import org.w3c.dom.Element;

import java.util.Collection;
import java.util.Collections;

public class TextViewDetector extends ResourceXmlDetector {

    static final String SCHEMA = "http://schemas.android.com/apk/res/android";
    static final String TEXT_APPEARANCE = "textAppearance";
    static final String TEXTVIEW = "TextView";

    @Nullable
    @Override
    public Collection<String> getApplicableElements() {
        return Collections.singletonList(TEXTVIEW);
    }

    @Override
    public void visitElement(XmlContext context, Element element) {
//        if (!element.hasAttributeNS(SCHEMA, TEXT_APPEARANCE)) {
        context.report(
                TextViewRegistry.ISSUE,
                context.getLocation(element),
                TextViewRegistry.EXPLANATION);
//        }
    }
}

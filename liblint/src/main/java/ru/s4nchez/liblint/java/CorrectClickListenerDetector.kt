package ru.s4nchez.liblint.java

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.LintFix
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UField
import org.jetbrains.uast.getContainingUMethod
import org.jetbrains.uast.getUCallExpression
import ru.s4nchez.liblint.java.JavaIssue.Companion.ISSUE_CLICK_LISTENER
import java.lang.Exception

private const val REPORT_MESSAGE = "Use setThrottlingClickListener"

class CorrectClickListenerDetector : Detector(), Detector.UastScanner {

//    override fun getApplicableUastTypes(): List<Class<out UElement>>? {
//        return listOf<Class<out UElement>>(UCallExpression::class.java)
//    }

    override fun getApplicableUastTypes(): List<Class<out UElement>>? {
        return listOf<Class<out UElement>>(UField::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler? {
        return object : UElementHandler() {

            override fun visitField(node: UField) {
//                if (call?.methodName == "removeView") {
//                    context.report(ISSUE_CLICK_LISTENER, node, context.getLocation(node), REPORT_MESSAGE)
//                }

                val name = node.name
                if (name == "presenter") {
                    context.report(ISSUE_CLICK_LISTENER, node, context.getLocation(node), REPORT_MESSAGE)
                }

//                try {
////                    context.report(ISSUE_CLICK_LISTENER, node, context.getLocation(node), context.)
//                } catch (e: Exception) {
//                    context.report(ISSUE_CLICK_LISTENER, node, context.getLocation(node), e.toString())
//                }
            }

//            override fun visitCallExpression(node: UCallExpression) {
//                context.report(ISSUE_CLICK_LISTENER, node, context.getLocation(node), REPORT_MESSAGE, createFix())
//            }

//            override fun visitCallExpression(node: UCallExpression) {
//                if (node.methodName != null && node.methodName?.equals("setOnClickListener", ignoreCase = true) == true) {
//                    context.report(ISSUE_CLICK_LISTENER, node, context.getLocation(node), REPORT_MESSAGE, createFix())
//                }
//            }
        }
    }

//    private fun createFix(): LintFix {
//        return fix().replace().text("setOnClickListener").with("setThrottlingClickListener").build()
//    }
}
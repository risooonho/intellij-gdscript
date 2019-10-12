package script.completion

import GodotApi
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.PlatformIcons.FUNCTION_ICON
import com.intellij.util.ProcessingContext
import script.psi.elements.InvokePsiElement
import script.psi.elements.ValuePsiElement


class FunctionCallCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, psiElement().inside(ValuePsiElement::class.java), FunctionProvider)
        extend(BASIC, psiElement().inside(InvokePsiElement::class.java), FunctionProvider)
    }

    private object FunctionProvider : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            for (method in GodotApi.LANGUAGE_CLASS.methods)
                result.addElement(PrioritizedLookupElement.withPriority(createBuiltInMethodLookup(method), CompletionPriority.FUNCTION_CALL))
        }

        private fun createBuiltInMethodLookup(method: GodotApi.Class.Method) = create(method.name)
            .withIcon(FUNCTION_ICON)
            .withItemTextItalic(true)
            .withTailText(method.joinedArguments())
            .withTypeText(method.type)
            .withInsertHandler { ctx, _ ->
                if (ctx.hasNoOpenBraceAfterCaret()) {
                    ctx.insert("()")
                    if (method.arguments.isEmpty())
                        ctx.moveCaret(2)
                    else
                        ctx.moveCaret(1)
                }
            }

        private fun GodotApi.Class.Method.joinedArguments() =
            arguments.joinToString(", ", "(", ")") { "${it.name}: ${it.type}" }

    }

}
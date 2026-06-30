package com.stev.agent

/**
 * Default implementation of the Coding Agent
 */
class DefaultCodingAgent : CodingAgent {

    override fun analyzCode(code: String): List<CodeSuggestion> {
        val suggestions = mutableListOf<CodeSuggestion>()

        // Analyze code for common issues
        if (code.contains("var ", ignoreCase = false)) {
            suggestions.add(
                CodeSuggestion(
                    line = code.lines().indexOfFirst { it.contains("var ") } + 1,
                    message = "Consider using 'val' instead of 'var' for immutability",
                    severity = SuggestionSeverity.WARNING,
                    fix = "Replace 'var' with 'val'"
                )
            )
        }

        if (code.contains("!!", ignoreCase = false)) {
            suggestions.add(
                CodeSuggestion(
                    line = code.lines().indexOfFirst { it.contains("!!") } + 1,
                    message = "Avoid using !! (not-null assertion). Use safe call (?.) or Elvis operator (?:)",
                    severity = SuggestionSeverity.ERROR,
                    fix = "Replace '!!' with '?.' or '?.'"
                )
            )
        }

        return suggestions
    }

    override fun debugCode(code: String): List<DebugIssue> {
        val issues = mutableListOf<DebugIssue>()

        // Check for potential null pointer exceptions
        if (code.contains("!!")) {
            issues.add(
                DebugIssue(
                    line = code.lines().indexOfFirst { it.contains("!!") } + 1,
                    message = "Potential NullPointerException with !! operator",
                    type = IssueType.NULL_POINTER_EXCEPTION
                )
            )
        }

        // Check for resource leaks
        if (code.contains("FileInputStream", ignoreCase = true) && !code.contains("use {", ignoreCase = true)) {
            issues.add(
                DebugIssue(
                    line = code.lines().indexOfFirst { it.contains("FileInputStream", ignoreCase = true) } + 1,
                    message = "Potential resource leak. Ensure FileInputStream is closed properly",
                    type = IssueType.RESOURCE_LEAK
                )
            )
        }

        return issues
    }

    override fun suggestBestPractices(codeContext: String): List<String> {
        val suggestions = mutableListOf<String>()

        suggestions.add("Use LiveData or StateFlow for reactive data binding")
        suggestions.add("Implement proper error handling with try-catch blocks")
        suggestions.add("Use coroutines for background operations instead of threads")
        suggestions.add("Always request permissions at runtime for Android 6.0+")
        suggestions.add("Use dependency injection with Hilt for better testability")
        suggestions.add("Implement proper lifecycle management for activities and fragments")
        suggestions.add("Use View Binding instead of findViewById()")

        return suggestions
    }
}

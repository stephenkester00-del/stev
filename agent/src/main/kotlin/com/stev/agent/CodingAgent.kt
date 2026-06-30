package com.stev.agent

/**
 * Main Coding Agent interface for Android development assistance
 */
interface CodingAgent {
    /**
     * Analyzes code and provides suggestions
     * @param code The source code to analyze
     * @return A list of suggestions
     */
    fun analyzCode(code: String): List<CodeSuggestion>

    /**
     * Debugs code and identifies potential issues
     * @param code The source code to debug
     * @return A list of identified issues
     */
    fun debugCode(code: String): List<DebugIssue>

    /**
     * Suggests best practices for Android development
     * @param codeContext The context of the code
     * @return A list of best practice suggestions
     */
    fun suggestBestPractices(codeContext: String): List<String>
}

/**
 * Data class representing a code suggestion
 */
data class CodeSuggestion(
    val line: Int,
    val message: String,
    val severity: SuggestionSeverity,
    val fix: String? = null
)

/**
 * Data class representing a debug issue
 */
data class DebugIssue(
    val line: Int,
    val message: String,
    val type: IssueType,
    val stackTrace: String? = null
)

/**
 * Severity levels for suggestions
 */
enum class SuggestionSeverity {
    INFO, WARNING, ERROR
}

/**
 * Types of debug issues
 */
enum class IssueType {
    NULL_POINTER_EXCEPTION,
    RESOURCE_LEAK,
    PERFORMANCE_ISSUE,
    SECURITY_ISSUE,
    OTHER
}
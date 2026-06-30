package com.stev.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stev.agent.DefaultCodingAgent

class MainActivity : AppCompatActivity() {

    private val codingAgent = DefaultCodingAgent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example usage of the coding agent
        demonstrateAgent()
    }

    private fun demonstrateAgent() {
        val sampleCode = """
            var x = 10
            val str: String? = null
            val value = str!!
        """.trimIndent()

        // Analyze code
        val suggestions = codingAgent.analyzCode(sampleCode)
        suggestions.forEach { suggestion ->
            println("${suggestion.severity}: ${suggestion.message}")
        }

        // Debug code
        val issues = codingAgent.debugCode(sampleCode)
        issues.forEach { issue ->
            println("${issue.type}: ${issue.message}")
        }

        // Get best practices
        val bestPractices = codingAgent.suggestBestPractices(sampleCode)
        bestPractices.forEach { practice ->
            println("Best Practice: $practice")
        }
    }
}
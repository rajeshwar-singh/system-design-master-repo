
package com.example.demo.MCP;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private final ChatClient chatClient;

    public AIService(
            ChatClient.Builder chatClientBuilder,
            ToolCallbackProvider toolCallbackProvider) {

        this.chatClient = chatClientBuilder
                .defaultToolCallbacks(toolCallbackProvider)
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }

    @Retryable(
            maxRetries = 2,
            delay = 10000
    )
    public String getAiResponse(String query) {

        return chatClient.prompt(query)
                .call()
                .content();
    }
}

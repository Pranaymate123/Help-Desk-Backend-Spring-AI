package com.hekpdesk.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CurrentDateTimeTool {

    @Tool(description = "This tool is used to get the current date and time")
    public String getDateTime()
    {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME).toString();
    }
}

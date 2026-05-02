package com.hekpdesk.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class EmailTool {
    //send email to support team regarding the new ticket
    @Tool(description = "This tool helps to send email to support team regarding the new ticket")
    public void sendEmailToSupportTeam(@ToolParam(description = "Email of the user associated with the ticket for contact") String email,@ToolParam(description = "This is the short description of ticket") String message)
    {
        //Sending the email to support team
        System.out.println("Mail sent to support team successfully ");
        System.out.println("Email Id :- "+email);
        System.out.println("Message :- "+message);
    }
}

package com.huseyinyetisir.BookstoreBE.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huseyinyetisir.BookstoreBE.entity.Message;
import com.huseyinyetisir.BookstoreBE.service.MessageService;
import com.huseyinyetisir.BookstoreBE.utils.ExtractJWT;

@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/messages")
@RestController
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/secure/post/message")
    public void postMessage(@RequestHeader("Authorization") String token,
            @RequestBody Message messageRequest) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        messageService.postMessages(messageRequest, userEmail);
    }

}

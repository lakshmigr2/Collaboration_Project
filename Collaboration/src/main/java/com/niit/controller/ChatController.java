package com.niit.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.google.gson.Gson;
import com.niit.model.Message;
import com.niit.model.OutputMessage;

@Controller
public class ChatController 
{
	@MessageMapping("/chat")
	  @SendTo("/topic/message")
	  public OutputMessage sendMessage(Message message) {
	    return new OutputMessage(message, new Date());
	  }
	
	
	@RequestMapping("/chatPage")
	public ModelAndView chat() {
		ModelAndView model = new ModelAndView("chat");
		return model;
	}
	
	}


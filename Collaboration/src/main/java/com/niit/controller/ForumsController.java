package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.ForumsDao;
import com.niit.model.Forums;

@RestController
public class ForumsController {
	@Autowired
	ForumsDao forumsDao;
	@RequestMapping(value="/addForums",headers="Accept=application/json",method=RequestMethod.POST)
	public void addForums(@RequestBody Forums forums, HttpSession session)
	{
		int userId=(Integer) session.getAttribute("loggedInUserId");
		//forums.setUsersID(userId);
		forums.setDateOfQuestion(new Date());
		System.out.println("user id inside forums is "+userId);
		//forums.setApproved(0);
		forumsDao.saveOrUpdateForums(forums);
	}
	@RequestMapping(value="/viewForumss",headers="Accept=application/json",method=RequestMethod.GET)
	public List<Forums> viewForumss()
	{
		return forumsDao.getAllForums();
	}
	@RequestMapping(value="/updateForums",headers="Accept=application/json",method=RequestMethod.PUT)
	public void updateForums(@RequestBody Forums forums)
	{
		System.out.println("Inside update forums");
		forums.setDateOfQuestion(new Date());
		forumsDao.saveOrUpdateForums(forums);
	}
	@RequestMapping(value="/deleteForums/{id}",headers="Accept=application/json",method=RequestMethod.DELETE)
	public void deleteForums(@PathVariable String id)
	{
		forumsDao.delete(id);
	}
	
	

}

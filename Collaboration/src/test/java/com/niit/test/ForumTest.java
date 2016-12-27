package com.niit.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumDao;
import com.niit.dao.UsersDetailDao;
import com.niit.model.Forum;
import com.niit.model.UsersDetail;

public class ForumTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		Forum forum = (Forum) context.getBean("forum");
		ForumDao forumDAO = (ForumDao) context.getBean("forumDao");

		// INSERT OBJECTS INTO DB

		forum.setForumId("FORUM_001");
		forum.setName("niit1");
		forum.setContent("description");
		//forum.setContent("Content
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
		
		
		
		
		
		
		//myString = DateFormat.getDateInstance().format(myDate);
		
		// Get the date today using Calendar object.
		Date today = new Date();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);

		// Print what date is today!
		System.out.println("Report Date: " + reportDate);
		
		forum.setDateOfCreation(reportDate);		
		
		forum.setTopic("insti1");
		forum.setUsersID(5);
		//forum.setCategory("this is category");
		forumDAO.saveOrUpdateForum(forum);

		/*forum.setForumId("FORUM_002");
		forum.setContent("description");
		//forum.setContent("Content");
		forum.setDateOfCreation(new Date());
		forum.setTitle("title");
		forum.setUsersID(6);
		forum.setCategory("this is category");
		forumDAO.saveOrUpdateForum(forum);

		forum.setForumId("FORUM_003");
		forum.setContent("description");
		//forum.setContent("Content");
		forum.setDateOfCreation(new Date());
		forum.setUsersID(7);
		forum.setCategory("this is category");
		forum.setTitle("title");
		forumDAO.saveOrUpdateForum(forum);
*/
		/*forum = forumDAO.getForumById("FORUM_002");
		System.out.println(forum.getContent() + "\t" + forum.getTitle() + "\t" + "\t" + forum.getDateOfCreation());*/

		/*
		 * boolean flag=forumDAO.delete(forum); System.out.println("delete  "
		 * +flag);
		 */
		context.close();
	}
}


package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Forums {
		@Id
	    private String QuestionId;
		private String QuestionTitle;
		private int QuestionDescreption;
		private Date dateOfQuestion;
		public String getQuestionId() {
			return QuestionId;
		}
		public void setQuestionId(String questionId) {
			QuestionId = questionId;
		}
		public String getQuestionTitle() {
			return QuestionTitle;
		}
		public void setQuestionTitle(String questionTitle) {
			QuestionTitle = questionTitle;
		}
		public int getQuestionDescreption() {
			return QuestionDescreption;
		}
		public void setQuestionDescreption(int questionDescreption) {
			QuestionDescreption = questionDescreption;
		}
		public Date getDateOfQuestion() {
			return dateOfQuestion;
		}
		public void setDateOfQuestion(Date dateOfQuestion) {
			this.dateOfQuestion = dateOfQuestion;
		}
		
		
		
}

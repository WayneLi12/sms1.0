package com.briup.app02.vm;

import java.util.List;

import com.briup.app02.bean.Question;
import com.briup.app02.bean.Questionnaire;

public class QqVM {
	private Long id;
	private Question question;
	private Questionnaire questionnaire;
	private List<Question> questions;
	private List<Questionnaire> questionnaires;
	
	
	public QqVM() {
	}
	public QqVM(Long id, List<Question> questions, List<Questionnaire> questionnaires) {
		super();
		this.id = id;
		this.questions = questions;
		this.questionnaires = questionnaires;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public List<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}
	public void setQuestionnaires(List<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	

}

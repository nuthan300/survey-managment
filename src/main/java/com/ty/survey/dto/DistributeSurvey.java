package com.ty.survey.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class DistributeSurvey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name = "survey_id")
	private Survey survey1;

	@ManyToMany
	@JoinTable(name = "SurveyRespondent" ,inverseJoinColumns = @JoinColumn, joinColumns = @JoinColumn)
	private List<Respondent> respondents;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Respondent> getRespondents() {
		return respondents;
	}

	public void setRespondents(List<Respondent> respondents) {
		this.respondents = respondents;
	}

	public Survey getSurvey1() {
		return survey1;
	}

	public void setSurvey1(Survey survey1) {
		this.survey1 = survey1;
	}
}

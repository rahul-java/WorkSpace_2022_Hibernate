package max.hibernate.OneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Answer1 {
    @Id
    @Column(name="answer_id")
	private int aswerId;
	private String answer;
	
	@ManyToOne
	private Question1 question;
	
	public Answer1(int aswerId, String answer) {
		super();
		this.aswerId = aswerId;
		this.answer = answer;
	}
	public Answer1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAswerId() {
		return aswerId;
	}
	public Question1 getQuestion() {
		return question;
	}
	public void setQuestion(Question1 question) {
		this.question = question;
	}
	public void setAswerId(int aswerId) {
		this.aswerId = aswerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}

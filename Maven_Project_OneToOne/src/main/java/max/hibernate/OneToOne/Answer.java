package max.hibernate.OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {
    @Id
    @Column(name="answer_id")
	private int aswerId;
	private String answer;
	@OneToOne(mappedBy = "answer")
	private Question question;
	
	public Answer(int aswerId, String answer) {
		super();
		this.aswerId = aswerId;
		this.answer = answer;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAswerId() {
		return aswerId;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
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

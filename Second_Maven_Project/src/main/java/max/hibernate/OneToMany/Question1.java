package max.hibernate.OneToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Question1 {
	@Id
	@Column(name="question_id")
	private int questionId;
	private String question;
	
	@OneToMany(mappedBy = "question")
	private List<Answer1> answer;

	
	

	public Question1(int questionId, String question, List<Answer1> answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
	}

	public Question1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer1> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer1> answer) {
		this.answer = answer;
	}

	

}

package max.hibernate.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        /*
        //creating question
        Question q1=new Question();
        q1.setQuestionId(111);
        q1.setQuestion("What is JAVA ?");
        
        Answer ans1=new Answer();
        ans1.setAswerId(121);
        ans1.setAnswer("Java is Programming Language.");
        ans1.setQuestion(q1);
        
        q1.setAnswer(ans1);
        
        Question q2=new Question();
        q2.setQuestionId(222);
        q2.setQuestion("What is Collection Framework ?");
        
        Answer ans2=new Answer();
        ans2.setAswerId(232);
        ans2.setAnswer("API to work with objects in JAVA.");
        ans2.setQuestion(q2);
        
        q2.setAnswer(ans2);
        
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        s.save(q1);
        s.save(q2);
        s.save(ans1);
        s.save(ans2);
        
        tx.commit();
        */
        //Fetching Values
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        Question qq = (Question)s.get(Question.class, 222);
        tx.commit();
        System.out.println(qq.getQuestion());
        System.out.println(qq.getAnswer().getAnswer());
        
        s.close();
        sf.close();
	}
}

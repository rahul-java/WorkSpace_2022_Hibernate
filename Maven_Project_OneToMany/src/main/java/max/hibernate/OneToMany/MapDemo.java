package max.hibernate.OneToMany;

import java.util.ArrayList;
import java.util.List;

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
        Question1 q1=new Question1();
        q1.setQuestionId(1111);
        q1.setQuestion("What is JAVA ?");
        
        Answer1 ans1=new Answer1();
        ans1.setAswerId(1211);
        ans1.setAnswer("Java is Programming Language.");
        ans1.setQuestion(q1);
        
        Answer1 ans2=new Answer1();
        ans2.setAswerId(1212);
        ans2.setAnswer("With the help of JAVA we can create Softwares.");
        ans2.setQuestion(q1);
        
        Answer1 ans3=new Answer1();
        ans3.setAswerId(1213);
        ans3.setAnswer("Java has diffrent types of framework.");
        ans3.setQuestion(q1);
        
        List<Answer1> list=new ArrayList<Answer1>();
        list.add(ans1);
        list.add(ans2);
        list.add(ans3);
        
        q1.setAnswer(list);
        
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        
        s.save(q1);
       s.save(ans1);
       s.save(ans2);
       s.save(ans3);
        tx.commit();
        */
        //Fetching Values
        
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
       Question1 q1=s.get(Question1.class, 1111);
       System.out.println(q1.getQuestion());
       
       for(Answer1 a:q1.getAnswer())
       {
    	   System.out.println(a.getAnswer());
       }
        
     
        
        s.close();
        sf.close();
	}
}

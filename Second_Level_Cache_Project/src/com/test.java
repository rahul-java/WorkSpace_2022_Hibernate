package com;

public class test {
	/*create or replace
	PROCEDURE       log_sal (
	  emp_id NUMBER, old_sal NUMBER, new_sal NUMBER)
	AS LANGUAGE JAVA
	NAME 'DBTrigger.logSal(int, float, float)';

	create or replace
	TRIGGER SCOTT.sal_trig
	AFTER UPDATE OF sal ON SCOTT.emp
	FOR EACH ROW
	WHEN (new.sal > 1.2 * old.sal)
	CALL SCOTT.log_sal(:new.empno, :old.sal, :new.sal)

	import java.sql.*;
	import java.io.*;
	import oracle.jdbc.driver.*;

	public class DBTrigger {
	  public static void logSal (int empID, float oldSal, float newSal)
	  throws SQLException {
	    Connection conn = new OracleDriver().defaultConnection();
	    String sql = "INSERT INTO sal_audit VALUES (?, ?, ?)";
	    try {
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, empID);
	      pstmt.setFloat(2, oldSal);
	      pstmt.setFloat(3, newSal);
	      pstmt.executeUpdate();
	      pstmt.close();
	    } catch (SQLException e) {System.err.println(e.getMessage());}
	  }
	} 



	
	
	
	
*/}

package com.hari.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.hari.dto.CgpaAndGpa;
import com.hari.util.OracleConnections;
import com.hari.util.Utility;
public class CgpaAndGpaDao {
	OracleConnections connection=new OracleConnections();
	public ArrayList<CgpaAndGpa> getSubjectdetails(int nosem,int check) throws ClassNotFoundException, SQLException
	{
		ArrayList<CgpaAndGpa> subdetails = new ArrayList<CgpaAndGpa>();
		Connection con=connection.getConnection();
		String tablename=Utility.getTablename(check);
		String sql="SELECT * FROM "+tablename+" WHERE SEMNO="+nosem;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			CgpaAndGpa details=new CgpaAndGpa();
			details.setSubcode(rs.getString("SUBCODE"));
			details.setSubject(rs.getString("SUBNAME"));
			details.setCredits(rs.getInt("CREDITS"));
			subdetails.add(details);
		}
		return subdetails;
	}
}

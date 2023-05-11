package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List listMembers(MemberVO memberVO) {
		//배열로 받아옴
		List<MemberVO> membersList = new ArrayList();
		//이름 받아오기
		String _name = memberVO.getName();
		try {
			con = dataFactory.getConnection();
			
			String query = "select * from t_member";
			//이름을 공백으로 넣은게 아니면 그 이름만 가져옴
			if((_name!=null && _name.length()!=0)){
				 query+=" where name=?";
				 pstmt = con.prepareStatement(query);
				 pstmt.setString(1, _name);
			}else {
				//그게 아니면 그냥 전부 가져옴
				pstmt = con.prepareStatement(query);	
			}
			
			
			System.out.println("prepareStatememt : " + query);
			ResultSet rs = pstmt.executeQuery();
			//받아온 결과값을 다음값이 없을때까지 출력함
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				membersList.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return membersList;
	}

}

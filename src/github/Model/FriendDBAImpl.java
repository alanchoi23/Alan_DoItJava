package github.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FriendDBAImpl implements FriendDBA {
	String url;
	String user;
	String pwd;
	
	//DB 세팅
	public FriendDBAImpl() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "scott";
			pwd = "TIGER";
	
		} 
	
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	//친구 추가
	@Override
	public void friendInsert(Friend f) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "insert into friend"
					  + " values(friend_seq.nextval,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, f.getName());
			ps.setString(2, f.getBirth());
			ps.setString(3, f.getPhone());
			ps.setString(4, f.getAddr());
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)ps.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}


	}
	//친구전체보기
	@Override
	public ArrayList<Friend> friendView() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Friend> arr = new ArrayList<>();
		
		try {
			con=DriverManager.getConnection(url, user, pwd);
			String sql = "select * from friend";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Friend f = new Friend();
				f.setNum(rs.getInt("num"));
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				arr.add(f);	
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(con!=null) con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;

	}
	//친구 검색
	@Override
	public ArrayList<Friend> friendSearch(String ft1, int idx) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Friend> arr = new ArrayList<>();
		
		String key = "name";
		if(idx==0) {
			key="name";
		}
		else if(idx==1) {
			key="birth";
		}
		else if(idx==2) {
			key="phone";
		}
		else if(idx==3) {
			key="addr";
		}
		
		try {
			con=DriverManager.getConnection(url, user, pwd);
			String sql = "select * from friend where " + key + " like '%" + ft1 +"%'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Friend f = new Friend();
				f.setNum(rs.getInt("num"));
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				arr.add(f);	
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(con!=null) con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}
	//상세보기
		public Friend friendSelect(int num) {
				
				Connection con = null;
				Statement st = null;
				ResultSet rs = null;
				Friend f = null;
						
				try {
					con = DriverManager.getConnection(url, user, pwd);
					st = con.createStatement();
					String sql = "select * from friend where num="+num;
					rs = st.executeQuery(sql);
					if(rs.next()) {
						f = new Friend();
						f.setNum(rs.getInt(1)); //f.setNum(rs.getInt("num"))
						f.setName(rs.getString("name"));
						f.setBirth(rs.getString("birth"));
						f.setPhone(rs.getString("phone"));
						f.setAddr(rs.getString("addr"));
					}
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				finally {
					try {
					if(rs!=null) rs.close();
					if(st!=null) st.close();
					if(con!=null) con.close();
					} 
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return f;	
			}
		//수정
		public void friendUpdate(Friend f) {
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = DriverManager.getConnection(url, user, pwd);
				String sql = "update friend set name=?, birth=?,"
						+ " phone=?, addr=? where num=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, f.getName());
				ps.setString(2, f.getBirth());
				ps.setString(3, f.getPhone());
				ps.setString(4, f.getAddr());
				ps.setInt(5, f.getNum());
				ps.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(ps!=null)ps.close();
					if(con!=null)con.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}

		}
		public void friendDelete(int num) {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(url, user, pwd);
				String sql = "delete from friend where num ="+num;
				st = con.createStatement();
				st.executeUpdate(sql);
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(st!=null) st.close();
					if(con!=null) con.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		
		}
	}

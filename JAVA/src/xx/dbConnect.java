package xx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnect {
	
	final String url = "jdbc:mysql://127.0.0.1/sipaproject?useUnicode=true&characterEncoding=UTF-8"; //ชื่อฐานข้อมูล
	final String usr = "root"; //USERNAME ของฐานข้อมูล
	final String pwd = ""; //รหัสผ่านของฐานข้อมูล
	Connection conn;
	static Statement stmt;
	static int provinceId;
	static int districtId;
	static int cantonId; 
	static String groupCompanyId;
	
	
	public void connectDB() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("เชื่อมต่อ Db แล้ว");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ไม่สามารถเชื่อต่อได้");
		} 	
		conn = DriverManager.getConnection(url, usr, pwd);
		stmt = conn.createStatement();
	}
	
	public void add_company(String[] val,int groupCompanyId) {
		
		try {
			ResultSet rs = stmt.executeQuery( "SELECT * FROM `province` WHERE `provinceName` LIKE '%"+val[7]+"%' ORDER BY `provinceName` ASC" );
			while (rs.next()) {
				provinceId = rs.getInt("provinceId");	
			
			}
			ResultSet rs2 = stmt.executeQuery( "SELECT * FROM `district` WHERE `districtName` LIKE '%"+val[8]+"%' ORDER BY `districtName` ASC" );
			while (rs2.next()) {
				districtId = rs2.getInt("districtId");	
				
			}
			ResultSet rs3 = stmt.executeQuery( "SELECT * FROM `canton` WHERE `cantonName` LIKE '%"+val[9]+"%' ORDER BY `cantonName` ASC");
			while (rs3.next()) {
				cantonId = rs3.getInt("cantonId");	
				
			}
			
			ResultSet rs4 = stmt.executeQuery( "SELECT * FROM `groupcompany` WHERE `detail` LIKE '%"+groupCompanyId+"%' ORDER BY `detial` ASC");
			while (rs4.next()) {
				groupCompanyId = rs4.getString("groupCompanyId");	
			}
			System.out.println(provinceId);
			System.out.println(districtId);
			System.out.println(cantonId);
			String strSQLadd = "INSERT INTO `sipaproject`.`company` (`companyId`, `companyNo`, `companyName`, `groupCompanyId`, `provinceId`, `districtId`, `cantonId`, `address`, `financeId`, `companyTypeId`, `dateRegistration`, `companyStatus`, `objective`, `tel`, `email`) VALUES "+value+" ,"+provinceId+","+districtId+","+cantonId+","+val+";";
		//	stmt.execute(strSQLadd);
			System.out.print(strSQLadd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	
}

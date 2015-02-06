import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class db {
	final String url = "jdbc:mysql://127.0.0.1/sssssss?useUnicode=true&characterEncoding=UTF-8"; //ชื่อฐานข้อมูล
	final String usr = "root"; //USERNAME ของฐานข้อมูล
	final String pwd = ""; //รหัสผ่านของฐานข้อมูล
	Connection conn;
	static Statement stmt;
	
	static int provinceId;
	static int districtId;
	static int cantonId; 
	static int companyId; 
	static int finance; 
	
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
	
	public int add_company(String[] val,String companyTypeId) {
		
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
			String strSQLadd = "INSERT INTO `sssssss`.`company` (`companyId`, `companyNo`, `companyName`, `provinceId`, `districtId`, `cantonId`, `companyTypeId`) VALUES (NULL,'"
																			+val[2]+"','"+val[3]+"','"+provinceId+"','"+districtId+"','"+cantonId+"','"+companyTypeId+"');";
			stmt.execute(strSQLadd);
			System.out.println(strSQLadd);
			System.out.println("เพิ่มcompanyแล้ว");
			
			ResultSet returnValue = stmt.executeQuery( "SELECT * FROM `company` ORDER BY `companyId` DESC LIMIT 1");
			while (returnValue.next()) {
				companyId = returnValue.getInt("companyId");	
				
			}
			System.out.println("ID = "+companyId);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return companyId;
	}
	
	public void add_detailcompany(int companyId,String[] value){
		
		String sqlStr = "INSERT INTO `sssssss`.`detailcompany` (`detailcompanyid`, `dateRegister`, `status`, `moneyRegister`, `address`, `noteGroup`, `object`, `yearSentStament`, `syndicate`, `partner`, `tel`, `fax`, `note`, `email`, `companyId`) VALUES (NULL, '"
		+value[2]+"', '"+value[3]+"', '"+value[4]+"', '"+value[5]+"', '"+value[6]+"', '"+value[7]+"', '"+value[8]+"', '"+value[9]+"', '"+value[10]+"', '"+value[11]+"', '"+value[12]+"', '"+value[13]+"', '-', '"+companyId+"');";
		try {
			stmt.execute(sqlStr);
			System.out.println(sqlStr);
			System.out.println("เพิ่ม detailcompany แล้ว");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void add_finance(int companyId,String year,String[][] financeAndDe) throws SQLException{
		
		for(int i=1;i<=13;++i){
			if(financeAndDe[1][i]!=null){
		String sqlStr = "INSERT INTO `sssssss`.`budgetandfinace` (`Id`, `name`, `value`, `percentValue`, `year`, `companyId`) VALUES (NULL, '"+
		financeAndDe[1][i]+"', '"+financeAndDe[2][i]+"', '"+financeAndDe[3][i]+"', '"+year+"', '"+companyId+"');";
		
		try {
			stmt.execute(sqlStr);
			System.out.println(sqlStr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
		}
		
	}
	
public void add_finance2(int companyId,String year,String[][] financeAndDe) throws SQLException{
		
		for(int i=1;i<=12;++i){
			if(financeAndDe[1][i]!=null){
		String sqlStr = "INSERT INTO `sssssss`.`budgetandfinace` (`Id`, `name`, `value`, `percentValue`, `year`, `companyId`) VALUES (NULL, '"+
		financeAndDe[1][i]+"', '"+financeAndDe[2][i]+"', '"+financeAndDe[3][i]+"', '"+year+"', '"+companyId+"');";
		
		try {
			stmt.execute(sqlStr);
			System.out.println(sqlStr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
		
		}
		
	}
	
}

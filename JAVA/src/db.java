import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.concurrent.TimeUnit;


public class db {
	
	private final String database = "sipadbd2"; 
	private final String url = "jdbc:mysql://sipadbd2.ibsx.net/"+database+"?useUnicode=true&characterEncoding=UTF-8";
	private final String usr = "1234.sipadbd2"; 
	private final String pwd = "1234"; 
	
/*    private final String database = "sipadbd"; 
	private final String url = "jdbc:mysql://myhost.com/"+database+"?useUnicode=true&characterEncoding=UTF-8";
	private final String usr = "root"; 
	private final String pwd = "041712611"; */
	Connection conn;
	private static Statement stmt;
	
	private static int provinceId;
	private static int districtId;
	private static int cantonId; 
	private static int companyId;
	
	public void connectDB() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, usr, pwd);
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(">> !Error connect DB");
		} 	
		

	}
	public void closedb() throws Exception{
		conn.close();
	}
	public int add_company(String[] val,String companytypeId) throws Exception {
		ResultSet rsg = stmt.executeQuery( "SELECT `companyId` FROM `"+database+"`.`company` WHERE `companyNo` = '"+val[2]+"' LIMIT 1" );
		
		if(!rsg.next()){
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
			String strSQLadd = "INSERT INTO `"+database+"`.`company` (`companyId`, `companyNo`, `companyName`, `provinceId`, `districtId`, `cantonId`, `companyTypeId`) VALUES (NULL,'"
																			+val[2]+"','"+val[3]+"','"+provinceId+"','"+districtId+"','"+cantonId+"','"+companytypeId+"');";
			stmt.execute(strSQLadd);
			
			
			ResultSet returnValue = stmt.executeQuery( "SELECT * FROM `company` ORDER BY `companyId` DESC LIMIT 1");
			while (returnValue.next()) {
				companyId = returnValue.getInt("companyId");	
				
			}
			System.out.println(">> AddData to company table Complete! : "+val[3]+" ID = "+companyId);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return companyId;
		}else{
			
			System.out.println(">> Data is repeatedly skip Next Data");
			System.out.println("-------------------------------------");
			return 0;
		}
		
	}
	
	public void add_detailcompany(int companyId,String[] value){
		
		String sqlStr = "INSERT DELAYED INTO `"+database+"`.`detailcompany` (`detailcompanyid`, `titleCompany`, `dateRegister`, `status`, `moneyRegister`, `address`, `noteGroup`, `object`, `yearSentStament`, `syndicate`, `partner`, `tel`, `fax`, `note`, `email`, `companyId`) VALUES (NULL, '"
		+value[1]+"', '"+value[2]+"', '"+value[3]+"', '"+value[4]+"', '"+value[5]+"', '"+value[6]+"', '"+value[7]+"', '"+value[8]+"', '"+value[9]+"', '"+value[10]+"', '"+value[11]+"', '"+value[12]+"', '"+value[13]+"', '-', '"+companyId+"');";
		try {
			stmt.execute(sqlStr);
			System.out.println(">> Add Data To Table CompanyDetial Complete!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void add_finance(int companyId,String[] year,String[][][] financeAndDe,String[][][] financeAndDe2) throws Exception{
	int control  = 2;
	String str = null;
	
		for(int ii=0;ii<=2;ii++){
			
			for(int checki = 0;checki<13;checki++){
				if(financeAndDe2[ii][2][checki]==""||financeAndDe2[ii][2][checki]==null||financeAndDe2[ii][2][checki].length()==0){
					financeAndDe2[ii][2][checki]="0";
	
				}
			}
			for(int checki = 0;checki<13;checki++){
				if(financeAndDe[ii][2][checki]==""||financeAndDe[ii][2][checki]==null||financeAndDe[ii][2][checki].length()==0){
					financeAndDe[ii][2][checki]="0";
				}
			}
			
			str = "INSERT DELAYED INTO `"+database+"`.`budgetandfinace` (`id`,"
+ " `profitLoss`, "
+ "`profitLossNet`,"
+ " `costOfSalesAndServices`,"
+ " `interest`,"
+ " `costOfSales`,"
+ " `plantAndEquipment`,"
+ " `incomeTax`,"
+ " `totalExpenditures`,"
+ " `totalIncome`,"
+ " `revenue`,"
+ " `tradeReceivablesNet`,"//
+ " `inventories`,"//
+ " `totalAssets`,"//
+ " `assets`, "//
+ "`nonCurrentAssets`,"//
+ " `equityShares`,"//
+ " `totalLiabilities`,"//
+ " `totalLiabilitiesAndShareholdersEquity`,"//
+ " `liabilities`,"//
+ " `nonCurrentLiabilities`,"//
+ " `profitLossBeforeTax`,"
+ " `companyId`,"
+ " `year`) VALUES (NULL, "
		+ " "+financeAndDe2[ii][2][4+control]+","
		+ " "+financeAndDe2[ii][2][10+control]+","
		+ " "+financeAndDe2[ii][2][5+control]+","
		+ " "+financeAndDe2[ii][2][7+control]+","
		+ " "+financeAndDe2[ii][2][3+control]+","
		+ " "+financeAndDe[ii][2][4+control]+","
		+ " "+financeAndDe2[ii][2][9+control]+","
		+ " "+financeAndDe2[ii][2][6+control]+","
		+ " "+financeAndDe2[ii][2][2+control]+","
		+ " "+financeAndDe2[ii][2][1+control]+","
		+ " "+financeAndDe[ii][2][1+control]+","
		+ " "+financeAndDe[ii][2][2+control]+","
		+ " "+financeAndDe[ii][2][6+control]+","
		+ " "+financeAndDe[ii][2][3+control]+","
		+ " "+financeAndDe[ii][2][5+control]+","
		+ " "+financeAndDe[ii][2][10+control]+","
		+ " "+financeAndDe[ii][2][1+control]+","
		+ " "+financeAndDe[ii][2][11+control]+","
		+ " "+financeAndDe[ii][2][7+control]+","
		+ " "+financeAndDe[ii][2][8+control]+","
		+ " "+financeAndDe2[ii][2][8+control]+","
		+ " "+companyId+","
		+ " '"+year[ii]+"');";	

			connectDB();
			stmt.execute(str);
			closedb();
	}

	}
	public void rollBackData(int companyId) throws Exception{
		boolean check = true;
		while (check == true) {
			try {
				connectDB();
				check = false;
			
				System.out.println(">> Connected");
			} catch (SQLException e) {
				check = true;
				TimeUnit.MILLISECONDS.sleep(2000);
				System.out.println(">> Cannot Connect"+" Delay 2s..");
				
			}
			
		}

		
					try {
						String sqlStrd = "DELETE FROM `"+database+"`.`budgetandfinace` WHERE `companyId` = '"+companyId+"';";
						stmt.execute(sqlStrd);
					
	
						
						String sqlStrd2 = "DELETE FROM `"+database+"`.`company` WHERE `companyId` = '"+companyId+"';";
						stmt.execute(sqlStrd2);
	
						String sqlStrd3 = "DELETE FROM `"+database+"`.`detailcompany` WHERE `companyId` = '"+companyId+"';";
						stmt.execute(sqlStrd3);
			
						System.out.println(">> Deleted And Renew");
					} catch (Exception e) {
						rollBackData(companyId);
						System.out.println(">> Error And RoleBack Again");
					}


	}
	
public ResultSet searchGroup(String g) throws Exception {
				ResultSet rs = stmt.executeQuery( "SELECT `companyTypeId` FROM `companytype` WHERE `groupCompanyId` = '"+g+"';" );
	
				return rs;
			
	
				
		
	
	}

	
}

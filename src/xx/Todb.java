package xx;



public class Todb {

	public static void main(String[] args) {
		dbConnect db = new dbConnect();
		try {
			db.connectDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.add_company("เชียงใหม่","หางดง","หารแก้ว","(null,null,null,null","null,null,null,null,null,null,null,null)");
		

	}
	


}

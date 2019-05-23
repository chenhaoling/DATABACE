package dataBaseOperation;
//df
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
//import java.sql.Date;//
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JOptionPane;

public class Operation {
	static Connection conn;//曹
	// 连接到mysql
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://209.222.30.78:3306/hotel?useSSL=false&serverTimezone=GMT&useUnicode=true&characterEncoding=utf8";
	static String user = "Bat";
	static String password = "2019!Cao";

	public static void Connect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static boolean FindInforByRoomnumber(String roomNumber)
			throws SQLException, UnsupportedEncodingException {
		Statement statement = conn.createStatement();
		String sql = "select * from roominfor where roomNumber=" + roomNumber;
		ResultSet rs = statement.executeQuery(sql);
		int isBooked = 0;
		while (rs.next()) {
			isBooked = rs.getInt("isBooked");
			// isBooked = new Integer(isBooked.getBytes("UTF-8"), "UTF-8");
			// System.out.println("锟斤拷锟斤拷状态锟斤拷 " + isBooked);
		}
		if (0 == isBooked)

			return false;
		else
			return true;
	}

	// public static void FindByName(String name) throws SQLException,
	// UnsupportedEncodingException {
	//
	// Statement statement = conn.createStatement();
	// String sql = "select * from customer where name='" + name + "'";
	// ResultSet rs = statement.executeQuery(sql);
	//
	// String roomNumber = null;
	// String IDnumber = null;
	//
	// while (rs.next()) {
	// roomNumber = rs.getString("roomNumber");
	// IDnumber = rs.getString("IDnumber");
	// roomNumber = new String(roomNumber.getBytes("UTF-8"), "UTF-8");
	// IDnumber = new String(IDnumber.getBytes("UTF-8"), "UTF-8");
	// }
	// rs.close();
	// // conn.close();
	// }

	public static void insertCustomerInfor(String name, String IDnumber,
			String dStartDate, String dEndDate, int Countdays,
			String phoneNumber, String SingleOrDouble) throws SQLException {
		Statement statement = conn.createStatement();

		String sql = "insert into customer (name,IDnumber,StartDate,EndDate,Countdays,phoneNumber,SingleOrDouble,fareOfHousing) values("
				+ "'"
				+ name
				+ "'"
				+ ","
				+ "'"
				+ IDnumber
				+ "'"
				+ ","
				+ "'"
				+ dStartDate
				+ "'"
				+ ","
				+ "'"
				+ dEndDate
				+ "'"
				+ ","
				+ Countdays
				+ ","
				+ "'"
				+ phoneNumber
				+ "'"
				+ ","
				+ "'"
				+ SingleOrDouble + "'" + ",";

		// statement.execute(sql + "'" + name + "'" + "," + "'" + IDnumber + "'"
		// + "," + "'" + dStartDate + "'" + "," + "'" + dEndDate + "'"
		// + "," + Countdays + "," + "'" + phoneNumber + "'" + "," + "'"
		// + SingleOrDouble + "'" + ")");
		if (SingleOrDouble.equals("singleRoom")) {

			sql +=  (100*Countdays)+")";//单人间 100一天
		}
		else 
			sql +=  (200*Countdays)+")";//双人间 200一天
		statement.execute(sql);

		String sql2 = "update  customer set sum=pub+bar+coffee+taxi+fareOfHousing";
		statement.execute(sql2);// 璁＄畻鎬诲笎鐩�
	}

	public static void insertChangeRoomInfor(String name, String roomNumber)
			throws SQLException {

		Statement statement = conn.createStatement();
		String sql1 = "update roominfor set isBooked=1              where roomNumber="
				+ roomNumber;
		String sql2 = "update roominfor set master= " + "'" + name + "'"
				+ "where roomNumber=" + roomNumber;
		statement.execute(sql1);
		statement.execute(sql2);

	}

	public static void updateWhenRegister(String name) throws SQLException {
		Statement statement = conn.createStatement();
		String sql = "update customer set isHasRegister=1 where name=" + "'"
				+ name + "'";
		statement.execute(sql);
	}

	// 鐧昏鏃堕�夋嫨鎴块棿
	public static void updateWhenRegister(String name, String roomNumber)
			throws SQLException {
		Statement statement = conn.createStatement();
		String sql = "update customer set roomNumber=" + roomNumber
				+ " where name=" + "'" + name + "'";
		statement.execute(sql);
	}

	public static Vector getName() throws SQLException,
			UnsupportedEncodingException {

		Statement statement = conn.createStatement();
		String sql = "select * from customer";
		ResultSet rs = statement.executeQuery(sql);
		String name = null;
		Vector v = new Vector();
		while (rs.next()) {
			name = rs.getString("name");
			name = new String(name.getBytes("UTF-8"), "UTF-8");
			v.add(name);
		}
		rs.close();
		return v;
	}

	public static String getMasterofRoom(String roomNumber)
			throws SQLException, UnsupportedEncodingException {
		Statement statement = conn.createStatement();
		String sql = "select * from roominfor where roomNumber=" + roomNumber;
		ResultSet rs = statement.executeQuery(sql);
		String Master = null;
		while (rs.next()) {
			Master = rs.getString("Master");
			Master = new String(Master.getBytes("UTF-8"), "UTF-8");
		}
		return Master;
	}

	public static void changeRoom(String ID1, String ID2) throws SQLException,
			UnsupportedEncodingException { // 鐢ㄤ簬鏇存崲鎴块棿鐨勫嚱鏁�

		Statement statement = conn.createStatement();
		String sql1 = "UPDATE roominfor SET isBooked = 0 WHERE roomNumber = "
				+ ID1;
		statement.execute(sql1); // sql1鏄妸鍘熸埧闂寸殑isBooked灞炴�ф敼涓�0
		String sql2 = "SELECT master FROM roominfor WHERE roomNumber = " + ID1;
		ResultSet rs = statement.executeQuery(sql2);
		String name = null;
		while (rs.next()) {
			name = rs.getString("master");

			name = new String(name.getBytes("UTF-8"), "UTF-8");
		}

		System.out.println(name); // sql2鐢ㄤ簬鑾峰彇鍘熸埧闂寸殑瀹㈡埛鍚嶇О

		String sql11 = "UPDATE customer SET roomNumber =  " + ID2
				+ "   WHERE roomNumber = " + ID1;
		statement.execute(sql11); // sql6鐢ㄤ簬鎶婂鎴疯〃鐨勬埧闂村彿鏀规垚鍙樺寲鍚庣殑

		String sql3 = "UPDATE roominfor" + "" + " SET master = '' "
				+ " WHERE roomNumber = " + ID1;
		statement.execute(sql3); // sql3鐢ㄤ簬鍒犻櫎鍘熸埧闂寸殑瀹㈡埛鍚�
		String sql4 = "UPDATE roominfor SET master = " + "'" + name + "'"
				+ " WHERE roomNumber = " + ID2;
		statement.execute(sql4); // sql4鐢ㄤ簬鎶婂鎴峰鍚嶅～鍏ユ柊鎴块棿鍙风殑鏁版嵁搴撹褰曚腑
		String sql5 = "UPDATE roominfor SET isBooked = 1                WHERE roomNumber = "
				+ ID2;
		statement.execute(sql5);

	}

	// 鍏朵粬鏈嶅姟
	public static void service(boolean a, boolean b, boolean c, boolean d,
			String roomNumber) throws SQLException {
		if (a == true) {
			Statement statement = conn.createStatement();
			String sql = "UPDATE customer SET pub = 50 WHERE roomNumber = "
					+ roomNumber;
			statement.execute(sql);
		}
		if (b == true) {
			Statement statement = conn.createStatement();
			String sql = "UPDATE customer SET bar = 10 WHERE roomNumber = "
					+ roomNumber;
			statement.execute(sql);
		}
		if (c == true) {
			Statement statement = conn.createStatement();
			String sql = "UPDATE customer SET taxi = 20 WHERE roomNumber = "
					+ roomNumber;
			statement.execute(sql);
		}
		if (d == true) {
			Statement statement = conn.createStatement();
			String sql = "UPDATE customer SET coffee = 30 WHERE roomNumber = "
					+ roomNumber;
			statement.execute(sql);
		}
		Statement statement = conn.createStatement();
		String sql2 = "UPDATE  customer SET sum=pub+bar+taxi+coffee+fareOfHousing WHERE roomNumber = "+roomNumber;
		statement.execute(sql2);// 璁＄畻鎬诲笎鐩�

	}

	public static void checkout(String roomNumber) throws SQLException {
		Statement statement = conn.createStatement();
		String sql = "UPDATE roominfor SET isBooked = 0 WHERE roomNumber = "
				+ roomNumber;
		String sql2 = "UPDATE roominfor SET master = "+"'"+ "'"+ "WHERE roomNumber = "
				+ roomNumber;
		statement.execute(sql);
		statement.execute(sql2);
		//鍒犻櫎customer涓汉璁板綍
		String sql3 = "DELETE from customer  WHERE roomNumber = "
				+ roomNumber;
		statement.execute(sql3);
	}

	// 鏍规嵁name鏌ヨ娑堣垂璁板綍
	public static Vector consumption(String name) throws SQLException,
			UnsupportedEncodingException {
		Statement statement = conn.createStatement();
		String sql = "SELECT * FROM customer WHERE name = " + "'" + name + "'";
		ResultSet rs = statement.executeQuery(sql);
		int pub = 0;
		int bar = 0;
		int taxi = 0;
		int coffee = 0;
		int fareOfHousing = 0;
		int sum = 0;
		while (rs.next()) {
			pub = rs.getInt("pub");
			bar = rs.getInt("bar");
			taxi = rs.getInt("taxi");
			coffee = rs.getInt("coffee");
			fareOfHousing = rs.getInt("fareOfHousing");
			sum = rs.getInt("sum");
		}
		Vector v = new Vector();
		v.add(name);
		v.add(String.valueOf(pub));
		v.add(String.valueOf(bar));
		v.add(String.valueOf(taxi));
		v.add(String.valueOf(coffee));
		v.add(String.valueOf(fareOfHousing));
		v.add(String.valueOf(sum));
		System.out.println(String.valueOf(pub));
		// return String.valueOf(pub);//鏁板瓧杞崲涓哄瓧绗︿覆
		return v;
	}
}

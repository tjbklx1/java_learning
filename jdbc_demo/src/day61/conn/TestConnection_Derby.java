package day61.conn;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

public class TestConnection_Derby {
	/**
	 * 此方法用来测试mysql中获得数据库,表的方法.
	 * @throws Exception
	 */
	@Test
	public void testDatabasesAndTables1() throws Exception{
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		String url = "jdbc:derby://172.22.15.228:1531/sys_config"; 
		Connection con = DriverManager.getConnection(url, "derby", "test.db");
		System.err.println("getConnection: "+con);
		
		/** 获得数据库的集合*/
		DatabaseMetaData databaseMetaData= con.getMetaData();
		ResultSet catalogsResultSet =databaseMetaData.getSchemas();	//获得模式
		while(catalogsResultSet.next()){
			// 数据库名称
			String catalog = catalogsResultSet.getString("TABLE_SCHEM"); 
			System.out.println(catalog);
		}
		con.close();
		
	}
	
	@Test
	public void testDatabasesAndTables2() throws Exception{
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		String url = "jdbc:derby://172.22.15.228:1531/sys_config"; 
		Connection con = DriverManager.getConnection(url, "derby", "test.db");
		System.err.println("getConnection: "+con);
		
		/** 获得数据库的集合*/
		DatabaseMetaData databaseMetaData= con.getMetaData();
		ResultSet catalogsResultSet =databaseMetaData.getSchemas();	//获得模式
		while(catalogsResultSet.next()){
			// 数据库名称
			String catalog = catalogsResultSet.getString("TABLE_SCHEM"); 
			System.out.println(catalog);
			String[] types = { "TABLE" };
			ResultSet tablesResultSet =databaseMetaData.getTables(catalog, null, null, types);
			while(tablesResultSet.next()){
				// 数据库表名称
				String tables = tablesResultSet.getString("TABLE_NAME"); 
				System.out.println(catalog+"\t : \t"+tables);
			}
			System.out.println("-------------------------------");
		}
		con.close();
		
	}
	@Test
	public void typeOfConlumn() throws Exception{
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		String url = "jdbc:derby://172.22.15.228:1531/sys_config"; 
		Connection con = DriverManager.getConnection(url, "derby", "test.db");
		System.err.println("getConnection: "+con);
		
		
		String sql ="select * from MONITORCFG.CLUSTERS  ";
		PreparedStatement  statment=con.prepareStatement(sql);
		ResultSet resultSet =statment.executeQuery();
		ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
		
		int num =resultSetMetaData.getColumnCount();
		for(int i =1 ;i<=num;i++){
			String name=resultSetMetaData.getColumnName(i);
			String type=resultSetMetaData.getColumnTypeName(i);
			System.out.println(name+":"+type);
		}
		
		con.close();
	}
	
	@Test
	public void dataOfConlomn() throws Exception{
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		String url = "jdbc:derby://172.22.15.228:1531/sys_config"; 
		Connection con = DriverManager.getConnection(url, "derby", "test.db");
		System.err.println("getConnection: "+con);
		
		
		String sql ="select * from MONITORCFG.CLUSTERS  ";
		
		PreparedStatement  pstatment=con.prepareStatement(sql);
		ResultSet resultSet =pstatment.executeQuery();
		ResultSetMetaData resultSetMetaData=pstatment.getResultSet().getMetaData();
		
		int num =resultSetMetaData.getColumnCount();
		for(int i =1 ;i<=num;i++){
			String name=resultSetMetaData.getColumnName(i);
			String type=resultSetMetaData.getColumnTypeName(i);
			System.out.println(name+":"+type);
		}
		System.out.println("-----------------");
		
		while(resultSet.next()){
			for(int i=1;i<=num;i++){
				System.out.print(resultSet.getString(i)+"\t");
			}
			System.out.println();
		}
		
		con.close();
	}
}

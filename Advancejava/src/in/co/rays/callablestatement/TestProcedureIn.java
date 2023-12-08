package in.co.rays.callablestatement;

	import java.sql.CallableStatement;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;

	public class TestProcedureIn {

		public static void main(String[] args) throws Exception {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");

			CallableStatement callStmt = conn.prepareCall("{CALL empIN(?)}");

			callStmt.setInt(1, 1);

			callStmt.execute();

			ResultSet rs = callStmt.getResultSet();

			while (rs.next()) {

				System.out.print(rs.getInt(1));
				System.out.print("\t"+rs.getString(2));
				System.out.println("\t"+rs.getInt(3));

			}

		}

	}


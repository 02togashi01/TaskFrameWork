package utill;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutill {
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/axizdb_web", "axizuser", "axiz");
		} catch (Exception e) {
			// 本来は専用の例外クラスを作成したほうがよい
			throw new RuntimeException(e);
		}
	}
}

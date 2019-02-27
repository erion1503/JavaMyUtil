package net.erion1107.javaMyUtil.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.erion1107.javaMyUtil.bean.Sample1;
import net.erion1107.javaMyUtil.bean.Sample2;
import net.erion1107.javaMyUtil.common.Constants;
import net.erion1107.javaMyUtil.common.IBaseLogic;

/**
 * 動的オブジェクト生成処理ロジック
 * @author ERION1107
 *
 */
public class GenericObjectLogic implements IBaseLogic {

	// ロガー
		private static Logger logger = LoggerFactory.getLogger(Constants.Logger);

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {

		ResourceBundle rs = ResourceBundle.getBundle(Constants.SYSTEM);

		Connection conn = null;
		Statement st = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			// TODO DB接続
			String uri = ""; // TODO プロパティからDB接続情報を取得する
			conn = DriverManager.getConnection(uri);
			st = conn.createStatement();

			// SQL実行
			String sql = "SELECT * FROM TABLE_LIST ORDER BY 1";

			// sql文の実行結果を取得（データベースからの値）
		    ResultSet rset = st.executeQuery(sql);

			// SQL実行
			sql = "SELECT * FROM SAMPLE1 ORDER BY 1";

			// sql文の実行結果を取得（データベースからの値）
		    rset = st.executeQuery(sql);

		    @SuppressWarnings("rawtypes")
			ArrayList list1 = new ArrayList();

		   // データベースから取得した値がある間、
		      while(rset.next()) {
		        // OrdersDTOクラスのインスタンスを生成
		        Sample1 dto = new Sample1();
		        // カラムorder_idの値をフィールドorder_idにセット
		        dto.setId(rset.getInt("id"));
		        // カラムorder_dateの値をフィールドorder_dateにセット
		        dto.setName(rset.getString("name"));
		        // インスタンスをListに格納
		        list1.add(dto);
		        // while文で次のレコードの処理へ?
		      }

		    sql = "SELECT * FROM SAMPLE2 ORDER BY 1";
			// sql文の実行結果を取得（データベースからの値）
		    rset = st.executeQuery(sql);

		      List<Sample2> list2 = new ArrayList<Sample2>();

		   // データベースから取得した値がある間、
		      while(rset.next()) {
		        // OrdersDTOクラスのインスタンスを生成
		        Sample2 dto2 = new Sample2();
		        // カラムorder_idの値をフィールドorder_idにセット
		        dto2.setId(rset.getInt("id"));
		        // カラムorder_dateの値をフィールドorder_dateにセット
		        dto2.setName(rset.getString("name"));
		        // インスタンスをListに格納
		        list2.add(dto2);
		        // while文で次のレコードの処理へ?
		      }

		      logger.debug(String.format("list1.size()=[%s]", list1.size()));
		      logger.debug(String.format("list2.size()=[%s]", list2.size()));

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
	        // (5) 後始末(インスタンスの正常クローズ)
	        try {
				st.close();
		        conn.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	}

}

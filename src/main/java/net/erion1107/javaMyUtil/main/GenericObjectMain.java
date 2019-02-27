/**
 *
 */
package net.erion1107.javaMyUtil.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.erion1107.javaMyUtil.common.BaseMain;
import net.erion1107.javaMyUtil.common.Constants;
import net.erion1107.javaMyUtil.logic.GenericObjectLogic;

/**
 * 動的オブジェクト生成処理メインクラス
 * @author ERION1107
 *
 */
public class GenericObjectMain extends BaseMain {
	// ロガー
	private static Logger logger = LoggerFactory.getLogger(Constants.Logger);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 共通初期化処理
		int ret = init();

		// ロジック生成
		GenericObjectLogic logic = new GenericObjectLogic();

		// ロジック実行
		logic.execute();

		//返却コード出力
		logger.info(String.format("返却コード=[%s]", ret));
	}

}

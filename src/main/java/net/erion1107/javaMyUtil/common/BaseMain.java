package net.erion1107.javaMyUtil.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 基底クラス
 * @author ERION1107
 *
 */
public class BaseMain {

	/**
	 * 初期化処理
	 * @return
	 */
	public static int init(){
		// ret = -1 異常終了
		int ret = -1;

		Logger logger = LoggerFactory.getLogger(Constants.Logger);

		logger.info("基底クラス開始");


		// 正常終了の場合、0を返す
		ret = 0;

		return ret;
	}
}

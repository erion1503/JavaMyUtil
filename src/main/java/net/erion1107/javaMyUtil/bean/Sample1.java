package net.erion1107.javaMyUtil.bean;

import java.io.Serializable;

/**
 * サンプルクラス1
 * @author ERION1107
 *
 */
public class Sample1 implements Serializable {
	private int id;
	private String name;

	// -------- constractor --------
	public Sample1() {
	}

	// -------- getter setter --------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String string) {
		this.name = string;
	}


}

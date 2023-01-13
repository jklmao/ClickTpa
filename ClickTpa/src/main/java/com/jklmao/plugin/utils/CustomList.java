package com.jklmao.plugin.utils;

import java.util.ArrayList;
import java.util.List;

public class CustomList {

	private TeleportMode mode;
	private List<TpaInfoList> tpaList = new ArrayList<>();

	public TeleportMode getMode() {
		return mode;
	}

	public void setMode(TeleportMode mode) {
		this.mode = mode;
	}

	public List<TpaInfoList> getTpaList() {
		return tpaList;
	}

}

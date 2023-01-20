package com.jklmao.plugin.utils;

import java.util.ArrayList;
import java.util.List;

import com.jklmao.plugin.enums.TeleportMode;

public class CustomList {

	private List<TpaInfoList> tpaList = new ArrayList<>();
	private TeleportMode mode = TeleportMode.DEFAULT;

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

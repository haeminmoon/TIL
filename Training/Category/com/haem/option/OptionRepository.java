package com.haem.option;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.haem.calculator.ChargeCalculator;
import com.haem.calculator.CommitionCalculator;
import com.haem.calculator.DiscountCalculator;

public class OptionRepository {
	Map<String,Option> optionData;

	public OptionRepository() {
		init();
	}
	private void init() {
		optionData = new HashMap<>();
		optionData.put("W",new Option("W", 120000, "윈도우", "윈도우 사전 설치", new ChargeCalculator()));
		optionData.put("NA",new Option("NA", 50000, "윈도우", "윈도우 사전 설치", new DiscountCalculator()));
		optionData.put("Q",new Option("Q", 20000, "윈도우", "윈도우 사전 설치", new ChargeCalculator()));
		optionData.put("A",new Option("A", 3, "윈도우", "윈도우 사전 설치", new CommitionCalculator()));
	}
	public Option getOption(String code) {
		return optionData.get(code);
	}
	public List<Option> getOptionList(List<String> codeList) {
		List<Option> optionList = new ArrayList<Option>();
		for (String code : codeList) {
			optionList.add(getOption(code));
		}
		return optionList;
	}
}

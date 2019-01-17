package com.java.ejb_test_project.stateless;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless(name="SearchFacadeBean")
public class SearchFacadeBean implements SearchFacade,SearchFacadeLocal,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7244464564320124390L;

	public SearchFacadeBean() {}
	
	private Map<String,String> countryMap= new HashMap<>();
	
	@PostConstruct
	public void initializeCountryWineList() {
		countryMap.put("Australia", "Sauvignon Blanc");
		countryMap.put("Australia", "Grenache");
		countryMap.put("France","Gewurztraminer");
		countryMap.put("France","Bordeaux");
	}

	@Override
	public List<String> wineSearch(String wineType) {
		List<String> wineList = new ArrayList<>();
		if (wineType.equals("Red")) {
		wineList.add("Bordeaux");
		wineList.add("Merlot");
		wineList.add("Pinot Noir");
		}
		else if (wineType.equals("White")) {
		wineList.add("Chardonnay");
		}
		return wineList;
	};
	
	@PreDestroy
	public void destroyWineList() {
		countryMap.clear();
	}
	
}

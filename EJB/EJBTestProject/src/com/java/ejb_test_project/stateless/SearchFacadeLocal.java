package com.java.ejb_test_project.stateless;

import java.util.List;

import javax.ejb.Local;

@Local
public interface SearchFacadeLocal {
	List<String> wineSearch(String wineType);
}

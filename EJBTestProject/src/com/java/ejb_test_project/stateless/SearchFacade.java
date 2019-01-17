package com.java.ejb_test_project.stateless;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface SearchFacade {
	List<String> wineSearch(String wineType);
}

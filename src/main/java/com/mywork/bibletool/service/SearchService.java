package com.mywork.bibletool.service;

import com.mywork.bibletool.VerseData;

import java.util.ArrayList;
import java.util.List;

public interface SearchService {

    public List<VerseData> search(String searchText);

}

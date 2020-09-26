package com.mywork.bibletool.service;

import com.mywork.bibletool.ScanSigaoTxt;
import com.mywork.bibletool.VerseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SearchServiceImpl implements SearchService{

    private final String bibleFilePath;
    private List<VerseData> bibleVerse;

    public SearchServiceImpl(@Value("${bible.text.path}") String bibleFilePath){

        log.debug("bibleFilePath: " + bibleFilePath);
        log.info("Start to read...");
        ScanSigaoTxt scanTxt = new ScanSigaoTxt();
        bibleVerse = scanTxt.readFile(bibleFilePath);
        log.info("End of reading....");
        log.info("Size of reading: " + bibleVerse.size());
        this.bibleFilePath = bibleFilePath;
    }

    public List<VerseData> search(String searchText){

        List<VerseData> resultList = new ArrayList<>();

        for (VerseData d : bibleVerse) {

            if (d.getText().contains(searchText)){
                resultList.add(d);
            }

        }
        log.debug("Search result for {}: {}", searchText, resultList.size());

        return resultList;
    }
}

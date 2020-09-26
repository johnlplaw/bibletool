package com.mywork.bibletool.controller;

import com.mywork.bibletool.VerseData;
import com.mywork.bibletool.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Controller
 */
@RestController
public class WebController {

    /**
     * Search service
     */
    private final SearchService searchService;

    /**
     * Contructor
     * @param searchService Search Service
     */
    public WebController(SearchService searchService){
        this.searchService = searchService;
    }

    /**
     * Get Hello
     * @return
     */
    @GetMapping(path = "/getHello")
    public String getHello(){
        return "hello";
    }

    /**
     * Search service
     * @param searchValue Search word
     * @return The result
     */
    @GetMapping(path = "/search/{searchValue}")
    public List<VerseData> getResult(@PathVariable String searchValue){

        List<VerseData> list = null;

        list = searchService.search(searchValue);

        return list;

    }
}

package com.example.mockito.relay;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 04/07/2017
 */
public class ArticleManager {
    private ArticleCalculator calculator;
    private ArticleDatabase database;
    private UserProvider userProvider;

    public ArticleManager(ArticleCalculator calculator, ArticleDatabase database,
                          UserProvider userProvider) {
        this.calculator = calculator;
        this.database = database;
        this.userProvider = userProvider;
    }

    public void initiateArticle(){

    }


}


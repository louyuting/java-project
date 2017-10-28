package com.crawl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crawl.zhihu.ZhiHuHttpClient;

/**
 * 爬虫入口
 */
public class Main {

    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String args []){
        //ProxyHttpClient.getInstance().startCrawl();
        ZhiHuHttpClient.getInstance().startCrawl();
        logger.error("heheheheheheh12345678765432");
    }
}

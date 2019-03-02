package com.example;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App {

    private static void calcutor(){
        for (long i=0; i<100000000000l; ){
            i++;
        }
    }

    private static class ThreadTest implements Runnable{
        @Override
        public void run() {
            calcutor();
        }
    }


    public static void main( String[] args ) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i=0; i<4; i++){
            executorService.submit(new ThreadTest());
        }


        while (true){

        }

    }
}

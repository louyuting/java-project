package com.example;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App
{

    private static class DTO{
        private Date date;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }
    public static void main( String[] args )
    {

        DTO date = new DTO();
        date.setDate(new Date());
        System.out.println();
    }
}

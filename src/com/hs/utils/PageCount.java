package com.hs.utils;

public class PageCount {
    public static int getPageCount(int toatal,int pageSize){
        int count=0;
        if((toatal%pageSize)==0) {
            count = (toatal/pageSize);
        }
        else {
            count = (toatal/pageSize)+1;
        }
      return count;
    }
}

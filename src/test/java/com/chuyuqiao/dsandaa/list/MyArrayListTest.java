package com.chuyuqiao.dsandaa.list;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class MyArrayListTest {

    @Test
    public void testMyArrayList(){
        MyArrayList<String> list=new MyArrayList<String>();
        list.add("1");
        list.add("2");
        Iterator iterator=list.iterator();
        Assert.assertThat(iterator.hasNext(),Is.is(true));
    }
}

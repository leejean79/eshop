package com.leejean.hdfsconsumertest;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 测试类
 */
public class TestHDFS {
    @Test
    public void testReadHDFS() throws IOException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        FSDataInputStream in = fs.open(new Path("hdfs://mycluster//user/hive/warehouse/dept/dept .txt"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        IOUtils.copyBytes(in, baos, 1024);
        System.out.println(new String(baos.toByteArray()));
    }

    /**
     *
     * 28/Feb/2017:12:17:48
     */
    @Test
    public void testDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.US);
        Date date = new Date();
        System.out.println(sdf.format(date));

        Date d = sdf.parse("28/Feb/2017:12:17:48");
        System.out.println(d);
        SimpleDateFormat localSDF = new SimpleDateFormat("yyyy/MM/dd/HH/mm",Locale.US);
        System.out.println(localSDF.format(d));
    }

//    @Test
//    public void test1(){
//        String log =/* new String(msg) ;*/ "s203|||192.168.231.1|||-|||28/Feb/2017:15:34:45 +0800|||GET /eshop/phone/mi.html HTTP/1.0|||200|||213|||-|||ApacheBench/2.3|||-";
//        String[] arr = StringUtil.splitLog(log);
//        //主机名
//        String hostname = StringUtil.getHostname(arr);
//        //日期串
//        String dateStr = StringUtil.formatYyyyMmDdHhMi(arr);
//        //path
//        String rawPath = "/user/centos/eshop/raw/" + dateStr + "/" + hostname + ".log";
//        //写入数据到hdfs
//        System.out.println(log);
//    }
}

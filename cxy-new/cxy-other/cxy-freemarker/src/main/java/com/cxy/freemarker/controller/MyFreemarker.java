package com.cxy.freemarker.controller;

import com.cxy.freemarker.pojo.Student;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class MyFreemarker {
    public static void main(String[] args) throws IOException, TemplateException {
        Version version = new Version(2,3,23);
        Configuration configuration = new Configuration(version);
        File file = new File("D:\\cxy\\github\\cxy-new\\cxy-new\\cxy-new\\cxy-other\\cxy-freemarker\\src\\main\\webapp\\WEB-INF\\ftl");
        configuration.setDirectoryForTemplateLoading(file);
        Template template = configuration.getTemplate("muban.html");
        Map<String,Object> dataModel = new HashMap<>();
        dataModel.put("name","troll");
        Student student = new Student();
        student.setName("wjj");
        student.setAge(20);
        dataModel.put("student",student);
        Map<String,Object> map = new HashMap<>();
        map.put("key1","key1Value");
        map.put("key2","key2Value");
        dataModel.put("map",map);
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
        dataModel.put("nums", nums);
        dataModel.put("date", new Date());
        File desFile = new File("D:\\cxy\\github\\cxy-new\\cxy-new\\cxy-new\\cxy-other\\cxy-freemarker\\src\\main\\resources\\html","result.html");
        Writer out =new FileWriter(desFile);
        template.process(dataModel, out);
    }
}

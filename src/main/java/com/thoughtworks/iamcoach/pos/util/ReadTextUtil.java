package com.thoughtworks.iamcoach.pos.util;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class ReadTextUtil {

    public List<String> getText(String fileName) {
        List<String> text = new ArrayList<String>();
        try {
            Path path = FileSystems.getDefault().getPath("src/main/resources/", fileName);
            text =  Files.readAllLines(path);
        } catch (IOException ex) {
            System.out.println("fail read file!");
        }
        return text;
    }
}

package com.catalog.system.domain.bo;

import com.catalog.system.domain.Book;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 电子图书 EBook
 *
 * @author zjd
 * @date 2025-05-09
 */
public class Ebook extends Book {

    public Ebook() {
    }

    public Ebook(String title, Integer type, String author, String isbn, String fileData) {
        super(title, type, author, isbn, fileData);
    }

    @Override
    public String displayInfo() {

        Path path = Paths.get(this.getFileData());
        try {
            String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}

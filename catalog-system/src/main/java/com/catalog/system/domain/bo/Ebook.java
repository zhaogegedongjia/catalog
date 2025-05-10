package com.catalog.system.domain.bo;

import com.catalog.system.domain.Book;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

    @Override
    public String displayInfo() throws UnsupportedEncodingException {
        byte[] blobData = this.getFileData();
        String textDes = new String(blobData, "UTF-8");
        return textDes;
    }

}

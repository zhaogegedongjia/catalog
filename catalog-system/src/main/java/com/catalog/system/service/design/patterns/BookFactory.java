package com.catalog.system.service.design.patterns;

import com.catalog.system.domain.Book;
import com.catalog.system.domain.bo.Ebook;
import com.catalog.system.domain.bo.PaperBook;

import java.nio.charset.CharacterCodingException;

/**
 * 工厂模式
 *
 * @author zjd
 * @date 2025-05-09
 */
public class BookFactory {

    public static Book createBook(Book book) throws CharacterCodingException {
        switch (book.getType()) {
            case 0:
                return new PaperBook(book.getTitle(), book.getType(), book.getAuthor(), book.getIsbn());
            case 1:
                Worker worker=new Worker();
                return new Ebook(book.getTitle(),book.getType(), book.getAuthor(), book.getIsbn(),worker.build(book.getFileData()).getFileData());

            default:
                throw new IllegalArgumentException("Unknown book type");

        }

    }

}

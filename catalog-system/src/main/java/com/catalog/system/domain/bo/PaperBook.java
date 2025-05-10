package com.catalog.system.domain.bo;

import com.catalog.system.domain.Book;
/**
 * 纸质图书 PaperBook
 *
 * @author zjd
 * @date 2025-05-09
 */
public class PaperBook extends Book {

    public PaperBook() {

    }

    @Override
    public String displayInfo() {

        return this.getTitle();

    }

}

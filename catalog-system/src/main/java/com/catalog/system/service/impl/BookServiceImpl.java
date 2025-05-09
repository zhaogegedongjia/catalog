package com.catalog.system.service.impl;

import java.util.List;

import com.catalog.system.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catalog.system.mapper.BookMapper;
import com.catalog.system.domain.Book;

/**
 * 图书Service业务层处理
 * 
 * @author zjd
 * @date 2025-05-09
 */
@Service
public class BookServiceImpl implements IBookService
{
    @Autowired
    private BookMapper bookMapper;

    /**
     * 查询图书
     * 
     * @param id 图书主键
     * @return 图书
     */
    @Override
    public Book selectBookById(String id)
    {
        return bookMapper.selectBookById(id);
    }

    /**
     * 查询图书列表
     * 
     * @param book 图书
     * @return 图书
     */
    @Override
    public List<Book> selectBookList(Book book)
    {
        return bookMapper.selectBookList(book);
    }

    /**
     * 新增图书
     * 
     * @param book 图书
     * @return 结果
     */
    @Override
    public int insertBook(Book book)
    {
        return bookMapper.insertBook(book);
    }

    /**
     * 修改图书
     * 
     * @param book 图书
     * @return 结果
     */
    @Override
    public int updateBook(Book book)
    {
        return bookMapper.updateBook(book);
    }

    /**
     * 批量删除图书
     * 
     * @param ids 需要删除的图书主键
     * @return 结果
     */
    @Override
    public int deleteBookByIds(String[] ids)
    {
        return bookMapper.deleteBookByIds(ids);
    }

    /**
     * 删除图书信息
     * 
     * @param id 图书主键
     * @return 结果
     */
    @Override
    public int deleteBookById(String id)
    {
        return bookMapper.deleteBookById(id);
    }
}

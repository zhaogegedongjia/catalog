package com.catalog.web.controller.business;

import java.nio.charset.CharacterCodingException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.catalog.system.service.design.patterns.BookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.catalog.common.core.controller.BaseController;
import com.catalog.common.core.domain.AjaxResult;
import com.catalog.system.domain.Book;
import com.catalog.system.service.IBookService;
import com.catalog.common.utils.poi.ExcelUtil;
import com.catalog.common.core.page.TableDataInfo;

/**
 * 图书Controller
 * 
 * @author zjd
 * @date 2025-05-09
 */
@RestController
@RequestMapping("/business/book")
public class BookController extends BaseController
{
    @Autowired
    private IBookService bookService;

    /**
     * 根据主键查询图书详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(bookService.selectBookById(id));
    }

    /**
     * 查询图书列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Book book)
    {
        //单例模式，通过ThreadLocal实现分页
        startPage();
        List<Book> list = bookService.selectBookList(book);
        return getDataTable(list);
    }

    /**
     * 导出图书列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, Book book)
    {
        List<Book> list = bookService.selectBookList(book);
        ExcelUtil<Book> util = new ExcelUtil<Book>(Book.class);
        util.exportExcel(response, list, "图书数据");
    }



    /**
     * 新增纸质图书
     */
    @PostMapping
    public AjaxResult add(@RequestBody Book book) throws CharacterCodingException {
        return toAjax(bookService.insertBook(BookFactory.createBook(book)));
    }


    /**
     * 修改图书
     */
    @PutMapping
    public AjaxResult edit(@RequestBody Book book)
    {
        return toAjax(bookService.updateBook(book));
    }

    /**
     * 删除图书，根据前端选择多个id可批量删除
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(bookService.deleteBookByIds(ids));
    }
}

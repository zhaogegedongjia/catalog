package com.catalog.web.controller.tool;

import com.catalog.common.core.controller.BaseController;
import com.catalog.common.core.domain.AjaxResult;
import com.catalog.common.core.page.TableDataInfo;
import com.catalog.common.utils.poi.ExcelUtil;
import com.catalog.system.domain.Book;
import com.catalog.system.service.IBookService;
import com.catalog.system.service.design.patterns.BookFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.CharacterCodingException;
import java.util.List;

/**
 * 图书 Controller
 * 
 * @author zjd
 * @date 2025-05-09
 */
@Api("图书管理")
@RestController
@RequestMapping("/test/book")
public class TestBookController extends BaseController
{
    @Autowired
    private IBookService bookService;

    /**
     * 查询图书列表
     */
    @ApiOperation("列表图书")
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
    @ApiOperation("导出图书列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response, Book book)
    {
        List<Book> list = bookService.selectBookList(book);
        ExcelUtil<Book> util = new ExcelUtil<Book>(Book.class);
        util.exportExcel(response, list, "图书数据");
    }

    /**
     * 根据主键查询图书详细信息
     */
    @ApiOperation("根据主键查询图书")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(bookService.selectBookById(id));
    }

    /**
     * 新增纸质图书
     */
    @ApiOperation("新增图书")
    @PostMapping
    public AjaxResult add(@RequestBody Book book) throws CharacterCodingException {
        return toAjax(bookService.insertBook(BookFactory.createBook(book)));
    }


    /**
     * 修改图书
     */
    @ApiOperation("修改图书实体")
    @PutMapping
    public AjaxResult edit(@RequestBody Book book)
    {
        return toAjax(bookService.updateBook(book));
    }

    /**
     * 删除图书，根据前端选择多个id可批量删除
     */
    @ApiOperation("删除图书，也可根据前端选择多个id可批量删除")
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(bookService.deleteBookByIds(ids));
    }
}

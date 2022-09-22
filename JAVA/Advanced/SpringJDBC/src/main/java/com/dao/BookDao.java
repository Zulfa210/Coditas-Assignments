package com.dao;

import com.bean.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zulfa Attar
 */
public class BookDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int insertBook(Book b){
    int id=0;
        try {
            id= jdbcTemplate.update("insert into jtbookdetails values(?,?,?,?)",
                    null, b.getBookName(), b.getAuthorName(), b.getPrice());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

       return id;
    }
    public int updateBook( String bookName, float bookPrice){

    return (jdbcTemplate.update("update jtbookdetails set price = ? where book_name=?",
            bookPrice, bookName));
    }

    public int deleteBook(String bookName){
        return (jdbcTemplate.update("delete from jtbookdetails where book_name=?",
                 bookName));
    }

    public List<Book> fetchAllBooks(){
        String sql = "select * from JTBookDetails";
        List<Book> lbook = jdbcTemplate.query(sql,new RowMapper(){
            public Book mapRow(ResultSet var1, int var2) throws SQLException{
                Book book = new Book();
                book.setBid(var1.getInt(1));
                book.setBookName(var1.getString(2));
                book.setAuthorName(var1.getString(3));
                book.setPrice(var1.getFloat(4));
                return book;
            }
        }) ;

        return lbook;
    }

    public List<Book> fetchUsingResultSet(int bookId){
        String sql = "select * from JTBookDetails where bid = ?";
        Object values[] = {bookId};

        List<Book> book =(List<Book>) jdbcTemplate.query(sql, values, new ResultSetExtractor(){

            @Override
            public List<Book> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Book> l = new ArrayList<>();
                while (resultSet.next()){
                    Book book1 = new Book();
                    book1.setBid(resultSet.getInt(1));
                    book1.setBookName(resultSet.getString(2));
                    book1.setAuthorName(resultSet.getString(3));
                    book1.setPrice(resultSet.getFloat(4));
                    l.add(book1);
                }

                return l;
            }
        });
        return book;
    }


}

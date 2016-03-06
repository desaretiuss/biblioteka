package org.ikubinfo.biblioteka.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookModel extends DatabaseConnection {

	public boolean addBook(BookBean book) {

		boolean result = false;

		PreparedStatement st = null;

		try {

			String sql = " INSERT INTO `library_database`.`book`("

					+ "`book_title`, " + "`book_author`," + "`book_isbn`," + "`book_deweyCode`," + "`book_language`,"
					+ "`book_year`, " + "`book_publisher`, " + "`book_edition`," + "`book_pages`, " + "`book_copies`) "

					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			conn = getConnection();
			st = conn.prepareStatement(sql);

			st.setString(1, book.getTitle());
			st.setString(2, book.getAuthor());
			st.setString(3, book.getIsbn());
			st.setString(4, book.getDeweyCode());
			st.setString(5, book.getLanguage());
			st.setInt(6, book.getYear());
			st.setString(7, book.getPublisher());
			st.setInt(8, book.getEdition());
			st.setInt(9, book.getPages());
			st.setInt(10, book.getCopies());
			st.setString(1, book.getTitle());

			if (st.executeUpdate() == 0) {
				result = false;
			} else {
				result = true;
			}

			st.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return result;

	}

	public boolean removeBook(String isbn) {

		boolean result = false;

		try {

			PreparedStatement st = null;

			String sql = "DELETE FROM `library_database`.`book` WHERE `book_isbn`=?";

			conn = getConnection();
			st = conn.prepareStatement(sql);

			st.setString(1, isbn);

			if (st.executeUpdate() == 0) {
				result = false;
			} else {
				result = true;
			}

			st.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return result;
	}

	public BookBean getBookByIsbn(String isbn) {

		BookBean book = null;
		
		try {

			ResultSet rs = null;
			PreparedStatement st = null;

			String sql = "SELECT * from `library_database`.`book` WHERE `book_isbn`=?";

			conn = getConnection();
			st = conn.prepareStatement(sql);

			st.setString(1, isbn);

			rs = st.executeQuery();

			book = new BookBean();

			while (rs.next()) {

				book.setTitle(rs.getString("book_title"));
				book.setAuthor(rs.getString("book_author"));
				book.setIsbn(rs.getString("book_isbn"));
				book.setDeweyCode(rs.getString("book_deweyCode"));
				book.setLanguage(rs.getString("book_language"));
				book.setYear(rs.getInt("book_year"));
				book.setPublisher(rs.getString("book_publisher"));
				book.setEdition(rs.getInt("book_edition"));
				book.setPages(rs.getInt("book_pages"));
				book.setCopies(rs.getInt("book_copies"));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return book;

	}

	public boolean updateBook(BookBean book){
		
		boolean result=false;
		
		
		try {

			PreparedStatement st = null;

			String sql = " UPDATE library_database.book " + 
			             " SET  book_title=? , " +
					           "book_author=? ," +
					           "book_deweyCode=? ," +           
					           "book_language=? ," +
					           "book_year=? ," +
					           "book_publisher=? ," +           
					           "book_edition=? ," +
					           "book_pages=? ," +
					           "book_copies=? " +	
					           
					       " WHERE book_isbn=?;";

			conn = getConnection();
			st = conn.prepareStatement(sql);

			st.setString(1, book.getTitle());
			st.setString(2, book.getAuthor());
			st.setString(3, book.getDeweyCode());
			st.setString(4, book.getLanguage());
			st.setInt(5, book.getYear());
			st.setString(6, book.getPublisher());
			st.setInt(7, book.getEdition());
			st.setInt(8, book.getPages());
			st.setInt(9, book.getCopies());
			st.setString(10, book.getIsbn());
			
		
			if (st.executeUpdate() != 0) {
				result = true;
			} 

			st.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
		
		return result;
	}
}

package org.ikubinfo.biblioteka.controller;

import org.ikubinfo.biblioteka.model.BookBean;
import org.ikubinfo.biblioteka.model.BookModel;
import com.opensymphony.xwork2.ActionSupport;

public class LibrarianAction extends ActionSupport {

	private static final long serialVersionUID = -1561313586862332423L;

	private BookBean book;
	private BookModel bookModel = new BookModel();

	public String addBook() {

		String result = ERROR;

		if (bookModel.addBook(book)) {

			addActionMessage(getText("book.add.success"));
			result = SUCCESS;

		} else {

			addActionError(getText("book.add.failure"));

		}

		return result;

	}

	public String removeBook() {

		String result = ERROR;

		if (bookModel.removeBook(book.getIsbn())) {

			addActionMessage(getText("book.remove.success"));
			result = SUCCESS;

		} else {

			addActionError(getText("book.remove.failure"));

		}

		return result;

	}

	/**
	 * Shows a pre- populated form.
	 * 
	 * @return
	 */
	public String editBookData() {

		String result = SUCCESS;

		String isbn = book.getIsbn();

		book = bookModel.getBookByIsbn(isbn);

		return result;

	}

	public String updateBook() {

		String result = ERROR;

		if (bookModel.updateBook(book)) {

			addActionMessage(getText("book.update.success"));
			result = SUCCESS;

		} else {

			addActionError(getText("book.update.failure"));

		}

		return result;

	}

	public BookBean getBook() {
		return book;
	}

	public void setBook(BookBean book) {
		this.book = book;
	}

	public BookModel getBookModel() {
		return bookModel;
	}

	public void setBookModel(BookModel bookModel) {
		this.bookModel = bookModel;
	}

}

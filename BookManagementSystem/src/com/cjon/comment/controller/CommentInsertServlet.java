package com.cjon.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjon.comment.service.CommentService;

/**
 * Servlet implementation class BookCommentInsertServlet
 */
@WebServlet("/bookcommentInsert")
public class CommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력받고
				String isbn = request.getParameter("isbn");
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				String date = request.getParameter("date");
				String text = request.getParameter("text");
								
				String callback = request.getParameter("callback");
				System.out.println("insert Servlet");
				System.out.println(isbn);
				System.out.println(title);
				System.out.println(author);
				System.out.println(date);
				System.out.println(text);
				// 2. 로직처리
				CommentService service = new CommentService();
				boolean result = service.insertCommentBook(isbn, title, author, date, text);
				// 3. 출력처리
				response.setContentType("text/plain; charset=utf8");
				PrintWriter out = response.getWriter();
				out.println(callback + "(" + result + ")");
				out.flush();
				out.close();	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

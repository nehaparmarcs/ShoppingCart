package in.sjsu.controller;

import in.sjsu.dt.UserDO;
import in.sjsu.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public SearchController() {
  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String text = request.getParameter("term");
		System.out.println("Hello from Get Method: " +text);
		UserDO userDAO = new UserDO();
		try {
			ArrayList<User> users  = userDAO.getUsers(text);
			for(User user: users){
				System.out.println(user.getName());
			}
			
			String searchResult = new Gson().toJson(users);
			
			PrintWriter writer = response.getWriter();
			writer.write(searchResult);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	

}
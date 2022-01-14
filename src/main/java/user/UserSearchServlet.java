package user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");	
		String userName = request.getParameter("userName");
		response.getWriter().write(getJSON(userName));
	}
	//Json 만들기
	public String getJSON(String userName) {
		if(userName == null) userName = "";
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		UserDao userDao = new UserDao();
		ArrayList<User> userList = userDao.search(userName);
		for(int i = 0; i< userList.size(); i++) {
			result.append("[{\"value\": \""+ userList.get(i).getUserName()+ "\"},");
			result.append("{\"value\": \""+ userList.get(i).getUserName()+ "\"},");
			result.append("{\"value\": \""+ userList.get(i).getUserName()+ "\"},");
			result.append("{\"value\": \""+ userList.get(i).getUserName()+ "\"}],");
		}
		result.append("]}");
		return result.toString();
	 }

}

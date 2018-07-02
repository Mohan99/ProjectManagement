package com.nacre.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.constants.StringConstants;
import com.nacre.dto.UserDto;

/**
 * Servlet implementation class SessionImgSrv
 */
@WebServlet("/SessionImgSrv")
public class SessionImgSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionImgSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.setContentType("image/jpeg");
	
	 HttpSession session = request.getSession();
	UserDto user = (UserDto) session.getAttribute(StringConstants.SESSION_USER_DTO_CONSTANT);
OutputStream os= response.getOutputStream();
try {
	InputStream is=	user.getImage().getBinaryStream();
	byte[] b =new byte[is.available()];
	while (is.available()>0) {
		os.write(is.read(b, 0,b.length));
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


	 
	 
	 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

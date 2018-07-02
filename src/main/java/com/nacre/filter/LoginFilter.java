package com.nacre.filter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nacre.constants.IntegerConstants;
import com.nacre.constants.StringConstants;
import com.nacre.constants.URLConstants;
import com.nacre.delegate.CommonOperationsDelegate;
import com.nacre.dto.UserDto;
import com.nacre.exception.ImageStreamToByteException;
import com.nacre.exception.InvalidUserDetailsException;
import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.ImageUtil;

/**
 * @author Shraddha
 *  Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
	private static List<String> admin = new ArrayList<>();
	private static List<String> pm = new ArrayList<>();
	private static List<String> devloper = new ArrayList<>();
	private static List<String> teamLead = new ArrayList<>();

	public static final Logger logger = Logger.getLogger(LoginFilter.class);

	/**
	 * @author Shraddha
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	static{
		
		// Reflection api
		Class c = URLConstants.class;
		// taking urls
		Field[] f = c.getDeclaredFields();

		for (int i = 0; i < f.length; i++) {
			//logger.info(">>>>>>: " + f[i]);

			try {

				String fn = f[i].getName();
				String fv = (String) f[i].get(new URLConstants());

				if (fn.contains("TL_")) {
					teamLead.add(fv);

				} else if (fn.contains("ADMIN_")) {
					admin.add(fv);
				} else if (fn.contains("PM_")) {
					pm.add(fv);
				} else if (fn.contains("DEV_")) {
					devloper.add(fv);
				}

			} catch (IllegalArgumentException e1) {

				e1.printStackTrace();
			} catch (IllegalAccessException e1) {

				e1.printStackTrace();
			}

		}
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

	
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		String path = httpReq.getContextPath();

		String URI = httpReq.getRequestURI();
		logger.debug("LOGGR>>>>>>>>" + URI);
		chkUid(httpReq,httpRes);
		if(URI.contains("noti")||URI.contains("Noti") || URI.contains("common_ui/ForGetPass.jsp")){
			chain.doFilter(httpReq, httpRes);
			
		}
		else		if (URI.contains("/login.jsp") || URI.contains("/common_ui/forgetPassword.jsp") || URI.contains("/LoginAction")
				|| URI.contains("/ForgetPasswordAction")) {

			boolean flag = isUserLoogedIn(httpReq, httpRes);
			if (flag) {
				
				
				logger.debug("ALREADY LOGGED IN : " + URI);
				// REDIRECT TO HOMEPAGE

				httpRes.sendRedirect(path +"/common_ui/welcome.jsp");
				

			} else {

				logger.debug("login PAGE");
				chain.doFilter(httpReq, response);
				logger.debug("LOGIN : " + URI);
			}

		} else if (URI.contains("LogoutAction") || URI.contains("/java_script") || URI.contains("/css")
				|| URI.contains("/js") || URI.contains("/index.jsp") || URI.contains("/images")
				|| URI.contains("/font-awesome") || URI.contains("fonts") ||URI.contains("forgetpassword.jsp")) {

			logger.debug("LOGGIN" + URI);
		
			if(URI.contains("index.jsp")){
	
				boolean flag = isUserLoogedIn(httpReq, httpRes);
			
				
				if (flag) {
				logger.debug("LOGGIN welcome" + URI);
				
				httpRes.sendRedirect(path + "/common_ui/welcome.jsp");
				
			}else{
				logger.debug("LOGGIN index" );
				
			chain.doFilter(httpReq, httpRes);
			}
			}else{
				
				chain.doFilter(httpReq, httpRes);
					
			}
		} else {

			System.out.println(">>>>>>>>" + URI);
			boolean flag = isUserLoogedIn(httpReq, httpRes);
			if (flag) {
				logger.debug("checking cookies");
				// chain.doFilter(httpReq, response);

				String roleId = getRollId(httpReq, httpRes);
				if (roleId != null) {
					

					logger.debug("role exist");
					if (roleId.equals(""+IntegerConstants.ROLE_ADMIN)) {
						boolean isValidReq = false;

						for (int i = 0; i < admin.size(); i++) {

							if (URI.contains((String) admin.get(i))) {
								isValidReq = true;
								break;
							}
						}
						if (isValidReq) {

							logger.debug("role exist valid req");
							chain.doFilter(request, response);
						} else {

							logger.debug("role exist in valid req");
							httpRes.sendRedirect(path + "/index.jsp");
							// httpServletResponse.sendRedirect("homepageurl");
						}
					} else if (roleId.equals(""+IntegerConstants.ROLE_PROJECTMANAGER)) {
						boolean isValidReq = false;
						for (int i = 0; i < pm.size(); i++) {
							if (URI.contains((String) pm.get(i))) {
								isValidReq = true;
								break;

							}
						}
						if (isValidReq) {

							logger.debug("role exist valid req");
							chain.doFilter(request, response);
						} else {

							logger.debug("role exist in valid req");
							httpRes.sendRedirect(path + "/common_ui/welcome.jsp");
						}
					} else if (roleId.equals(""+IntegerConstants.ROLE_DEVELOPER)) {
						boolean isValidReq = false;
						for (int i = 0; i < devloper.size(); i++) {
							if (URI.contains((String) devloper.get(i))) {
								logger.debug(devloper.get(i));
								isValidReq = true;
								break;
							}
						}
						if (isValidReq) {

							logger.debug("dev role exist valid req");
							chain.doFilter(request, response);
						} else {

							logger.debug("dev role exist in valid req");
							httpRes.sendRedirect(path + "/index.jsp");

							// httpServletResponse.sendRedirect("homepageurl");
						}
					} else if (roleId.equals(""+IntegerConstants.ROLE_TEAMLEAD)) {
						boolean isValidReq = false;
						for (int i = 0; i < teamLead.size(); i++) {
							if (URI.contains((String) teamLead.get(i))) {
								isValidReq = true;
								break;
							}
						}
						if (isValidReq) {

							logger.debug("role exist valid req");
							chain.doFilter(request, response);
						} else {

							logger.debug("role exist in valid req");
							httpRes.sendRedirect(path + "/index.jsp");

							// httpServletResponse.sendRedirect("homepageurl");
						}
					}
				}
			} else {
				logger.debug("ELSE USER NOT LOGGED IN");
				httpRes.sendRedirect(path + "/index.jsp");

			}
		}

		// System.out.println("ru;;"+c.getValue()+".."+URI);
	}

	private void chkUid(HttpServletRequest httpReq, HttpServletResponse httpRes) {
		// TODO Auto-generated method stub
	
		boolean isExist =true;
		
	HttpSession session=	httpReq.getSession(false);
	if(session==null){
	
		isExist=false;
	}
	
	else{
	if(session.getAttribute(StringConstants.SESSION_USER_DTO_CONSTANT)==null)	
	{
		isExist=false;
	}
		
		
	}
	if(!isExist){

		CommonOperationsDelegate commonOperationsDelegate = new CommonOperationsDelegate();
		String uid = getuId(httpReq);
		
		
		if(uid!=null){
		UserDto userDto;
		try {
			userDto = commonOperationsDelegate.getLoggedInUserDetails(uid);

			session = httpReq.getSession();
			session.setAttribute(StringConstants.SESSION_USER_DTO_CONSTANT, userDto);
		session.setAttribute(StringConstants.SESSION_USERID_CONSTANT, userDto.getUserId());
		session.setAttribute(StringConstants.SESSION_ROLE_CONSTANT, userDto.getRoleId().getRoleId());
			Blob b =userDto.getImage();
			if(b!=null){
		    try {
				session.setAttribute(StringConstants.SESSION_IMG_CONSTANT,  ImageUtil.encodeImage(b.getBinaryStream()));
			} catch (ImageStreamToByteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		} catch (NoConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidUserDetailsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
	}
	
	
		
}

	private String getuId(HttpServletRequest httpReq) {
		// TODO Auto-generated method stub
	
		Cookie [] cookies = httpReq.getCookies();
		if(cookies!=null){
			for (int ind = 0; ind < cookies.length; ind++) {
				if(cookies[ind].getName().equals(StringConstants.SESSION_USERID_CONSTANT)){
					return cookies[ind].getValue();
				}
			}
			
		}
		return null;
	}

	boolean isUserLoogedIn(HttpServletRequest req, HttpServletResponse response) {

		Cookie[] myCookie = req.getCookies();

		boolean isUserCookieAvailable = false;
		if (myCookie != null) {
			for (int i = 0; i < myCookie.length; i++) {
				Cookie c = myCookie[i];
				if (c.getName().equals(StringConstants.SESSION_USERID_CONSTANT)) {
					isUserCookieAvailable = true;
					break;
				}
			}
		}
		return isUserCookieAvailable;

	}

	String getRollId(HttpServletRequest req, HttpServletResponse res) {
		Cookie myCookie[] = req.getCookies();
		String roleId = null;
		if (myCookie != null) {
			boolean isUserCookieAvailable = false;
			// boolean isUserCookieAvailable = false;

			for (int i = 0; i < myCookie.length; i++) {
				Cookie c = myCookie[i];
				if (c.getName().equals(StringConstants.SESSION_ROLE_CONSTANT)) {
					roleId = c.getValue();
					break;
				}
			}
		}
		return roleId;

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}

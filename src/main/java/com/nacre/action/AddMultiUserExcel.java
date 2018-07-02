package com.nacre.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nacre.daoi.UserManagementDaoI;
import com.nacre.daoi.daoimpl.UserManagementDaoImpl;
import com.nacre.delegate.UserManagementDelegate;
import com.nacre.dto.RoleDto;
import com.nacre.dto.UserDto;
import com.nacre.exception.NoConnectionException;
import com.nacre.uitl.EmailUtilty;

/**
 * @author Avinash Servlet implementation class AddMultiUserExcel Multiple user
 *         Details add through ExcelSheet
 */
@WebServlet("/AddMultiUserExcels")
@MultipartConfig
public class AddMultiUserExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMultiUserExcel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		// create UserDto object
		UserDto udto = null;
		// Create File object
		Part part = request.getPart("file");
		System.out.println(part);
		InputStream is = part.getInputStream();
		// new FileInputStream("C:/Users/DELL/Desktop/addUserMulti.xlsx");
		

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(is);

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Iterate through each rows one by one
		Iterator<?> rowIterator = sheet.iterator();

		// create List
		List<UserDto> list = new ArrayList<>();

		while (rowIterator.hasNext()) {
			Row row = (Row) rowIterator.next();

			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();
			int count = 0;
			udto = new UserDto();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				count++;

				// Check the cell type and format accordingly
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					if (count == 5) {
						RoleDto rdto = new RoleDto();
						rdto.setRoleId(new Integer((int) cell.getNumericCellValue()));
						System.out.println(rdto.getRoleId());
						udto.setRoleId(rdto);
					} else if (count == 3) {
						
						//udto.setMobileNo(cell.getNumericCellValue()+"");
						//System.out.println(cell.getNumericCellValue());
						if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						    String str = NumberToTextConverter.toText(cell.getNumericCellValue());
						    udto.setMobileNo(str);
						    System.out.println(str);
						}
					}
					break;
				case Cell.CELL_TYPE_STRING:
					if (count == 1) {
						udto.setFirstName(cell.getStringCellValue());
						System.out.println(cell.getStringCellValue());
					} else if (count == 2) {
						udto.setEmail(cell.getStringCellValue());
						System.out.println(cell.getStringCellValue());
					} else if (count == 4) {
						udto.setGender(cell.getStringCellValue());
						System.out.println(cell.getStringCellValue());
					}
					break;
				}// switch
			} // while

			// password Automatically generated randomly
			Random rnd = new Random();
			udto.setPassword("P" + rnd.nextInt() + "M");

			list.add(udto);

		} // while cell

		System.out.println("<<" + list);
		// create the delegate object
		UserManagementDelegate umdelegate = new UserManagementDelegate();

		List<UserDto> i = null;
		try {
			i = umdelegate.addMultiUEXcel(list);
			if (i.size() > 0) {
				request.getSession().setAttribute("invalidEmails", i);
			} else {

				request.getSession().setAttribute("Success", "ADDED SUCCESSFULLY");

			}
			System.out.println(">>" + i);

		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("Error", "PLEASE TRY LATER");
			System.out.println("err");
		}
		// forword the Jsp page request sent message
		response.sendRedirect("jsp/addUserNewCreate.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

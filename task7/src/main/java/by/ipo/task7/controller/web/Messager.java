package by.ipo.task7.controller.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import by.ipo.task7.bean.Order;
import by.ipo.task7.service.exception.ServiceException;
import by.ipo.task7.service.factory.ServiceFactory;

/**
 * Servlet implementation class Messager
 */
@WebServlet
@MultipartConfig(location = "")
public class Messager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		DiskFileItemFactory dfit = new DiskFileItemFactory();
		
		ServletContext sc = this.getServletConfig().getServletContext();
		File temp = (File) sc.getAttribute("javax.servlet.context.tempdir");
		dfit.setRepository(temp);

		ServletFileUpload sfu = new ServletFileUpload(dfit);
		List<FileItem> reqList = null;

		try {
			reqList = sfu.parseRequest(request);
		} catch (FileUploadException e2) {
			e2.printStackTrace();
		}
		
		FileItem file = null;
		String path = null;
		try {
			file = reqList.get(0);
			path = temp.getCanonicalFile() + File.separator + file.getName();
			file.write(new File(path));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String parsingType = reqList.get(1).getString();
		
		if ((path != null) && (parsingType != null)) {

			try {
				List<Order> orders = ServiceFactory.getInstance().getXMLParsingService()
						.parseXML(path, parsingType);
				request.setAttribute("orderList", orders);
				request.getRequestDispatcher("/MainPage.jsp").forward(request, response);
				
			} catch (ServiceException e) {
				out.println(e.getMessage());
			} 
		}
		Files.delete(Paths.get(path));
	}
}

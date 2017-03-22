package com.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.FileUtils;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {

	private static final long	serialVersionUID	= 1L;
	private static Upload		uploadServletInstance;

	private Upload() {
		super();
	}

	public static Upload getInstance() {
		if (uploadServletInstance == null) {
			uploadServletInstance = new Upload();
		}
		return uploadServletInstance;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public String getComputerName(String ipAddress) {
		String hostname = "Unknown";
		try {
			InetAddress addr;
			addr = InetAddress.getByName(ipAddress);
			hostname = addr.getHostName();
		} catch (UnknownHostException ex) {
			System.out.println("Hostname can not be resolved");
		}
		return hostname;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String path = (String) session.getAttribute("editorFilePath");
		String data = request.getParameter("textAreaContent");
		StringBuffer buffer = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(request.getServletContext().getRealPath(path)));
			int i;
			while ((i = br.read()) != -1) {
				buffer.append((char) i);
			}
		} catch (IOException e) {
		}

		String textBeforeChange = buffer.toString();
		String textAfterChange = data;
		if (textAfterChange != null)
			if (!Objects.equals(textBeforeChange, textAfterChange))
				logChangeData(request, textBeforeChange, textAfterChange, path);

		try {
			FileWriter fw = new FileWriter(request.getServletContext().getRealPath(path), false);
			fw.write(textAfterChange == null ? textBeforeChange : textAfterChange);
			fw.flush();
		} catch (IOException e) {
		}
		RequestDispatcher rd = request.getRequestDispatcher("JsonFileEditor");
		if (!response.isCommitted()) {
			rd.forward(request, response);
		}
	}

	@SuppressWarnings("deprecation")
	private void logChangeData(HttpServletRequest request, String textBeforeChange, String textAfterChange, String path) throws UnknownHostException {
		Date date = new Date();

		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		int monthOfYear = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		String dayOfMonthStr = String.valueOf(dayOfMonth);
		String dmonthOfYearStr = String.valueOf(monthOfYear);
		String yearStr = String.valueOf(year);

		String folderPath = dayOfMonthStr + "_" + dmonthOfYearStr + "_" + yearStr;
		String filePath = request.getRemoteHost() + "_" + String.valueOf(date.getHours()) + "_" + String.valueOf(date.getMinutes()) + "_"
		        + String.valueOf(date.getSeconds());
		String fileServerChangesLogDirectory = request.getServletContext().getRealPath("files\\fileServerChangeLog");
		FileUtils.createDirectory(new File(fileServerChangesLogDirectory), folderPath);
		try {
			@SuppressWarnings("resource")
			FileWriter fw = new FileWriter(fileServerChangesLogDirectory + "\\" + folderPath + "\\" + filePath + ".txt", true);
			fw.write("-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t" + new Date().toString() + "-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t\n");

			fw.write("Change made to File :\t\t" + path + "\n");
			fw.write("Computer Name :\t\t" + getComputerName(request.getRemoteAddr()) + "\n");
			fw.write("IP Addr :\t\t" + request.getRemoteAddr() + "\n");
			fw.write("Client Browser :\t\t" + request.getHeader("User-Agent") + "\n");
			fw.write("\n-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t" + "Text Before Change" + "-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t\n"
			        + textBeforeChange);
			fw.write("\n\n\n\n\n\n-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t" + "Text After Change" + "-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t\n"
			        + textAfterChange);
			fw.flush();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}

package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FilePathBuilder")
public class FilePathBuilder extends HttpServlet {

	private static final long		serialVersionUID	= 1L;
	private static FilePathBuilder	filePathBuilderInstance;

	public FilePathBuilder() {
		super();
	}

	public static FilePathBuilder getInstance() {
		if (filePathBuilderInstance == null) {
			filePathBuilderInstance = new FilePathBuilder();
		}
		return filePathBuilderInstance;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<String> paramNameList = Collections.list(request.getParameterNames());
		String editorFilePath = "";

		if (paramNameList.size() > 0) {
			if (paramNameList.get(0).toLowerCase().contains("locators")) {
				String moduleIID = request.getParameter("locatorsModuleSelectorName");
				String browserChoice = request.getParameter("locatorsBrowserSelectorName");
				String deviceSelector = browserChoice.equalsIgnoreCase("android") || browserChoice.equalsIgnoreCase("ios") ? "mobile" : "ui";
				editorFilePath = "/files/fileServerPersistanceDirectory/test/" + moduleIID + "/" + deviceSelector + "/elements/" + browserChoice.toLowerCase()
				        + "/UIElementSetup.json";
			} else if (paramNameList.get(0).toLowerCase().contains("messages")) {
				String moduleIID = request.getParameter("messagesModuleSelectorName");
				String messageType = request.getParameter("messagesMessageTypeSelectorName");
				String messageTypeFileName = messageType.equalsIgnoreCase("client side messages") ? "clientSideMessages.json" : "serverSideMessages.json";
				String platformType = request.getParameter("messagesPlatformSelectorName");
				String deviceSelector = platformType.equalsIgnoreCase("mobile") || platformType.equalsIgnoreCase("ios") ? "mobile" : "ui";
				editorFilePath = "/files/fileServerPersistanceDirectory/test/" + moduleIID + "/" + deviceSelector + "/messages/en/" + messageTypeFileName;
			}
		}
		if (paramNameList.size() == 0) {
			editorFilePath = "/files/fileServerPersistanceDirectory/sqlQueries.json";
		}

		session.setAttribute("editorFilePath", editorFilePath);

		if (!response.isCommitted()) {
			response.sendRedirect("JsonFileEditor");
		}

	}

}

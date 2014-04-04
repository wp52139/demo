package com;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {

	public static void main(String[] args) throws URISyntaxException {
	    abc();  

	}

private static void abc() throws URISyntaxException {
	  
   String resourceBase = findRootPath();
	System.out.println(resourceBase);
	
	
	//此时访问路径就是http://127.0.0.1:port/contextPath
	WebAppContext context=new WebAppContext(resourceBase, "/utopia");
   context.setResourceBase(resourceBase);
   
//   context.addServlet(MyServlet.class, "/abc");
   
   
   Server server = new Server(81);  
   server.setHandler(context);

	try {  
	    server.start();  
	} catch(Exception e) {  
	    e.printStackTrace();  
	}
}

private static String findRootPath() throws URISyntaxException {
	File f=new File(JettyServer.class.getResource("/").toURI());
		f=f.getParentFile();
		f=f.getParentFile();
		String resourceBase="";//容器路径
		resourceBase=f.getPath();
	return resourceBase;
}  


}
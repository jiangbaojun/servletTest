package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

//设置访问活着调用这个Servlet的路径
@WebServlet("/upload")
//说明该Servlet处理的是multipart/form-data类型的请求
@MultipartConfig
public class UpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UpLoadServlet(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		//说明输入的请求信息采用UTF-8编码方式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//Servlet3.0中新引入的方法，用来处理multipart/form-data类型编码的表单
		Part part = request.getPart("file");
		//获取HTTP头信息headerInfo=（form-data; name="file" filename="文件名"）
		String headerInfo = part.getHeader("content-disposition");
		//文件名
		//从HTTP头信息中获取文件名fileName=（文件名）
//		String fileName = headerInfo.substring(headerInfo.lastIndexOf("=") + 2, headerInfo.length() - 1);
//		String name = part.getName(); 	//表单name属性
		String fileName = part.getSubmittedFileName();
		//获得存储上传文件的文件夹路径
		String fileSavingFolder = "/Users/jiangbaojun/data";
		//获得存储上传文件的完整路径（文件夹路径+文件名）
		//文件夹位置固定，文件夹采用与上传文件的原始名字相同
		String fileSavingPath = fileSavingFolder + File.separator + fileName;
		//如果存储上传文件的文件夹不存在，则创建文件夹
		File f = new File(fileSavingFolder + File.separator);
		if(!f.exists()){
			f.mkdirs();
		}
		//将上传的文件内容写入服务器文件中
		part.write(fileSavingPath);

		//不本地保存，也可以获得文件流做后续处理
//		InputStream inputStream = part.getInputStream();

		//输出上传成功信息
		out.println("文件上传成功~！");
	}
}
package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.customer.NoticeDelProcController;
import notice.controller.customer.NoticeDetailController;
import notice.controller.customer.NoticeEditController;
import notice.controller.customer.NoticeEditProcController;
import notice.controller.customer.NoticeRegController;
import notice.controller.customer.NoticeRegProcController;

public class Mydispatcher extends HttpServlet {
	// httpSeverlet을 상속받아 http신호를 받아올 수 있음

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("신호");
		String uri = request.getRequestURI();
		// prohject cotext root부터 notice.do 까지
		// 요청하는거에 따라서 컨트롤러의 조건을 다르게 할 수 있음
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		System.out.println("uri : " + uri);
		System.out.println("conPath : " + conPath);
		System.out.println("com : " + com);

//		NoticeDetailController controller1 = new NoticeDetailController();
//		NoticeEditController controller2 = new NoticeEditController();
		Controller controller = null;

		try {
			if (com.equals("/customer/noticeDetail.do")) {
				controller = new NoticeDetailController();
			} else if (com.equals("/customer/noticeEdit.do")) {
				controller = new NoticeEditController();
			} else if (com.equals("/customer/noticeEditProc.do")) {
				controller = new NoticeEditProcController();
			} else if (com.equals("/customer/noticeReg.do")) {
				controller = new NoticeRegController();
			} else if (com.equals("/customer/noticeRegProc.do")) {
				controller = new NoticeRegProcController();
			} else if (com.equals("/customer/noticeDelProc.do")) {
				controller = new NoticeDelProcController();
			} 
			controller.execute(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

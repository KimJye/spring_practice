package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� �� ��ȸ ó��");
		//1.�˻��� �Խñ� ��ȣ ����
    	String seq = request.getParameter("seq");
    	
    	//2. DB ���� ó��
    	BoardVO vo = new BoardVO();
    	vo.setSeq(Integer.parseInt(seq));
    	
    	BoardDAO boardDAO = new BoardDAO();
    	BoardVO board = boardDAO.getBoard(vo);
    	
    	//3. �˻� ����� ȭ�� ������ ModelAndView�� �����Ͽ� �����Ѵ�.
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("board",board);//Model���� ����
    	mav.setViewName("getBoard");//View ���� ����
    	return mav;
    	/*
    	//3.�˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵��Ѵ�.
   		HttpSession session = request.getSession();
   		session.setAttribute("board", board);
   		return "getBoard";
   		*/
	}
}

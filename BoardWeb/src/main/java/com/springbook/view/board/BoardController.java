package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired // BoardServiceŸ���� BoardServiceImpl ��ü�� ������ ����
	private BoardService boardService;
	
	//�˻� ���� ��� ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����","TITLE");
		conditionMap.put("����","CONTENT");
		return conditionMap;
	}
	/*
	//�� ��� �˻�
	@RequestMapping("/getBoardList.do")
	public String getBoardList(@RequestParam(value="searchCondition",defaultValue="TITLE", required=false) String condition,
						@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
						BoardDAO boardDAO, Model model) {
		System.out.println("�˻� ���� : "+condition);
		System.out.println("�˻� �ܾ� : "+keyword);
		//Model ���� ����
		//model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";// View �̸� ����
	
	}
	*/
	//�� ���
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	//�� ����
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	//�� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	//�� �� ��ȸ
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));// Model ���� ����
		return "getBoard.jsp";// View �̸� ����
	}
	
	//�� ��� �˻�
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		//Null Check
		if(vo.getSearchCondition()==null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");
		//Model ���� ����
		model.addAttribute("boardList",boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}
}

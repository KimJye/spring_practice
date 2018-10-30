package Controller;

import Domain.board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pageutil.PageNumberMaker;
import pageutil.PaginationCriteria;
import persistance.boardDaoIn;

import java.util.List;

@Controller
@RequestMapping(value = "/board")
public class boardController {

    @Autowired boardDaoIn boardDAO;

    @RequestMapping(value = "/test")
    public String insertBoard(){

        board board = new board("나","안녕하세요", "반갑습니다");

        System.out.println("확인");
        int result = boardDAO.insert(board);
        System.out.println("확인2");
        if (result == 1){
            return "/board/success";
        } else {
            return"/board/fail";
        }
    }

    @RequestMapping(value = "/test2")
    public String deleteBoard(int bno){

        System.out.println("확인1");
        int result = boardDAO.delete(bno);
        System.out.println("확인2");
        if (result == 1){
            return "/board/success";
        } else {
            return"/board/fail";
        }

    }

    @RequestMapping(value="listadd")
    public String listadd(){
        int result = 0;

        for(int i=0; i<=123; i++){
            board board = new board("id"+i,"title"+i, "content"+i);
            result = boardDAO.insert(board);
        }
        if (result == 1){
            return "/board/success";
        } else {
            return"/board/fail";
        }
    }

    @RequestMapping(value="/list" , method=RequestMethod.GET)
    public void boardList(Integer page , Integer perPage, Model model) {
        PaginationCriteria c = null;

        if(page != null && perPage != null) {
            c = new PaginationCriteria(page, perPage);
        }else {
            c = new PaginationCriteria();
        }

        List<board> list = boardDAO.selectList(c);
        model.addAttribute("boardList", list);

        PageNumberMaker maker = new PageNumberMaker();
        maker.setCriteria(c);
        int count = boardDAO.getTotalCount();
        maker.setTotalCount(count);
        maker.setPageMakerData();

        model.addAttribute("page",page);
        model.addAttribute("pageMaker", maker);
    }

    @RequestMapping(value="/detail" , method=RequestMethod.GET)
    public void detail(int bno, Model model) {
        board b = boardDAO.selectByBno(bno);
        model.addAttribute("board", b);
    }



}

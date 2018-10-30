package Controller;

import Domain.reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import persistance.replyDaoIn;

import java.util.List;

// 이제껏 설정했던 것을 모두 이용해서 restcontroller를 만들어주면 됩니다.
// 조금 복잡하지만, 주석을 자세하게 달아놨습니다.

/* ResController
뷰가 필요없는 API 서비스에 이용(ajax로만 이용할 controller 이기 때문에 restCtroller 이용)
Jackson 라이브러리를 사용해서 웹에 json 형태로 데이터 표기.
readReplies 메소드가 json 형태로 웹에 데이터 표기

reply 테이블에 데이터가 들어가있다면
http://localhost:8181/replies/all/{bno}
이런 주소로 접근하면 json 형태의 데이터들이 쭉 나옴
*/

@RestController // 설명 위에
@RequestMapping(value = "/replies")
public class replyRestController {

    @Autowired private replyDaoIn replyDAO; // boardController 때와 동일

    @RequestMapping(value = "/all/{no}", method = RequestMethod.GET)
    public ResponseEntity<List<reply>> readReplies(@PathVariable(name = "no") int bno) {

        // ResponseEntity<T>:
        // 응답(response)의 데이터와 HTTP 응답 코드(200, 404, 500, ...)를
        // 함께 클라이언트(브라우저)에게 보내줄 때 사용하는 클래스
        // T: 응답으로 보낼 데이터의 타입
        // 단순히 '객체 + 메시지' 형태의 데이터

        // @PathVariable 어노테이션:
        // URI에 포함된 변수를 읽어서 매개변수에 넣고자 할 때 사용함

        List<reply> list = replyDAO.read(bno);

        // 검색한 댓글 리스트를 ResponseEntity 객체에 넣음
        ResponseEntity<List<reply>> entity = null;
        if (list != null) {
            entity = new ResponseEntity<List<reply>>(list, HttpStatus.OK); // HttpStatus.OK 단순히 200 숫자
        } else {
            entity = new ResponseEntity<List<reply>>(HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST 400 숫자
        }

        return entity; // 뷰가 없어서 바로 객체를 웹에 표기해주는 방식이기 때문에 그냥 return해도 무관
    } // end readReplies()

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Integer> createReply(@RequestBody reply r) {
        // @RequestBody:
        // 요청 패킷의 본체(body)에 포함된 JSON 데이터를
        // 선언된 클래스 타입으로 변환해서 넣어주는 어노테이션

        // Reply 객체를 replyDAO를 이용해서 DB에 insert
        int result = replyDAO.insert(r);

        // insert 결과를 클라이언트로 전송
        ResponseEntity<Integer> entity = null;
        if (result == 1) {
            entity = new ResponseEntity<Integer>(1, HttpStatus.CREATED);
        } else {
            entity = new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
        }

        return entity;
    } // end createReply()

    @RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteReply(@PathVariable(name = "rno") int rno) {

        int result = replyDAO.delete(rno);
        ResponseEntity<String> entity = null;
        if (result == 1) {
            entity = new ResponseEntity<String>("success", HttpStatus.OK);
        } else {
            entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    // 복잡해 보이지만 조회, 생성, 삭제 세가지 기능만하는 세 메소드
    // 끝나면 마지막으로 뷰 처리
}

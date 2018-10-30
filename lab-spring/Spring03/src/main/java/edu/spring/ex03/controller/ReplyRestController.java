package edu.spring.ex03.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex03.domain.Reply;
import edu.spring.ex03.service.ReplyService;

@RestController
@RequestMapping(value = "/replies")
// REST URL과 HTTP 요청 방식
// /replies/all/{bno} + GET ==> 해당 bno의 모든 댓글 검색
// /replies + POST ==> 새로운 댓글 입력
// /replies/{rno} + PUT ==> 해당 rno 댓글의 내용(rtext)을 수정
// /replies/{rno} + DELETE ==> 해당 rno 댓글을 테이블에서 삭제
public class ReplyRestController {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyRestController.class);
	
	@Autowired private ReplyService replyService;

	@RequestMapping(value = "/all/{no}", method = RequestMethod.GET)
	public ResponseEntity<List<Reply>> readReplies(@PathVariable(name = "no") int bno) {
		// ResponseEntity<T>:
		// 응답(response)의 데이터와 HTTP 응답 코드(200, 404, 500, ...)를
		// 함께 클라이언트(브라우저)에게 보내줄 때 사용하는 클래스
		// T: 응답으로 보낼 데이터의 타입
		
		// @PathVariable 어노테이션:
		// URI에 포함된 변수를 읽어서 매개변수에 넣고자 할 때 사용함
		logger.info("readReplies(bno: {})", bno);
		
		// ReplyService를 이용해서 글번호 bno에 달린 댓글을 검색
		List<Reply> list = replyService.select(bno);
		
		// 검색한 댓글 리스트를 ResponseEntity 객체에 넣음
		ResponseEntity<List<Reply>> entity = null;
		if (list != null) {
			entity = new ResponseEntity<List<Reply>>(list, HttpStatus.OK);
		} else {
			entity = new ResponseEntity<List<Reply>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	} // end readReplies()
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Integer> createReply(@RequestBody Reply r) {
		// @RequestBody: 
		// 요청 패킷의 본체(body)에 포함된 JSON 데이터를
		// 선언된 클래스 타입으로 변환해서 넣어주는 어노테이션
		logger.info("createReply(bno: {}, rtext: {}, replier: {})",
				r.getBno(), r.getRtext(), r.getReplier());
		
		// Reply 객체를 ReplyService를 이용해서 DB에 insert
		int result = replyService.insert(r);
		
		// insert 결과를 클라이언트로 전송
		ResponseEntity<Integer> entity = null;
		if (result == 1) {
			entity = new ResponseEntity<Integer>(1, HttpStatus.CREATED);
		} else {
			entity = new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	} // end createReply()
	
	@RequestMapping(value = "/{rno}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateReply(
			@PathVariable(name = "rno") int rno,
			@RequestBody Reply r) {
		logger.info("updateReply(rno: {}, bno: {}, rtext: {}, replier: {})",
				rno, r.getBno(), r.getRtext(), r.getReplier());
		
		// Path Variable의 rno를 Reply 객체에 set한 후
		// ReplyService의 update를 실행
		r.setRno(rno);
		int result = replyService.update(r);
		
		// update 결과를 ResponseEntity에 넣어서 보냄
		ResponseEntity<String> entity = null;
		if (result == 1) {
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	} // end updateReply()
	
	@RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteReply(
			@PathVariable(name = "rno") int rno) {
		logger.info("deleteReply(rno: {})", rno);
		
		int result = replyService.delete(rno);
		ResponseEntity<String> entity = null;
		if (result == 1) {
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
} // end class ReplyRestController


























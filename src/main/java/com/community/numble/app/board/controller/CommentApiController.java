package com.community.numble.app.board.controller;


import com.community.numble.app.board.domain.Comment;
import com.community.numble.app.board.dto.CommentDto;
import com.community.numble.app.board.dto.CommentDto.CommentPostAllDto;

import com.community.numble.app.board.dto.CommentDto.CommentRequest;
import com.community.numble.app.board.dto.CommentDto.CommentResponse;
import com.community.numble.app.board.dto.CommentDto.CommentResult;
import com.community.numble.app.board.service.CommentService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CommentApiController {

	private final CommentService commentService;



	@PostMapping("/numble11/comment/{postid}")
	public ResponseEntity saveComment(@PathVariable("postid") Long postid,@RequestBody CommentRequest request){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new CommentResponse(commentService.saveComment(postid,request)));
	}

	@GetMapping("/numble11/comment/{postid}")
	public ResponseEntity getCommentPostALl(@PathVariable("postid") Long postid){
		List<Comment> findCommnets = commentService.findCommentPost(postid);
		List<CommentPostAllDto> collect = findCommnets.stream()
			.map(m -> new CommentPostAllDto(m.getId(),m.getContent(),m.getLocation(),m.getMember().getId(),m.getPost().getId(),m.getCreateData(),m.getModifiedDate()))
			.collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new CommentResult(collect.size(),collect));
	}

	@PutMapping("/numble11/comment/{commentid}")
	public ResponseEntity updateComment(@PathVariable("commentid") Long commentid,@RequestBody CommentRequest request){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new CommentResponse(commentService.updateComment(commentid,request)));
	}

	@DeleteMapping("/numble11/comment/{commentid}")
	public ResponseEntity deleteComment(@PathVariable("commentid") Long id){
		commentService.deleteComment(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("delete");
	}
}

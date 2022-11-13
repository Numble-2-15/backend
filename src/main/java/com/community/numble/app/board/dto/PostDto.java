package com.community.numble.app.board.dto;

import com.community.numble.app.board.domain.Member;
import com.community.numble.app.board.domain.PostCategory;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

public class PostDto {

	@Data
	public static class CreatePostResponse {
		private Long id;

		public CreatePostResponse(Long id) {
			this.id = id;
		}
	}

	@Data
	public static class CreatePostRequest{
		private String title;
		private String content;

		private String location;

		private Long member;

		private String type;
	}

	@Data
	public static class GetAllPostResponse {
		private Long id;

		public GetAllPostResponse(Long id) {
			this.id = id;
		}
	}

	@Data
	public static class GetAllPostRequest{
		private String title;
		private String content;

		private String location;

		private Long member;

		private String type;
	}

	@Data
	@AllArgsConstructor
	public static class PostResult<T> {
		private int count;
		private T data;
	}

	@Data
	@AllArgsConstructor
	public static class PostAllDto {
		private Long id;
		private String title;
		private String content;
		private String location;
		private PostCategory type;
		private Long memberId;

	}


	@Data
	public static class CreatePostPhotoResponse {
		private Long id;

		public CreatePostPhotoResponse(Long id) {
			this.id = id;
		}
	}

	@Data
	public static class CreatePostPhotoRequest{

		private String title;
		private String content;
		//private List<MultipartFile> imageFiles;


		private String location;

		private Long member;

		private String type;
	}






}

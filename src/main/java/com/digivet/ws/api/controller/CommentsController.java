package com.digivet.ws.api.controller;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.digivet.ws.Shared.dto.CommentDto;
import com.digivet.ws.model.request.CommentDetailsRequestModel;
import com.digivet.ws.model.response.CommentRest;
import com.digivet.ws.service.repositories.CommentsService;
@RestController
@RequestMapping("/digivet/comments")
@CrossOrigin
public class CommentsController {

	@Autowired
	private CommentsService service;
	
	@PostMapping("/create")
	public CommentRest createComment(@RequestBody CommentDetailsRequestModel comment)
	{
		CommentDto storedByComment = new CommentDto();
		CommentDto commentDto = new CommentDto();
		CommentRest returnValue = new CommentRest();
		BeanUtils.copyProperties(comment, commentDto);
		storedByComment = this.service.createComment(commentDto);
		BeanUtils.copyProperties(storedByComment, returnValue);
			
		return returnValue;
	}
	
	@PostMapping("/findComment")
	
	public List<CommentRest> findComment(@RequestBody CommentDetailsRequestModel comment)
	{
		CommentDto commentDto = new CommentDto();
		BeanUtils.copyProperties(comment, commentDto);
		List<CommentDto> storedByCommentDtos = new ArrayList<CommentDto>();
		storedByCommentDtos = this.service.findComment(commentDto);
		List<CommentRest> returnValue = new ArrayList<CommentRest>();
		ModelMapper mapper = new ModelMapper();
		for(CommentDto comments:storedByCommentDtos)
        {
            returnValue.add(mapper.map(comments, CommentRest.class));
        }
		return returnValue;
	}
	
	@DeleteMapping("/deleteComment{id}")
	public List<CommentRest> deleteComment(@Param(value="id") int id)
	{
		this.service.deleteComment(id);
		return null;
		
	}
}

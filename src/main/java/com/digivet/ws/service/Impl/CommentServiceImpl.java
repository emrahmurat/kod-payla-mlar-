package com.digivet.ws.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digivet.ws.Shared.dto.CommentDto;
import com.digivet.ws.entities.Comments;
import com.digivet.ws.repositories.CommentRepository;
import com.digivet.ws.service.repositories.CommentsService;

@Service
public class CommentServiceImpl implements CommentsService {

	@Autowired
	private CommentRepository commentRepository;

	public CommentServiceImpl(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public List<CommentDto> findComment(CommentDto commentDto) {
		String email = commentDto.getVetEmail();
		List<Comments> storedByComments = this.commentRepository.findByVetEmail(email);
		List<CommentDto> returnValue = new ArrayList<CommentDto>();
		ModelMapper mapper = new ModelMapper();
		for(Comments comments:storedByComments)
        {
            returnValue.add( mapper.map(comments, CommentDto.class) );
        }		

		return returnValue;
	}

	@Override
	public CommentDto createComment(CommentDto commentDto) {
		Date date = new Date(System.currentTimeMillis()); 
		CommentDto returnValue = new CommentDto();
		Comments commentsEntity = new Comments();
		BeanUtils.copyProperties(commentDto, commentsEntity);
		commentsEntity.setDate(date);
		Comments storedByComments = new Comments();
		storedByComments = this.commentRepository.save(commentsEntity);
		BeanUtils.copyProperties(storedByComments, returnValue);
		return returnValue;
	}

	@Override
	public CommentDto deleteComment(int id) {
		this.commentRepository.deleteById(id);
		return null;
	}

}

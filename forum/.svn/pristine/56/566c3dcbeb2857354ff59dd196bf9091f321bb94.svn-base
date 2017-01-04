package net.mds.forum.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	CommentDAO commentDAO;
	
	@Override
	public List<CommentVO> getCommentList(int art_no) throws Exception {
		return commentDAO.getCommentList(art_no);
	}
	
	@Override
	public void insertComment(CommentVO commentVO) throws Exception {
		commentDAO.insertComment(commentVO);
	}

	@Override
	public void deleteComment(int com_no) throws Exception {
		commentDAO.deleteComment(com_no);
	}
	
	@Override
	public CommentVO getComment(int com_no) throws Exception {
		return commentDAO.getComment(com_no);
	}
	
	@Override
	public void updateComment(CommentVO commentVO) throws Exception {
		commentDAO.updateComment(commentVO);
	}
}

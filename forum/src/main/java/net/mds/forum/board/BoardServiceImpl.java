package net.mds.forum.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO boardDAO;

	@Override
	public BoardVO getBoard(int boa_no) throws Exception {
		return boardDAO.getBoard(boa_no);
	}

	@Override
	public List<ArticleVO> getArticleList(PageVO pageVO) throws Exception {
		return boardDAO.getArticleList(pageVO);
	}

	@Override
	public long getTotalCount(int boa_no) throws Exception {
		return boardDAO.getTotalCount(boa_no);
	}

	@Override
	public List<BoardVO> getboardList(String boa_url) throws Exception {
		return boardDAO.getboardList(boa_url);
	}

	@Override
	public ArticleVO getArticleDetail(ArticleVO articleVO) throws Exception {
		return boardDAO.getArticleDetail(articleVO);
	}

	@Override
	public void insertArticle(ArticleVO articleVO) throws Exception {
		boardDAO.insertArticle(articleVO);
	}
	
	@Override
	public void plusReadCount(int art_no) throws Exception {
		boardDAO.plusReadCount(art_no);
	}

	@Override
	public void updateArticle(ArticleVO articleVO) throws Exception {
		boardDAO.updateArticle(articleVO);
	}

	@Override
	public void deleteArticle(int art_no) throws Exception {
		boardDAO.deleteArticle(art_no);
	}

	@Override
	public List<BoardVO> getBoardListAll() throws Exception {
		return boardDAO.getboardListAll();
	}
	
	@Override
	public List<ArticleVO> getArticleListFive(int key) throws Exception {
		return boardDAO.getArticleListFive(key);
	}

	@Override
	public List<BoardVO> getsearchList(SearchVO searchVO) throws Exception {
		return boardDAO.getsearchList(searchVO);
	}

	@Override
	public void plusCommentCount(int art_no) throws Exception {
		boardDAO.plusCommentCount(art_no);
	}
	
	@Override
	public int getCommentCount(int art_no) throws Exception {
		return boardDAO.getCommentCount(art_no);
	}

	@Override
	public void minusCommentCount(int art_no) throws Exception {
		boardDAO.minusCommentCount(art_no);
	}

	@Override
	public List<ArticleVO> getSearchArticleList(PageSearchVO pageSearchVO) throws Exception {
		if(pageSearchVO.getSearchCondition().equals("art_title")){
			return boardDAO.getSearchTitleList(pageSearchVO);			
		}else if(pageSearchVO.getSearchCondition().equals("art_content")){
			return boardDAO.getSearchContentList(pageSearchVO);			
		}else if(pageSearchVO.getSearchCondition().equals("user_nick")){
			return boardDAO.getSearchNickList(pageSearchVO);			
		}
		return null;
	}
	
	@Override
	public long getSearchCount(PageSearchVO pageSearchVO) throws Exception {
		if(pageSearchVO.getSearchCondition().equals("art_title")){
			return boardDAO.getSearchTitleCount(pageSearchVO);			
		}else if(pageSearchVO.getSearchCondition().equals("art_content")){
			return boardDAO.getSearchContentCount(pageSearchVO);			
		}else if(pageSearchVO.getSearchCondition().equals("user_nick")){
			return boardDAO.getSearchNickCount(pageSearchVO);			
		}
		return 0;
	}
}

package net.mds.forum.board;

import java.util.List;

public interface BoardService {
	BoardVO getBoard(int boa_no) throws Exception;

	List<ArticleVO> getArticleList(PageVO pageVO) throws Exception;

	long getTotalCount(int boa_no) throws Exception;

	List<BoardVO> getboardList(String boa_url) throws Exception;

	ArticleVO getArticleDetail(ArticleVO articleVO) throws Exception;

	void insertArticle(ArticleVO articleVO) throws Exception;

	void plusReadCount(int art_no) throws Exception;

	void updateArticle(ArticleVO articleVO) throws Exception;

	void deleteArticle(int art_no) throws Exception;

	List<BoardVO> getBoardListAll() throws Exception;

	List<ArticleVO> getArticleListFive(int key) throws Exception;

	List<BoardVO> getsearchList(SearchVO searchVO) throws Exception;

	void plusCommentCount(int art_no) throws Exception;

	int getCommentCount(int art_no) throws Exception;

	void minusCommentCount(int art_no) throws Exception;

	List<ArticleVO> getSearchArticleList(PageSearchVO pageSearchVO) throws Exception;

	long getSearchCount(PageSearchVO pageSearchVO) throws Exception;

}

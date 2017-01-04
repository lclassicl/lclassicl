package net.mds.forum.board;

import java.util.List;

public interface BoardDAO {
	BoardVO getBoard(int boa_no) throws Exception;

	List<ArticleVO> getArticleList(PageVO pageVO) throws Exception;

	long getTotalCount(int boa_no) throws Exception;

	List<BoardVO> getboardList(String boa_url) throws Exception;

	ArticleVO getArticleDetail(ArticleVO articleVO) throws Exception;

	void insertArticle(ArticleVO articleVO) throws Exception;

	void plusReadCount(int art_no) throws Exception;

	void updateArticle(ArticleVO articleVO) throws Exception;

	void deleteArticle(int art_no) throws Exception;

	List<BoardVO> getboardListAll() throws Exception;

	List<ArticleVO> getArticleListFive(int key) throws Exception;

	List<BoardVO> getsearchList(SearchVO searchVO) throws Exception;

	void plusCommentCount(int art_no) throws Exception;

	int getCommentCount(int art_no) throws Exception;

	void minusCommentCount(int art_no) throws Exception;

	List<ArticleVO> getSearchTitleList(PageSearchVO pageSearchVO) throws Exception;
	
	List<ArticleVO> getSearchContentList(PageSearchVO pageSearchVO) throws Exception;
	
	List<ArticleVO> getSearchNickList(PageSearchVO pageSearchVO) throws Exception;

	long getSearchTitleCount(PageSearchVO pageSearchVO) throws Exception;

	long getSearchContentCount(PageSearchVO pageSearchVO) throws Exception;

	long getSearchNickCount(PageSearchVO pageSearchVO) throws Exception;
}

package service;

import domain.ArticleBean;
import java.util.*;

public interface BoardService {
	//Create
	public void addArticle(ArticleBean param);
	//Read
	public ArticleBean findRecentArticle(ArticleBean param);//1개만을 검색하는 일이 없더라도 꼭 만들어야한다.
	public ArticleBean findBySeq(ArticleBean param);//1개만을 검색하는 일이 없더라도 꼭 만들어야한다.
	public List<ArticleBean> findSome(ArticleBean param);
	public List<ArticleBean> boardList();
	//Update
	public void changeContent(ArticleBean param);
	//Delete
	public void removeContent(ArticleBean param);
	//util
	public void changeSeq(int seq);
}

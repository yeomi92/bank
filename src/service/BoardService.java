package service;

import domain.ArticleBean;
import java.util.*;

public interface BoardService {
	//Create
	public void addArticle(ArticleBean param);
	//Read
	public ArticleBean findOne1(ArticleBean param);//1개만을 검색하는 일이 없더라도 꼭 만들어야한다.
	public ArticleBean findOne2(ArticleBean param);//1개만을 검색하는 일이 없더라도 꼭 만들어야한다.
	public Vector<ArticleBean> findSome(ArticleBean param);
	public Vector<ArticleBean> boardList();
	//Update
	public void changeContent(ArticleBean param);
	//Delete
	public void removeContent(ArticleBean param);
}

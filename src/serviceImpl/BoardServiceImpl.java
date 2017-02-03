package serviceImpl;

import java.util.*;
import domain.ArticleBean;
import service.BoardService;

public class BoardServiceImpl implements BoardService{
	private Vector<ArticleBean> list;
	public BoardServiceImpl() {
		list=new Vector<ArticleBean>(100,100);//초기용량: 100, 용량 초과하면 100씩 증가
	}
	@Override
	public void addArticle(ArticleBean param) {
		
	}
	@Override
	public ArticleBean findOne(ArticleBean param) {
		ArticleBean article=new ArticleBean();
		
		return article;
	}

	@Override
	public Vector<ArticleBean> findSome(ArticleBean param) {
		Vector<ArticleBean> list=new Vector<ArticleBean>();
		
		return list;
	}

	@Override
	public Vector<ArticleBean> boardList() {
		Vector<ArticleBean> list=new Vector<ArticleBean>();
		
		return list;
	}

	@Override
	public void changeContent(ArticleBean param) {	
	
	}

	@Override
	public void removeContent(ArticleBean param) {	
	
	}
}

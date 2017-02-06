package serviceImpl;

import java.util.*;
import domain.ArticleBean;
import service.BoardService;

public class BoardServiceImpl implements BoardService{
	private Vector<ArticleBean> list;
	private Iterator<ArticleBean> it;
	public BoardServiceImpl() {
		list=new Vector<ArticleBean>(100,100);//초기용량: 100, 용량 초과하면 100씩 증가
		it=list.iterator();
	}
	@Override
	public void addArticle(ArticleBean param) {
		list.add(param);
	}
	@Override
	public ArticleBean findOne1(ArticleBean param) {
		ArticleBean article=new ArticleBean();
		for(int i=0;i<list.size();i++){
			if(i==(list.size()-1)){
				article=list.get(i);
			}
		}
		return article;
	}
	@Override
	public ArticleBean findOne2(ArticleBean param) {
		ArticleBean article=new ArticleBean();
		for(int i=0;i<list.size();i++){
			if(param.getSeq().equals(list.get(i).getSeq())){
				article=list.get(i);
				break;
			}
		}
		return article;
	}
	@Override
	public Vector<ArticleBean> findSome(ArticleBean param) {
		Vector<ArticleBean> someList=new Vector<ArticleBean>();
		for(int i=0;i<list.size();i++){
			if(param.getUid().equals(list.get(i).getSeq())){
				someList.add(list.get(i));
			}
		}
		return someList;
	}

	@Override
	public Vector<ArticleBean> boardList() {
		return list;
	}

	@Override
	public void changeContent(ArticleBean param) {	
		for(int i=0;i<list.size();i++){
			if(param.getSeq().equals(list.get(i).getSeq())){
				list.get(i).setTitle(param.getTitle());
			}
		}
	}

	@Override
	public void removeContent(ArticleBean param) {
		while(it.hasNext()){
			if(it.next().getSeq().equals(param.getSeq())){
				it.remove();
				break;
			}
		}
	}
}

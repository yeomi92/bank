package serviceImpl;

import java.util.*;
import domain.ArticleBean;
import service.BoardService;

public class BoardServiceImpl implements BoardService{
	private List<ArticleBean> list;
	private int seq;
	public BoardServiceImpl() {
		list=new ArrayList<ArticleBean>();//초기용량: 100, 용량 초과하면 100씩 증가
		seq=1;
	}
	@Override
	public void addArticle(ArticleBean param) {
		param.setSeq(String.valueOf(seq));
		seq++;
		param.setRegdate(Calendar.getInstance().get(Calendar.YEAR)+"년"+(Calendar.getInstance().get(Calendar.MONTH)+1)+"월"+Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"일");
		list.add(param);
	}
	@Override
	public ArticleBean findRecentArticle(ArticleBean param) {
		ArticleBean article=new ArticleBean();
		for(int i=0;i<list.size();i++){
			if(i==(list.size()-1)){
				article=list.get(i);
				list.get(i).setReadCount(String.valueOf((Integer.parseInt((list.get(i).getReadCount()))+1)));
			}
		}
		return article;
	}
	@Override
	public ArticleBean findBySeq(ArticleBean param) {
		ArticleBean article=new ArticleBean();
		for(ArticleBean i:list){
			if(param.getSeq().equals(i.getSeq())){
				article=i;
				i.setReadCount(String.valueOf((Integer.parseInt((i.getReadCount()))+1)));
				break;
			}
		}
		return article;
	}
	@Override
	public List<ArticleBean> findSome(ArticleBean param) {
		List<ArticleBean> someList=new ArrayList<ArticleBean>();
		for(ArticleBean i:list){
			if(param.getUid().equals(i.getUid())){
				someList.add(i);
				i.setReadCount(String.valueOf((Integer.parseInt((i.getReadCount()))+1)));
			}
		}
		return someList;
	}

	@Override
	public List<ArticleBean> boardList() {
		return list;
	}

	@Override
	public void changeContent(ArticleBean param) {
		for(ArticleBean i : list){
			if(param.getSeq().equals(i.getSeq())){
				i.setTitle((param.getTitle().equals(""))?i.getTitle():param.getTitle());
				i.setContent((param.getContent().equals(""))?i.getContent():param.getContent());
			}
		}
	}

	@Override
	public void removeContent(ArticleBean param) {
		Iterator<ArticleBean> it=list.iterator();
		while(it.hasNext()){
			if(it.next().getSeq().equals(param.getSeq())){
				it.remove();
				break;
			}
		}
	}
}

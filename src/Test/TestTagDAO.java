package Test;

import examples.pubhub.dao.TagDAOImpl;
import examples.pubhub.dao.TagDAO;
import examples.pubhub.model.Tag;

import java.util.List;

public class TestTagDAO {

	public static void main(String[] args) {
		TagDAO dao = new TagDAOImpl();

	    String isbn = "1111111111111";

	    Tag book = new Tag(isbn, "book");
	    Tag paper = new Tag(isbn, "paper");
	    Tag wine = new Tag(isbn, "wine");

	    dao.addTag(book);
	    dao.addTag(paper);
	    dao.addTag(wine);
	    
	    dao.updateTag(book, new Tag(isbn, "tablet"));

	    
	    
	    /*
	    dao.removeTag(book);
	    dao.removeTag(paper);
	    dao.removeTag(wine);  */
	    

		List<Tag> list = dao.getAllTagsForBook("1111111111111");

		for (int i = 0; i < list.size(); i++){
		      Tag t = list.get(i);
		   System.out.println(t);
		}
	}

}

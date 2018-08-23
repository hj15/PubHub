package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.Book;
import examples.pubhub.model.Tag;

public interface TagDAO {
	public List<Tag> getAllTagsForBook(String isbn);
	public List<Book> getAllBooksForTag(String tag);
	public Boolean addTag(Tag tag);
	public Boolean removeTag(Tag tag);
    public boolean updateTag(Tag oldTag, Tag newTag);
}

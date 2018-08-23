package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.Book;
import examples.pubhub.model.Tag;

/**
 * Interface for our Data Access Object to handle database queries related to Tags.
 */

public interface TagDAO {
	public List<Tag> getAllTagsForBook(String isbn);
	public List<Book> getAllBooksForTag(String tag);
	public Boolean addTag(Tag tag);
	public Boolean removeTag(Tag tag);
    public boolean updateTag(Tag oldTag, Tag newTag);
}

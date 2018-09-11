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
	public void addTag(Tag tag);
	public void removeTag(Tag tag);
    public void updateTag(Tag oldTag, Tag newTag);
}

package examples.pubhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import examples.pubhub.model.Book;
import examples.pubhub.utilities.DAOUtilities;
import examples.pubhub.dao.TagDAO;
import examples.pubhub.model.Tag;


/**
 * Implementation for the TagDAO, responsible for querying the database for Tag objects.
 */

public class TagDAOImpl implements TagDAO{
	
	Connection connection = null;   //Our connection to the database
	PreparedStatement stmt = null;  //Prepared statements to protect against SQL injections
	
	/*-------------------------------------------------------------------------------------*/

	@Override
	public List<Tag> getAllTagsForBook(String isbn) {
		
		List<Tag> tags = new ArrayList();
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM book_tags bt JOIN Books b on bt.isbn_13 = b.isbn_13 WHERE bt.isbn_13 = ?";
			stmt = connection.prepareStatement(sql);
			
			
			stmt.setString(1, isbn);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Tag tag = new Tag();	
				
				tag.setTagName(rs.getString("tag_name"));
				tag.setIsbn13(rs.getString("isbn_13"));
				
				tags.add(tag);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		
		return tags;
	}

	@Override
	public List<Book> getAllBooksForTag(String tag) {
		
		List<Book> books = new ArrayList();
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM book_tags bt JOIN Books b on bt.tag_name = bt.tag_name WHERE bt.tag_name = ?";
			stmt = connection.prepareStatement(sql);
			
			
			stmt.setString(1, tag);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();

				book.setIsbn13(rs.getString("isbn_13"));
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setPublishDate(rs.getDate("publish_date").toLocalDate());
				book.setPrice(rs.getDouble("price"));
				book.setContent(rs.getBytes("content"));
				
				books.add(book);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		
		return books;
	}	
	
	@Override
	public Boolean addTag(Tag tag) {
        List<Tag> tags = getAllTagsForBook(tag.getIsbn13());
        
        for(int i = 0; i < tags.size(); i++) {
        		if(tags.get(i).getTagName().equals(tag.getTagName())) {
        			System.out.print("Tag already added to book!");
        			return false;
        		}
        }
		
		try {
			connection = DAOUtilities.getConnection();   //Get our database connection from manager
			String sql = "INSERT INTO Book_tags VALUES (?,?)";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, tag.getIsbn13());
			stmt.setString(2, tag.getTagName());
			
			// If we were able to add our tag to the DB, we want to return true. 
			// This if statement both executes our query, and looks at the return 
			// value to determine how many rows were changed
			
			if (stmt.executeUpdate() != 0)
                return true;
            else
                return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResources();
        }
    }

	@Override
	public Boolean removeTag(Tag tag) {
		
		try {
			connection = DAOUtilities.getConnection();   //Get our database connection from manager
			String sql = "DELETE FROM book_tags WHERE tag_name = ?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, tag.getTagName());
			
			 if (stmt.executeUpdate() != 0)
	                return true;
	            else
	                return false;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        } finally {
	            closeResources();
	        }
		
	    }
	
	@Override
    public boolean updateTag(Tag oldTag, Tag newTag) {
        try {
            connection = DAOUtilities.getConnection();
            String sql = "UPDATE Book_Tags SET tag_name=? WHERE tag_name=? AND isbn_13=?";
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, newTag.getTagName());
            stmt.setString(2, oldTag.getTagName());
            stmt.setString(3, newTag.getIsbn13());

            if (stmt.executeUpdate() != 0)
                return true;
            else
                return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResources();
        }
    }
	
	/*------------------------------------------------------------------------------------------------*/

	// Closing all resources is important, to prevent memory leaks. 
	// Ideally, you really want to close them in the reverse-order you open them
	
        private void closeResources() {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                System.out.println("Could not close statement!");
                e.printStackTrace();
            }

            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.out.println("Could not close connection!");
                e.printStackTrace();
            }
        }
    }

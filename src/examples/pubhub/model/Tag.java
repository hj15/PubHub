package examples.pubhub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_tags")
public class Tag {
	
	@Id
	@Column(name="isbn_13")
    private String isbn13;
	
	@Column(name="tag_name")
    private String tagName;

    public Tag(){
        
    }

    public Tag(String isbn13, String tagName){
        this.isbn13 = isbn13;
        this.tagName = tagName;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    
    @Override
    public String toString() {
        return "ISBN-13 = " + isbn13 + " | tagName = " + tagName;
    }
}
package examples.pubhub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOK_TAGS")
public class Tag {
	
	@Id
    protected String isbn13;
	
	@Column
    protected String tagName;

    public Tag(){
        this.isbn13 = null;
        this.tagName = null;
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
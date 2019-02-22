package net.jakartaee.bookshop.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Book {
	
//	public static enum SECTION { BIOGRAPHY(1), BUSINESS(2), CHILDREN(3), COOKBOOK(4), HISTORY(5), LITERATURE(6), MYSTERY(7),  SCIENCE(8), UNCLASSIFIED(0);
//		private int dbValue;
//		SECTION(int value) {dbValue=value;}
//		public static SECTION get(int iSection) {
//			for (SECTION section: values()) {
//				if (section.getValue() == iSection) {
//					return section;
//				}
//			}
//			return UNCLASSIFIED;		
//		}
//		public int getValue() { return dbValue; }
//		public String toString() { return ""+dbValue;}
//	}
	
	//
	// The SALE_STATUS enum is only necessary for if/else checking 
	// Ex: if ( book.getStatus().equals(STATUS.SOLD)) 
	//
	public static enum SALE_STATUS{ PREP, LIST, SALE, HOLD, KEEP, SOLD, NONE;
	      public static SALE_STATUS get(String sStatus){
	      for (SALE_STATUS status : values()) {
	      //System.out.println("Checking STATUS name ("+status.name()+" equals: " + sStatus);
	          if (status.name().equals(sStatus)) {
	              return status;
	          }
	      }
	      System.out.println("EEEEError get STATUS by value: " + sStatus);
	      return NONE; // TODO: This should not occur.
	      }
	}
	
	
																					// dateSold should also be onINSERT
	//public static final String SQL_INSERT_FIELDS = " ( author, title, year, desc, comment, price, priceBought, priceMin, priceMax, dateBought, dateSold, status) ";
	public static final String SQL_INSERT_FIELDS = " ( subjectId, title, author, publisher, publisherPlace, year, edition, printing, volume, size,  pages, binding, condition, details, contents, notes, price, priceBought, priceMin, priceMax, dateBought, dateSold, urlRelative, status) ";
	//public static final String SQL_INSERT_FIELDS = " ( author, title, year, desc, comment, price, priceBought, priceMin, priceMax, dateBought) ";
	public static final String SQL_INSERT_VALUES = " VALUES (?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,? ) ";
	
																					// dateSold and isSold are not set regular UPDATE
	public static final String SQL_UPDATE_FIELDS = " subjectId=?, title=?, author=?, publisher=?, publisherPlace=?, year=?, edition=?, printing=?, volume=?, size=?, pages=?, binding=?, condition=?, details=?, contents=?, notes=?, price=?, priceBought=?, priceMin=?, priceMax=?, dateBought=?, dateSold=?, urlRelative=?, status=? ";
	//public static final String SQL_UPDATE_FIELDS = " authorId=?, title=?, year=?, desc=?, price=?, priceBought=?, priceMin=?, priceMax=?, dateBought=?";
    
	private int _id;
	private Long _subjectId;				// Can be null
	private String _author;
	private String _title;
	private String _publisher;
	private String _publisherPlace;
	private int _year;
	private String _edition;
	private String _printing;
	private String _volume;
	private String _size;
	private String _pages;			// Ex: xiv 222 pp. w/ 16 plates
	private String _binding;
	private String _condition;
	
	private String _details;
	private String _contents;
	
	private String _notes;
	private Long _price;
	private Long _priceBought;
	private Long _priceMin;
	private Long _priceMax;
	private String _dateBought;
	private String _dateSold;
	private String _urlRelative;
	private String _status;

	
	private Subject _subject;
	
	private List<Reference> _references;
	private List<Tag> _tags;

	public Book() {} // This is required for jersey-media-json-jackson binding for the doPost (Book book)
	
	public Book(ResultSet rs) throws SQLException {
		_id =  rs.getInt("bookId");
		_subjectId = Optional.ofNullable(rs.getBigDecimal("subjectId")).map(BigDecimal::longValue).orElse(null);
		_author = rs.getString("author");
		_title = rs.getString("title");
		
		_publisher = rs.getString("publisher");
		_publisherPlace = rs.getString("publisherPlace");
		_year = rs.getInt("year");
		_edition = rs.getString("edition");
		_printing = rs.getString("printing");
		_volume = rs.getString("volume");
		//_pages = Optional.ofNullable(rs.getBigDecimal("pages")).map(BigDecimal::longValue).orElse(null);
		_size = rs.getString("size");
		_pages = rs.getString("pages");
		_binding = rs.getString("binding");

		_condition = rs.getString("condition");
		_details = rs.getString("details");
		_contents = rs.getString("contents");
		_notes = rs.getString("notes");
		 
		_price = Optional.ofNullable(rs.getBigDecimal("price")).map(BigDecimal::longValue).orElse(null);
		_priceBought = Optional.ofNullable(rs.getBigDecimal("priceBought")).map(BigDecimal::longValue).orElse(null);
		_priceMin = Optional.ofNullable(rs.getBigDecimal("priceMin")).map(BigDecimal::longValue).orElse(null);
		_priceMax = Optional.ofNullable(rs.getBigDecimal("priceMax")).map(BigDecimal::longValue).orElse(null);
		
		_dateBought = rs.getString("dateBought");
		_dateSold = rs.getString("dateSold");
		_urlRelative = rs.getString("urlRelative");
		_status = rs.getString("status");

	}
	
	//
	// Generated Getters and Setters
	//

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public Long getSubjectId() {
		return _subjectId;
	}

	public void setSubjectId(Long subjectId) {
		_subjectId = subjectId;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getPublisher() {
		return _publisher;
	}

	public void setPublisher(String publisher) {
		_publisher = publisher;
	}

	public String getPublisherPlace() {
		return _publisherPlace;
	}

	public void setPublisherPlace(String publisherPlace) {
		_publisherPlace = publisherPlace;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	public String getEdition() {
		return _edition;
	}

	public void setEdition(String edition) {
		_edition = edition;
	}

	public String getPrinting() {
		return _printing;
	}

	public void setPrinting(String printing) {
		_printing = printing;
	}

	public String getSize() {
		return _size;
	}

	public void setSize(String size) {
		_size = size;
	}

	public String getPages() {
		return _pages;
	}

	public void setPages(String pages) {
		_pages = pages;
	}

	public String getBinding() {
		return _binding;
	}

	public void setBinding(String binding) {
		_binding = binding;
	}

	public String getCondition() {
		return _condition;
	}

	public void setCondition(String condition) {
		_condition = condition;
	}

	public String getDetails() {
		return _details;
	}

	public void setDetails(String details) {
		_details = details;
	}

	public String getContents() {
		return _contents;
	}

	public void setContents(String contents) {
		_contents = contents;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
	}

	public Long getPrice() {
		return _price;
	}

	public void setPrice(Long price) {
		_price = price;
	}

	public Long getPriceBought() {
		return _priceBought;
	}

	public void setPriceBought(Long priceBought) {
		_priceBought = priceBought;
	}

	public Long getPriceMin() {
		return _priceMin;
	}

	public void setPriceMin(Long priceMin) {
		_priceMin = priceMin;
	}

	public Long getPriceMax() {
		return _priceMax;
	}

	public void setPriceMax(Long priceMax) {
		_priceMax = priceMax;
	}

	public String getDateBought() {
		return _dateBought;
	}

	public void setDateBought(String dateBought) {
		_dateBought = dateBought;
	}

	public String getDateSold() {
		return _dateSold;
	}

	public void setDateSold(String dateSold) {
		_dateSold = dateSold;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Subject getSubject() {
		return _subject;
	}

	public void setSubject(Subject subject) {
		_subject = subject;
	}

	public List<Reference> getReferences() {
		return _references;
	}

	public void setReferences(List<Reference> references) {
		_references = references;
	}

	public List<Tag> getTags() {
		return _tags;
	}

	public void setTags(List<Tag> tags) {
		_tags = tags;
	}

	public String getVolume() {
		return _volume;
	}

	public void setVolume(String volume) {
		_volume = volume;
	}

	public String getUrlRelative() {
		return _urlRelative;
	}

	public void setUrlRelative(String urlRelative) {
		_urlRelative = urlRelative;
	}


	

	//
	//
	//
	

//	public boolean isSold() {
//		return _sold;
//	}

	
	
}

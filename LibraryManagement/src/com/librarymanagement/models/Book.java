package com.librarymanagement.models;


public class Book {

	private String name;
	private static int uniqueID;
    private int id;
	private String author;
	private String publication;
	private String edition;
	private String journal;
	private int availableCount;
	private int volume;
	private int libraryId;

    static{
        uniqueID=0;
    }

	public Book() {

	}

	public Book(int id,String name, String author, String publication, String edition, String journal,
				int availableCount, int volume, int libraryId) {
        this.name = name;
        this.id=id;
        this.author = author;
        this.publication = publication;
        this.edition = edition;
        this.journal = journal;
        this.availableCount = availableCount;
        this.volume = volume;
		this.libraryId = libraryId;
    }

	public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}


	public int getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}


	public static String getTitle() {
		return String.format("| %-5s | %-20s | %-20s | %-35s | %-25s | %-25s | %-25s | %-17s | %-6s |\n",
				"ID", "Book Name", "Author", "Publication", "Edition", "Journal", "Library Id", "Available Count", "Volume");
	}
	
	
	@Override
	public String toString() {
		return String.format("| %-5s | %-20s | %-20s | %-35s | %-25s | %-25s | %-25s | %-17s | %-6s |\n",
				id, name, author, publication, edition, journal, libraryId, availableCount, volume);
	}
	
	
	

}

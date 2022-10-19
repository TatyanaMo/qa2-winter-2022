package hw1;

public class Document {
    private String documentType;
    private String Name;
    private int numberOfPages;
    private boolean DocumentOriginal;
    boolean isDocumentSigned = false;

    //--------------GETTERS/SETTERS----------------

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public boolean isDocumentOriginal() {
        return DocumentOriginal;
    }

    public void setDocumentOriginal(boolean documentOriginal) {
        DocumentOriginal = documentOriginal;
    }

    public boolean isDocumentSigned() {
        return isDocumentSigned;
    }

    public void setDocumentSigned(boolean documentSigned) {
        isDocumentSigned = documentSigned;
    }
}

public class EncapsulationBook {

    private int prize;   
    private String ISBN;
    private String name;
    private String author;
    static boolean ISBN_Status=true;
    static boolean price_Status=true;
    
    
    public EncapsulationBook(String name, String author) {
        this.name = name;
        this.author = author;
    }
   
    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        if (validationPrice(prize)) {
            this.prize = prize;
        } else {
            price_Status=false;
            
        }
    }

    public void setISBN(String ISBN) {
        if (validationISBN(ISBN)) {
            this.ISBN = ISBN;
        } else {
            ISBN_Status=false;
        }
    }
    
    public String getISBN() {
        return ISBN;  // Renamed for convention
    }
    
    public boolean validationISBN(String ISBN) {
        return ISBN != null && ISBN.matches("\\d{13}");
    }

    public boolean validationPrice(int prize) {
        return prize >= 0;  // Ensure the prize is non-negative
    }
     
    void printData() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("Prize: " + prize);
    }

    public static void main(String[] args) {
        EncapsulationBook en = new EncapsulationBook("Sai", "KA.Paul");
        en.setISBN("9781234560789");
        en.setPrize(3456); 
        
        EncapsulationBook en1 = new EncapsulationBook("Shiva", "Modi");
        en1.setISBN("1234567891234");
        en1.setPrize(5667); 
        
        
            if(price_Status==false && ISBN_Status==false){
                    System.out.println("Both ISBN and Prize are valid");
            }else if(ISBN_Status==false){ 
                    System.out.println("Please enter the valid ISBN");
            }else if(price_Status==false){
                System.out.println("Please enter the valid price");
            }else{
                en.printData();
            }
    }
}

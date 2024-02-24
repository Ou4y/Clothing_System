import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Products implements Serializable {
    static public int counter = 0;
    public String productName;
    public String PID;
    public String price;

    String productsFileName = "productsData.txt";
    static public ArrayList<Products> productsDataList = new ArrayList<>();

    public Products() {
    }

    public Products(String pname, String num) {
        this.productName = pname;
        this.PID = String.format("%05d", ++counter);
        this.price = num;
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
    }

    @Override
    public String toString() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return "product name: " + this.productName + "\n product ID: " + this.PID + "\n" + "price: " + formattedDate;
    }
}

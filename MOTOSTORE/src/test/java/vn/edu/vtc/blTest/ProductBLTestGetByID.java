package vn.edu.vtc;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.persistance.Product;

public class ProductBLTestGetByID{

    @Test
    public void getProductByIDTest1(){ //tìm đc sản phẩm, trả về sản phẩm đó
        ProductBL productBL = new ProductBL();
        try {
            Product product = productBL.getProductByID(10);
            Product product1 = new Product();
            product1.setProductName("Mu XTREME Capuchino");
            product1.setDescription("Avex la thuong hieu non bao hiem Thai Lan rat lon O Viet Nam Avex kha noi tieng duoc nhieu biker ua chuong qua cac dong non 3 4 dau nhu Dammtrax Unik Avex Scorpion non bo cap Avex TopGun Avex Lava Dome Avex Lava S…");
            product1.setPrice(880000);
            product1.setSize("S,M,L");
            product1.setColor("Pink");
            product1.setCategoryID(2);
            product1.setTimeWarranty("6 month");   
            assertTrue(product.getProductName().equals(product1.getProductName()));
            assertTrue(product.getDescription().equals(product1.getDescription()));
            assertTrue(product.getPrice() == product1.getPrice());
            assertTrue(product.getSize().equals(product1.getSize()));
            assertTrue(product.getColor().equals(product1.getColor()));
            assertTrue(product.getCategoryID() == product1.getCategoryID());
            assertTrue(product.getTimeWarranty().equals(product1.getTimeWarranty()));
        } catch (Exception e) {
        }
    }
    @Test
    public void getProductByIDTest2(){ //sai productID, không tìm được, trả về null
        ProductBL productBL = new ProductBL();
        try {
            Product product = productBL.getProductByID(1000);
            assertNull(product);
        } catch (Exception e) {
        }
    }
}
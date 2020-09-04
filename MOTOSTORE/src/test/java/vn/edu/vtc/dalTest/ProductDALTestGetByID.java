package vn.edu.vtc;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Product;

public class ProductDALTestGetByID{

    @Test
    public void getByIDDALTest1(){ //tìm đc sản phẩm, trả về sản phẩm đó
        ProductDAL productDAL = new ProductDAL();
        try {
            Product product = productDAL.getProductByID(10);
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
    public void getByIDDALTest2(){ //sai tên, không tìm được, trả về null
        ProductDAL productDAL = new ProductDAL();
        try {
            Product product = productDAL.getProductByID(1000);
            assertNull(product);
        } catch (Exception e) {
        }
    }
}
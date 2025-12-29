package org.jsp.merchantproductApp.controller;

import java.util.List;
import java.util.Scanner;
import org.jsp.merchantproductApp.dao.MerchantDao;
import org.jsp.merchantproductApp.dao.ProductDao;
import org.jsp.merchantproductApp.dto.Merchant;
import org.jsp.merchantproductApp.dto.Product;
 
public class MerchantProductController {
	static Scanner sc=new Scanner(System.in);
	static MerchantDao mdo=new MerchantDao();
	static ProductDao pdao=new ProductDao();
	public static void main(String[] args) {
		System.out.println("1 .Save Merchant");
		System.out.println("2 .Update Merchant");
		System.out.println("3 .Find Merchant ById");
		System.out.println("4 .Verify Merchant Email and Password");
		System.out.println("5 .Verify Merchant Phone and Password");
		
		
		System.out.println("6 .Add Product");
		System.out.println("7 .Update Product");
		System.out.println("8 .Find  Products By Merchant id");
		System.out.println("9 .Find  Products By Brand ");
		System.out.println("10 .Find  Products By Category");
		
		System.out.println("Enter your Choice??");
		int choice=sc.nextInt();
		switch(choice) {
		case 1: savMerchant();
		     break;
		case 2: updateMerchant();
	         break;
		case 3: findMerchantById();
             break;
		case 4: verifyMerchantByEmailAndPassword();
              break;
		case 5: verifyMerchantByPhoneAndPassword();
              break;
		case 6: addProduct();
              break;
		case 7: updateProduct();
              break;
		case 8: findProductByMerchantId();
              break;
		case 9: findProductByBrand();
              break;
		case 10: findProductByCotegory();
              break;
	    default:
	    	 break;
		}
		
	}
	private static void findProductByCotegory() {
		System.out.println("Enter the Brand ");
		String brand=sc.next();
		List<Product>ls=pdao.findProductByBrand(brand);
		if (ls.size()>0) {
			System.out.println(ls);
		}
		else {
			System.err.println("No info found");
		}
	}
	private static void findProductByBrand() {
		System.out.println("Enter the Cotegory ");
		String cat=sc.next();
		List<Product>ls=pdao.findProductByCotegory(cat);
		if (ls.size()>0) {
			System.out.println(ls);
		}
		else {
			System.err.println("No info found");
		}
	}
	private static void findProductByMerchantId() {
    System.out.println("Enter the Merchant id??");	
    int mid=sc.nextInt();
   List<Product> pdb= pdao.findProductByMerchantId(mid);
   if (pdb.size()>0) {
	   for(Product p:pdb) {
		   System.out.println("product fetch by Merchant id"+p);
	   }
}
   else {
	   System.err.println("No info is found ");
   }
    
	}
	private static void updateProduct() {
		System.out.println("Enter the info update ---id,name,brand,category,cost");
		Product p=new Product();
		p.setId(sc.nextInt());
		p.setName(sc.next());
		p.setBrand(sc.next());;
		p.setCategory(sc.next());
		p.setCost(sc.nextDouble());
	
		
		Product pdb=pdao.updateProduct(p);
		if (pdao!=null) {
			System.out.println("Product  updated with an id :"+pdb.getId());
		}
		else {
			System.err.println("Product not able to update");
		}
		
    		
	}
	private static void addProduct() {
		 System.out.println("Enter the Merchant id??");
         int mid=sc.nextInt();
         System.out.println("Enther the Product.....name,brand,category,cost");
         Product p=new Product();
        
         p.setName(sc.next());
         p.setBrand(sc.next());
         p.setCategory(sc.next());
         p.setCost(sc.nextDouble());
         Product pdb=pdao.addProduct(mid,p);
         if (pdb!=null) {
			System.out.println("product add with merchant id :"+p.getId());
		}
         
         else {
        	 System.err.println("products not added hence id is unavailable");
         }
         
	}
	private static void verifyMerchantByPhoneAndPassword() {
     System.out.println("Enter the Merchan phone");
     long ph=sc.nextLong();
     System.out.println("Enter ther Merchant password");
     String pw=sc.next();
    Merchant mdb= mdo.verifyMerchantByPhoneAndPassword(ph,pw);
    if (mdb!=null) {
		System.out.println("Merchant is succsessfull");
	}
    else {
    	System.out.println("Merchant is not successfull");
    }
   
	}
	private static void verifyMerchantByEmailAndPassword() {
    System.out.println("Enter Merchant Email??");		
    String em=sc.next();
    System.out.println("Enter Merchant password");
    String pw=sc.next();
   Merchant mdb= mdo.verifyMerchantByEmailAndPassword(em,pw);
    if (mdb!=null) {
		System.out.println("Merchant is succsessfull");
	}
    else {
    	System.out.println("Merchant is not successfull");
    }
	}
	private static void findMerchantById() {
		System.out.println("Enter the Merchant Id??");
        int mid=sc.nextInt();
       Merchant mdb= mdo.findMerhantById(mid);
       if (mdb!=null) {
		System.out.println("Merchant find with id :"+mdb);
		}
       else {
    	   System.out.println("Merchant not found hence Id is invalid");
       }
        
	}
	private static void updateMerchant() {
		System.out.println("Enter the info update ---id,name,phone,gst,email,password");
		Merchant m=new Merchant();
		m.setId(sc.nextInt());
		m.setName(sc.next());
		m.setPhone(sc.nextLong());
		m.setGst_num(sc.next());
		m.setEmail(sc.next());
		m.setPassword(sc.next());
		Merchant mdb=mdo.updateMerchant(m);
		 System.out.println("Merchant is updated with an id "+mdb.getId());
		
		
	}
	private static void savMerchant() {
       System.out.println("Enter Merchant info----name,phone,gst,email,password");		
       String name=sc.next();
       long ph=sc.nextLong();
       String gst=sc.next();
       String em=sc.next();
       String pw=sc.next();
       
       Merchant m=new Merchant();
       m.setName(name);
       m.setPhone(ph);
       m.setGst_num(gst);
       m.setEmail(em);
       m.setPassword(pw);
       
       Merchant mdb=mdo.saveMerchant(m);
       System.out.println("Merchant is saved with an id "+mdb.getId());
	}

}

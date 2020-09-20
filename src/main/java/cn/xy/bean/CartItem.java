package cn.xy.bean;

import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 购物车条目
 *
 */
@Data
@Component
public class CartItem {
	private Product product;
	private int count;
	
	//小计  =  对应的价格*购买的数量
	public double getSubtotal() {
		BigDecimal price = new BigDecimal(this.product.getProductprice()+"");
		BigDecimal count = new BigDecimal(this.count+"");
		double result = price.multiply(count).doubleValue();
		return result;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

    
}

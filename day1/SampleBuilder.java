package com.stackroute.designpattern;

class ItemDelivery
{
	String itemName;
	 
		String address;
		String hotelName;
		String promotionCode;
		public String getPromotionCode() {
			return promotionCode;
		}

		public int getTips() {
			return tips;
		}

		int tips;
		
	public String getItemName() {
		return itemName;
	}
	 
	public String getAddress() {
		return address;
	}
	 
	public String getHotelName() {
		return hotelName;
	}
	 
	public ItemDelivery(ItemBuilder itembuild)
	{
		this.address=itembuild.address;
		this.hotelName=itembuild.hotelName;
		this.tips=itembuild.tips;
		this.promotionCode=itembuild.promotionCode;
		this.itemName=itembuild.itemName;
		
	}
	
	public static class ItemBuilder
	{
		
		String itemName;
		 
		String address;
		String hotelName;
		String promotionCode;
		int tips;
		public ItemBuilder(String iname,String addr,String hname)
		{
			this.itemName=iname;
			this.address=addr;
			this.hotelName=hname;
			
			
		}
		
		public ItemBuilder setPromotionCode(String pcode)
		{
			this.promotionCode=pcode;
			return this;
			
		}
		
		public ItemBuilder setTips(int tip)
		{
			this.tips=tip;
			return this;
		}
		 
		
		public ItemDelivery build()
		{
			return new ItemDelivery(this);
		}
	}
}


public class SampleBuilder {

	public static void main(String ar[])
	{
		ItemDelivery obj=new ItemDelivery.ItemBuilder("Cake","Blore","Ayankar").setPromotionCode("Today").setTips(200).build();
		
		System.out.println(obj.getHotelName()+ obj.getPromotionCode());
	}
}

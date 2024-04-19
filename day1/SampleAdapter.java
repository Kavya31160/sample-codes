package com.stackroute.designpattern;

interface iWebhost
{
	public void onCall();
}

 interface iView
 {
	 public void sendData();
 }
 
 class LibBook implements iView
 {

	public void sendData() {
		System.out.println("History of Books ; author : ABC");
		
	}
	 
 }
 
 interface iPublish
 {
	 public void showDetails();
 }
 
 class WebToBookAdapter implements iPublish
 {

	 LibBook bookobj;
	 
	 WebToBookAdapter()
	 {
		 bookobj=new LibBook();
	 }
	public void showDetails() {
		 
		bookobj.sendData();
		
	}
	 
 }

 class WebView implements 	iWebhost
 {
	 iPublish iadapter;
    
    public WebView(WebToBookAdapter adapter)
    {
    	iadapter=adapter;
    }
    
	public void onCall() {
		 
		iadapter.showDetails();
	}
	 
 }


public class SampleAdapter {

	public static void main(String[] args) {
		 
 iWebhost web=new WebView(new WebToBookAdapter());
 web.onCall();
	}

}

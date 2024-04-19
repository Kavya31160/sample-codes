package com.stackroute.designpattern;

interface User {
    void checkOut();
}

class AuthorizedUser implements User {
    @Override
    public void checkOut() {
        System.out.print("Authorized user. checking out...");
    }
}

class GuestUser implements User {
    @Override
    public void checkOut() {
        System.out.print("Guest User. Showing Registration Page");
    }
}

interface UserProxy {
    User getUser();
}

class UserProxyHandler implements UserProxy{
    private boolean isLoggedIn;

    public UserProxyHandler(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    @Override
    public User getUser() {
        User user;
        if (isLoggedIn) {
            user = new AuthorizedUser();
        } else {
            user = new GuestUser();
        }
        return user;
    }
}

class UserManagerService
{
	public static boolean isUserLoggedIn(boolean status)
	{
		return status;
	}
}

public class SampleProxy {

	public static void main(String[] args) {
		  boolean isUserLoggedIn= UserManagerService.isUserLoggedIn(false);
	        User user=new UserProxyHandler(isUserLoggedIn).getUser();
	        user.checkOut();

	}

}

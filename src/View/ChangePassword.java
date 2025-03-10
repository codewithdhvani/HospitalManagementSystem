package View;

import java.util.Scanner;

import Controller.UpdateEmployeePassword;
import Model.Database;
import Model.Option;
import Model.User;

public class ChangePassword implements Option {

	@Override
	public void operation(Scanner s, Database database, User u) {
		String oldPassword;
		do {
			System.out.println("Enter old password:");
			oldPassword = s.next();
		} while (!oldPassword.equals(u.getPassword()));
		System.out.println("Enter new password:");
		String newPassword = s.next();
		String confirmPassword;
		do {
			System.out.println("Confirm Password:");
			confirmPassword = s.next();
		} while (!newPassword.equals(confirmPassword));
		u.setPassword(newPassword);
		
		if (new UpdateEmployeePassword(u, database).isUpdated()) {
			System.out.println("Password updated successfully");
		}
	}

	@Override
	public String getName() {
		return "Change Password";
	}

}

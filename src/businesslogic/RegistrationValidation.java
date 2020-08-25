package businesslogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidation {
	public boolean checkUserDetails(String email, String password, String confirmPassword) {
		boolean result = false;
		if (validPassword(password, confirmPassword) && validEmail(email)) {

			result = true;
		}

		return result;
	}

	private boolean validPassword(String password, String confirmPassword) {

		boolean result = false;
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(password);
		Matcher m1 = p.matcher(confirmPassword);
		if (!password.equals(confirmPassword)) {
			result = false;
		} else if (m.matches() && m1.matches()) {
			result = true;
		}

		return result;
	}

	private boolean validEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		boolean result = false;
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			result = true;
		}
		return result;
	}
}

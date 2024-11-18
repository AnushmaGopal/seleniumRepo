package github;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class GithubRepo {
	@Test
	public void addMessage()
	{
		Reporter.log("Welcome to GithubRepo", true);
	}
}

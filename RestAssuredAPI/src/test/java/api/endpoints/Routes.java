package api.endpoints;


// contains only URL's(uniform resource locator)
public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";

	// user modules

	// post, put, get, delete

	public static String post_url = base_url + "/user";

	public static String get_url = base_url + "/user/{username}";

	public static String update_url = base_url + "/user/{username}";

	public static String delete_url = base_url + "/user/{username}";

}

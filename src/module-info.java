/**
 * 
 */
/**
 * 
 */
module RestAssuredJava {
	requires rest.assured;
	// hamcrest provides org.hamcrest.Matcher which Rest Assured references
	requires org.hamcrest;
	// allow access to TestNG assertions when running/compiling as a module
	requires org.testng;
	requires json.path;
	requires jdk.compiler;
}
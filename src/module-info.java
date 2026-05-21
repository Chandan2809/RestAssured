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
	requires json.path;
}
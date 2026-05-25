package restassuredtest;

import Files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 JsonPath js = new JsonPath(payload.CoursePrice());
		 
		 //Print No of courses returned by API
		 
		 int count = js.getInt("courses.size()");
		 System.out.println(count);
		 
		 //Print purchase amount
		 
		 int TotalPurchaseAmount = js.getInt("dashboard.purchaseAmount");
		 System.out.println(TotalPurchaseAmount);
		 
		 
		 //Print title of the first course
		 
		 String TitleFirstCourse = js.getString("courses[2].title");
		 System.out.println(TitleFirstCourse);
		 
		 //Print All courses titles and there respective prices
		 
		 for(int i=0; i<count; i++) {
			 String CourseTitles = js.get("courses["+i+"].title");
			 System.out.println(CourseTitles);
			 System.out.println(js.get("courses["+i+"].price").toString());
			 System.out.println(js.get("courses["+i+"].copies").toString());
	   }

    }
}
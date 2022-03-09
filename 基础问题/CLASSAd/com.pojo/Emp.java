package com.pojo;

public class Emp{


//public Emp(String classname,String teacher,String location ) {
	//super();
	//this.classname = classname;
	//this.teacher = teacher;
	//this.location = location;
//}
	private String classname;
	private String teacher;
	private String location;



		public Emp(String str1, String str2, String str3) {
			super();
			this.classname = classname;
			this.teacher = teacher;
			this.location = location;
}



	
	    public String getClassname() {
	        return classname;
	    }
	    public void setClassname(String classname) {
	        this.classname = classname;
	    }
	    public String getTeacher() {
	        return teacher;
	    }
	    public void setTeacher(String teacher) {
	        this.teacher = teacher;
	    }
	    public String getLocation() {
	        return location;
	    }
	    public void setLocation(String location) {
	        this.location = location;
	    

}
	    @Override
		public String toString() {
			return "Emp [ ename=" + classname + ", teacher=" + teacher + ", location=" + location + "]";
	
}
}

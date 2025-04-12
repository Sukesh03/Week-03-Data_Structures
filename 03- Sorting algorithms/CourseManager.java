import java.util.ArrayList;
import java.util.Scanner;
class Course{
    String courseId;
    String name;
    int duration;
    public Course(String courseId,String name,int duration){
        this.courseId=courseId;
        this.name=name;
        this.duration=duration;
    }
    public String getCourseId(){
        return courseId;
    }
    public void setCourseId(String courseId){
        this.courseId=courseId;
    }
    public String getName(){
        return name;
    }
    public void getName(String name){
        this.name=name;
    }
    public int getDuration(){
        return duration;
    }
    public void setDuration(int duration){
        this.duration=duration;
    }
    @Override
    public String toString(){
        return "Course ID: "+courseId+" Name: "+name+" Duration: "+duration;
    }
}
public class CourseManager {
    public static void sortByName(ArrayList<Course> courses){
        for (int i=0;i<courses.size()-1;i++){
            for (int j=0;j<courses.size()-i-1;j++){
                if (courses.get(j).getName().compareToIgnoreCase(courses.get(j+1).getName())>0){
                    Course temp=courses.get(j);
                    courses.set(j,courses.get(j+1));
                    courses.set(j+1,temp);
                }
            }
        }
    }
    public static void sortById(ArrayList<Course> courses){
        for (int i=0;i<courses.size()-1;i++){
            for (int j=0;j<courses.size()-i-1;j++){
                if (courses.get(j).getCourseId().compareToIgnoreCase(courses.get(j+1).getCourseId())>0){
                    Course temp=courses.get(j);
                    courses.set(j,courses.get(j+1));
                    courses.set(j+1,temp);
                }
            }
        }
    }
    public static Course binarySearchById(ArrayList<Course> courses,String courseId){
        int l=0;
        int r=courses.size()-1;
        while (l<=r){
            int mid=(l+r)/2;
            Course midCourse=courses.get(mid);
            int comparison= midCourse.getCourseId().compareToIgnoreCase(courseId);
            if (comparison==0){
                return midCourse;
            }else if (comparison<0){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return null;
    }
    public static void main(String[] args){
        ArrayList<Course> courses=new ArrayList<>();
        courses.add(new Course("C101","Java",30));
        courses.add(new Course("C103","DSA",40));
        courses.add(new Course("C102","OOPS",35));
        sortByName(courses);
        System.out.println("Courses sorted by name: ");
        for (Course course:courses){
            System.out.println(course);
        }
        Scanner sc=new Scanner(System.in);
        System.out.print("\nEnter course ID to search: ");
        String searchId=sc.nextLine();
        sortById(courses);
        Course foundCourse=binarySearchById(courses,searchId);
        if (foundCourse!=null){
            System.out.println("Course found: "+foundCourse);
        }else{
            System.out.println("Course with ID "+searchId+" not found.");
        }
        sc.close();
    }
}

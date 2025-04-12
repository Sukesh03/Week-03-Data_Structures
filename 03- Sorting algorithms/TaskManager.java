import java.util.ArrayList;
import java.util.Scanner;
class Task{
    private String taskId;
    private String name;
    private String deadline;
    public Task(String taskId,String name,String deadline){
        this.taskId=taskId;
        this.name=name;
        this.deadline=deadline;
    }
    public String getTaskId(){
        return taskId;
    }
    public void setTaskId(String taskId){
        this.taskId=taskId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDeadline(){
        return deadline;
    }
    public void setDeadline(){
        this.deadline=deadline;
    }
    @Override
    public String toString(){
        return "TaskID: "+taskId+" Task Name: "+name+" Deadline: "+deadline;
    }
}
public class TaskManager {
    public static void sortByDeadline(ArrayList<Task> tasks){
        for (int i=0;i<tasks.size()-1;i++){
            for (int j=0;j<tasks.size()-i-1;j++){
                if (tasks.get(j).getDeadline().compareToIgnoreCase(tasks.get(j+1).getDeadline())>0){
                    Task temp=tasks.get(j);
                    tasks.set(j,tasks.get(j+1));
                    tasks.set(j+1,temp);
                }
            }
        }
    }
    public static void sortByTaskId(ArrayList<Task> tasks){
        for (int i=0;i<tasks.size()-1;i++){
            for (int j=0;j<tasks.size()-i-1;j++){
                if (tasks.get(j).getTaskId().compareToIgnoreCase(tasks.get(j+1).getTaskId())>0){
                    Task temp=tasks.get(j);
                    tasks.set(j,tasks.get(j+1));
                    tasks.set(j+1,temp);
                }
            }
        }
    }
    public static Task binarySearchById(ArrayList<Task> tasks, String searchId){
        int l=0,r=tasks.size()-1;
        while(l<=r){
            int mid=(l+r)/2;
            Task midTask=tasks.get(mid);
            int comparison=midTask.getTaskId().compareToIgnoreCase(searchId);
            if (comparison==0){
                return midTask;
            }else if (comparison<0){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return null;
    }
    public static void main(String[] args){
        ArrayList<Task> tasks=new ArrayList<>();
        tasks.add(new Task("T103", "Submit Report", "2025-04-21"));
        tasks.add(new Task("T101", "Project Meeting", "2025-04-19"));
        tasks.add(new Task("T102", "Code Review", "2025-04-20"));
        sortByDeadline(tasks);
        System.out.println("Tasks sorted by deadline: ");
        for (Task task:tasks){
            System.out.println(task);
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Task ID to search: ");
        String searchId=sc.nextLine();
        sortByTaskId(tasks);
        Task found=binarySearchById(tasks,searchId);
        if (found!=null){
            System.out.println("Task found: "+found);
        }else{
            System.out.println("Task with Task ID "+searchId+" not found.");
        }
        sc.close();
    }
}

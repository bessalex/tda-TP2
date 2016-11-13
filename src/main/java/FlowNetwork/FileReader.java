package FlowNetwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by maxi on 13/11/16.
 */

public class FileReader {

    protected Integer nAreas;
    protected Integer mProjects;
    protected ArrayList<Integer> areasCost;
    protected ArrayList<Project> projects;

    public FileReader(String filePath) {
        this.areasCost = new ArrayList<Integer>();
        this.projects = new ArrayList<Project>();
        this.readFileByLine(filePath);
    }


    public void readFileByLine(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(System.getProperty("line.separator"));
            if(scanner.hasNext()){
                this.nAreas = Integer.parseInt(scanner.next());
            }
            if(scanner.hasNext()){
                this.mProjects = Integer.parseInt(scanner.next());
            }
            for (int i=0; i<nAreas;i++) {
                this.areasCost.add(Integer.parseInt(scanner.next()));
            }
            for (int i=0; i<mProjects;i++) {
                String[] parts = scanner.next().split(" ");
                ArrayList<Integer> projectAreas = new ArrayList<Integer>();
                for (int j=1; j< parts.length;j++){
                    projectAreas.add(Integer.parseInt(parts[j]));
                }
                Project project = new Project(Integer.parseInt(parts[0]),projectAreas);
                this.projects.add(project);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Integer getnAreas(){
        return nAreas;
    }

    public Integer getmProjects(){
        return mProjects;
    }

    public ArrayList<Integer> getAreasCosts(){
        return areasCost;
    }

    public ArrayList<Project> getProjects(){
        return projects;
    }
}

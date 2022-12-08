import java.util.ArrayList;

public class SingleDirectory {
    ArrayList<SingleFile> files;
    String name;
    SingleDirectory parentFolder;
    ArrayList<SingleDirectory> subDirectories;
    Integer folderSize;

    public SingleDirectory(String name, SingleDirectory parent){
        this.name = name;
        this.parentFolder = parent;
        this.subDirectories = new ArrayList<>();
        this.files = new ArrayList<>();
        this.folderSize =0;
    }

    public String getName() {
        return name;
    }

    public SingleDirectory getSubFolder(String folderName){
        return subDirectories.stream().filter((file)->file.getName().equals(folderName)).findFirst().orElse(null);
    }

    public void setName(String name) {
        this.name = name;
    }

    public SingleDirectory getParentFolder() {
        return parentFolder;
    }

    public void setFiles(ArrayList<SingleFile> files) {
        this.files = files;
    }

    public void setParentFolder(SingleDirectory parentFolder) {
        this.parentFolder = parentFolder;
    }

    public void setSubDirectories(ArrayList<SingleDirectory> subDirectories) {
        this.subDirectories = subDirectories;
    }


    public ArrayList<SingleFile> getFiles() {
        return files;
    }

    public ArrayList<SingleDirectory> getSubDirectories() {
        return subDirectories;
    }

    public void addFile(SingleFile newFile){
        files.add(newFile);
    }

    public void addDirectory(SingleDirectory newDirectory){
        subDirectories.add(newDirectory);
    }

    public Integer getSize(){
        int size = 0;
        for(SingleFile file : files){
            size += file.getFileSize();
        }

        for(SingleDirectory dir : subDirectories){
            size += dir.getSize();
        }

        this.folderSize = size;
        return size;
    }

    public String toString(){
        StringBuilder dirAsString = new StringBuilder();
        if(folderSize == 0){
            getSize();
        }
        dirAsString.append("FolderName: "+ name+"\n");
        dirAsString.append("size: "+ folderSize+"\n");

        for(SingleFile currFile: files){
            dirAsString.append(currFile.toString()+"\n");
        }

        for(SingleDirectory dir: subDirectories){
            dirAsString.append(dir.toString()+"\n");
        }

        return dirAsString.toString();
    }

    public ArrayList<SingleDirectory> findMaxSizedFolder(int maxSize){
        ArrayList<SingleDirectory> maxSizedFolders = new ArrayList<>();
        for(SingleDirectory dir : subDirectories){
            if(dir.getSize() <= maxSize){
                maxSizedFolders.add(dir);
                maxSizedFolders.addAll(dir.findMaxSizedFolder(maxSize));
            } else {
                maxSizedFolders.addAll(dir.findMaxSizedFolder(maxSize));
            }
        }


        return maxSizedFolders;
    }

    public ArrayList<SingleDirectory> findMinSizedFolder(int minSize){
        ArrayList<SingleDirectory> minSizedFolders = new ArrayList<>();
        for(SingleDirectory dir : subDirectories){
            if(dir.getSize() >= minSize){
                minSizedFolders.add(dir);
                minSizedFolders.addAll(dir.findMinSizedFolder(minSize));
            } else {
                minSizedFolders.addAll(dir.findMinSizedFolder(minSize));
            }
        }


        return minSizedFolders;
    }
}

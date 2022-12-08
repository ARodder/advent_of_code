public class SingleFile {
    private String fileName;
    private Integer fileSize;

    private SingleDirectory parent;

    public SingleFile(String fileName, Integer fileSize,SingleDirectory parent){
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.parent = parent;
    }

    public String getFileName(){
        return this.fileName;
    }

    public Integer getFileSize(){
        return this.fileSize;
    }

    public String toString(){
        StringBuilder fileAsString = new StringBuilder();

        fileAsString.append("File name: "+fileName+"\n");
        fileAsString.append("size: " + fileSize+"\n");

        return fileAsString.toString();
    }
}

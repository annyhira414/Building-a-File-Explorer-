package workapplicationfx;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class ClassWorkingTreeView extends FileControllerFx {
    ClassWorkingTreeView(){};
    @Override

    public TreeItem<String>[] TreeCreate(File dir){
        TreeItem<String>[] A=null;
        File[] fl = dir.listFiles();
        int n= fl.length-FilesHiddensCount(dir);
        A = new TreeItem[n];
        int pos = 0;
        for(int i=0; i<fl.length; i++){

            if(!fl[i].isFile()&& !fl[i].isHidden() && fl[i].isDirectory() && n==0)
            {A[pos] =new TreeItem<>(fl[i].getName(), new ImageView(new Image(ClassLoader.getSystemResourceAsStream("img/images.png")))); pos++;}
            else if(!fl[i].isFile()&& !fl[i].isHidden() && fl[i].isDirectory() && n>0){
                A[pos] = new TreeItem<>(fl[i].getName(), new ImageView(new Image (ClassLoader.getSystemResourceAsStream("img/p1.png"))));
                try{
                    A[pos].getChildren().addAll(TreeCreate(fl[i]));pos++;
                }catch(Exception x){
                    System.out.println("Exception x in treecreate at "+fl[i].getAbsolutePath()+" "+x.getMessage());
                }
            }
        }
        return A;
    }

    @Override

    public String FindAbsolutePath(TreeItem<String> item, String s){
        if((item.getParent()==null) || (item.getParent().getValue().equals("This PC"))){ return s;}
        else{
            String dir = item.getParent().getValue();
            dir = dir+"\\"+s;
            return FindAbsolutePath(item.getParent(), dir);
        }
    }


    @Override
    public void CreateTreeView(TreeView<String> treeview) {

    }

    @Override
    public void CreateTableView(TableView<FileInfo> tableview, TableColumn<FileInfo, ImageView> image, TableColumn<FileInfo, String> date, TableColumn<FileInfo, String> name, TableColumn<FileInfo, String> size) {

    }

    @Override
    public void CreateTableView() {

    }

    @Override
    public void CreateTilesView() {

    }

    @Override
    public void Initiate() {

    }

    @Override
    public void setValues(TableView<FileInfo> tableview, TableColumn<FileInfo, ImageView> image, TableColumn<FileInfo, String> date, TableColumn<FileInfo, String> name, TableColumn<FileInfo, String> size) {

    }

    @Override
    public void CreateTiles() {

    }

    @Override
    public int NumOfDirectChilds(File f) {
        return 0;
    }
}

import java.util.ArrayList;
import java.util.List;

// Component interface
interface FileSystemComponent {
    int getSize();
}

// Leaf class representing a file
class File implements FileSystemComponent {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}

// Composite class representing a folder
class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children;

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
}

public class DirectorySizeCalculator {
    public static void main(String[] args) {
        // Create a directory structure
        Folder root = new Folder("Root");
        Folder folder1 = new Folder("Folder 1");
        Folder folder2 = new Folder("Folder 2");
        File file1 = new File("File 1", 100);
        File file2 = new File("File 2", 200);

        folder1.add(file1);
        folder2.add(file2);
        root.add(folder1);
        root.add(folder2);

        // Calculate the size of the root directory
        int directorySize = root.getSize();
        System.out.println("Size of directory: " + directorySize + " bytes");
    }
}

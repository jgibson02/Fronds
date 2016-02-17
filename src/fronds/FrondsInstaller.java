package fronds;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author John Gibson
 */
public class FrondsInstaller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File frondsJar = new File("../dist/Fronds.jar");
        File cRoot = new File("C:/Fronds.jar");
        Path fJarPath = Paths.get("../dist/Fronds.jar");
        if (!frondsJar.exists()) {
            Files.copy(fJarPath, cRoot.toPath());
        }
    }

}

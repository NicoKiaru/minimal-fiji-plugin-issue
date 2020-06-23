package org.debugdemo.debug.ui;

import ij.IJ;
import net.imagej.Dataset;
import org.scijava.command.Command;
import org.scijava.log.LogService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import net.imagej.ImageJ;

@Plugin(type = Command.class, headless = true, menuPath = "Plugins>debug-demo>run-demo")
public class DemoCommand implements Command {

    @Parameter
    public LogService logService;

    @Parameter(label = "Image 1")
    public Dataset inputImage1;

    @Parameter(label = "Image 2")
    public Dataset inputImage2;

    @Override
    public void run() {
        logService.info("First image : "+inputImage1.getName());
        logService.info("Second image : "+inputImage2.getName());
    }

    public static void main(String... args) throws Exception {

        final ImageJ ij = new ImageJ();
        ij.ui().showUI();

        IJ.openImage("src/main/resources/one.png").show();
        IJ.openImage("src/main/resources/two.png").show();

        String scriptTest = "run(\"run-demo\", \"inputimage1=one.png inputimage2=two.png\");";

        ij.script().run("test.ijm",scriptTest,true).get();

    }
}

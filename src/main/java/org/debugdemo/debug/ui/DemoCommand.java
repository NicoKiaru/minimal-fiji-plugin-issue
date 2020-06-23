package org.debugdemo.debug.ui;

import net.imagej.Dataset;
import org.scijava.app.StatusService;
import org.scijava.command.Command;
import org.scijava.log.LogService;
import org.scijava.options.OptionsService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.ui.UIService;
import net.imagej.ImageJ;

@Plugin(type = Command.class, headless = true, menuPath = "Plugins>debug-demo>run-demo")
public class DemoCommand implements Command {

    @Parameter
    public LogService logService;

    @Parameter
    public StatusService statusService;

    @Parameter
    public OptionsService optionsService;

    @Parameter
    public UIService uiService;

    @Parameter(label = "Image 1")
    public Dataset inputImage1;

    @Parameter(label = "Image 2")
    public Dataset inputImage2;

    @Override
    public void run() {
        logService.info("Ran - nothing should happen");
    }

    public static void main(String... args) {
        final ImageJ ij = new ImageJ();
        ij.ui().showUI();
    }
}

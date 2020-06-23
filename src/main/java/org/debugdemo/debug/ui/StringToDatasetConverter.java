package org.debugdemo.debug.ui;

import ij.ImagePlus;
import net.imagej.Dataset;
import org.scijava.Priority;
import org.scijava.convert.AbstractDelegateConverter;
import org.scijava.convert.Converter;
import org.scijava.plugin.Plugin;

@Plugin(type = Converter.class, priority = Priority.VERY_HIGH) // don't exaggerate priorities!
public class StringToDatasetConverter extends
        AbstractDelegateConverter<String, ImagePlus, Dataset>
{

    @Override
    public Class<Dataset> getOutputType() {
        return Dataset.class;
    }

    @Override
    public Class<String> getInputType() {
        return String.class;
    }

    @Override
    protected Class<ImagePlus> getDelegateType() {
        return ImagePlus.class;
    }
}

package org.debugdemo.debug.ui;

import ij.ImagePlus;
import net.imagej.Dataset;
import org.scijava.Priority;
import org.scijava.convert.AbstractConverter;
import org.scijava.convert.ConvertService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

@Plugin(type = org.scijava.convert.Converter.class, priority = Priority.EXTREMELY_HIGH) // priority in order to bypass scifio converter to come...
public class StringToDatasetConverter extends AbstractConverter<String, Dataset> {

    @Parameter
    ConvertService cs;

    @Override
    public <T> T convert(Object src, Class<T> dest) {
        assert src instanceof String;
        String name = (String) src;
        // First conversion : String to ImagePlus
        ImagePlus imagePlus = cs.convert(name, ImagePlus.class);
        if (imagePlus == null) return null;
        // Second convestion : ImagePlus to Dataset
        return (T) cs.convert(imagePlus, Dataset.class);
    }

    @Override
    public Class<Dataset> getOutputType() {
        return Dataset.class;
    }

    @Override
    public Class<String> getInputType() {
        return String.class;
    }
}

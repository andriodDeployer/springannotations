package importbean.select;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * user is lwb
 **/


public class ImportSelectorBean implements ImportSelector {

    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //annotationMetadata是 ImportSelectBean这个类所在@Import修饰的类(也就是ImportApp类)的AnnotationMetadata

        return new String[]{"importbean.select.Red","importbean.select.Yellow"};
    }
}

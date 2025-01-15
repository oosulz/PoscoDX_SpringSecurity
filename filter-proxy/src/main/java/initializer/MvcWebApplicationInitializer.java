package initializer;

import config.WebConfig;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterRegistration.Dynamic;
import jakarta.servlet.ServletContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @NonNull
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new DelegatingFilterProxy("realFilter") };
	}
}
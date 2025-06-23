
package ua.orlov.fintechtransaction.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import ua.orlov.fintechtransaction.model.Category;

import java.util.List;

@Configuration
public class JdbcConfig extends AbstractJdbcConfiguration {

    @Override
    protected List<?> userConverters() {
        return List.of(new CategoryReadConverter(), new CategoryWriteConverter());
    }

    static class CategoryReadConverter implements Converter<String, Category> {
        @Override
        public Category convert(String source) {
            return Category.fromString(source);
        }
    }

    static class CategoryWriteConverter implements Converter<Category, String> {
        @Override
        public String convert(Category source) {
            return source.name();
        }
    }
}

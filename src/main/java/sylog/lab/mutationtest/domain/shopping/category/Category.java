package sylog.lab.mutationtest.domain.shopping.category;

import sylog.lab.mutationtest.domain.Entity;
import sylog.lab.mutationtest.domain.Identifier;
import sylog.lab.mutationtest.domain.util.Validate;

import java.util.Collections;
import java.util.Set;

public final class Category extends Entity {

    private final CategoryName name;
    private final Set<Category> subCategories;

    public Category(Identifier identifier, CategoryName name, Set<Category> subCategories) {
        super(identifier);

        Validate.notNull(name);
        Validate.notNull(subCategories);

        this.name = name;
        this.subCategories = Collections.unmodifiableSet(subCategories);
    }

    public CategoryName getName() {
        return name;
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }
}

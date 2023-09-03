package net.javaguides.springboot.repository;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.QEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, QuerydslPredicateExecutor<Employee>, QuerydslBinderCustomizer<QEmployee> {

    @Override
    default void customize(QuerydslBindings bindings, QEmployee root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.id);
        bindings.including(root.firstName);
        bindings.including(root.lastName);
        bindings.including(root.emailId);
        bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}

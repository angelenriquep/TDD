package com.example.internal.courses.infrastructure;

import com.example.internal.courses.domain.Course;
import com.example.internal.courses.domain.CourseId;
import com.example.internal.courses.domain.CourseRepository;
import com.example.shared.domain.Service;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

// El que hace que se haga el autowire de las dependencias
// como argumentos del constructor
@Service
public class MySqlCourseRepository implements CourseRepository {
    private SessionFactory sessionFactory;

    public MySqlCourseRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Toda query debe ser transaccionel en el hiberante
    // Tema de rollback etc - no try catch no rollback
    // Tengamos en cuenta que estamos generando deuda tecnica
    @Transactional
    @Override
    public void save(Course course) {
        sessionFactory.getCurrentSession().save(course);
    }

    @Override
    public Optional<Course> search(CourseId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().find(Course.class, id));
    }
}

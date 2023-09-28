package com.example.BitBi.repository.abstruction;

import com.example.BitBi.entities.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("spring")
public interface SpringJPABookRepository extends BookRepository, JpaRepository<Book, Long> {


    @Override
    default <S extends Book> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default List<Book> findAll() {
        return null;
    }

    @Override
    default List<Book> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default Book save(Book book) {
        return null;
    }

    @Override
    default void deleteById(Long id) {

    }

    @Override
    default void delete(Book entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends Book> entities) {

    }

    @Override
    default void deleteAll() {

    }



}

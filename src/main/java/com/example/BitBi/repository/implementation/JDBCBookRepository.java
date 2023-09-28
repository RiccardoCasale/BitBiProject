package com.example.BitBi.repository.implementation;

import com.example.BitBi.entities.Book;
import com.example.BitBi.repository.abstruction.BookRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("jdbc")
@Qualifier("JDBC")
public class JDBCBookRepository implements BookRepository {

    // Dichiarazione delle costanti
    public final static String JDBC_URL = "jdbc:mysql://localhost:3306/db_example";
    public final static String JDBC_USER = "root";
    public final static String JDBC_PASSWORD = "";
    public final static String ALL_BOOKS = "SELECT id, titolo, isbn, autore, categoria, genere, nPagine, autoreIllustrazioni, lingua, ddp FROM books";
    public final static String FIND_BOOK_BY_ID = "SELECT id, titolo, isbn, autore, categoria, genere, nPagine, autoreIllustrazioni, lingua, ddp FROM books WHERE id = ?";
    public final static String INSERT_BOOK = "INSERT INTO books(titolo, isbn, autore, categoria, genere, nPagine, autoreIllustrazioni, lingua, ddp ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public final static String DELETE_BOOK = "DELETE FROM books WHERE id = ?";
    public final static String UPDATE_BOOK = "UPDATE books SET titolo = ?, isbn = ?, autore = ?, categoria = ?, genere = ?, nPagine = ?, autoreIllustrazioni = ?, lingua = ?, ddp = ? WHERE id = ?";

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(ALL_BOOKS);
        ) {
            while (resultSet.next()) {
                int id = (int) resultSet.getLong("id");
                String titolo = resultSet.getString("titolo");
                String isbn = resultSet.getString("isbn");
                String autore = resultSet.getString("autore");
                String categoria = resultSet.getString("categoria");
                String genere = resultSet.getString("genere");
                int nPagine = resultSet.getInt("nPagine");
                String autoreIllustrazioni = resultSet.getString("autoreIllustrazioni");
                String lingua = resultSet.getString("lingua");
                Date ddp = resultSet.getDate("ddp");
                boolean hide = resultSet.getBoolean("hide");
                Date dataDiCreazione = resultSet.getDate("dataDiCreazione");
                Date ultimaModifica = resultSet.getDate("ultimaModifica");

                Book book = new Book(id, titolo, isbn, autore, categoria, genere, nPagine, autoreIllustrazioni, lingua, ddp, hide, dataDiCreazione, ultimaModifica);
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> findById(long id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BOOK_BY_ID);
        ) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String titolo = resultSet.getString("titolo");
                    String isbn = resultSet.getString("isbn");
                    String autore = resultSet.getString("autore");
                    String categoria = resultSet.getString("categoria");
                    String genere = resultSet.getString("genere");
                    int nPagine = resultSet.getInt("nPagine");
                    String autoreIllustrazioni = resultSet.getString("autoreIllustrazioni");
                    String lingua = resultSet.getString("lingua");
                    Date ddp = resultSet.getDate("ddp");
                    boolean hide = resultSet.getBoolean("hide");
                    Date dataDiCreazione = resultSet.getDate("dataDiCreazione");
                    Date ultimaModifica = resultSet.getDate("ultimaModifica");

                    Book book = new Book((int) id, titolo, isbn, autore, categoria, genere, nPagine, autoreIllustrazioni, lingua, ddp, hide, dataDiCreazione, ultimaModifica);
                    return Optional.of(book);
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == 0) {
            return create(book);
        }
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK)) {

            preparedStatement.setString(1, book.getTitolo());
            preparedStatement.setString(2, book.getIsbn());
            preparedStatement.setString(3, book.getAutore());
            preparedStatement.setString(4, book.getCategoria());
            preparedStatement.setString(5, book.getGenere());
            preparedStatement.setInt(6, book.getnPagine());
            preparedStatement.setString(7, book.getAutoreIllustrazioni());
            preparedStatement.setString(8, book.getLingua());
            preparedStatement.setDate(9, book.getDdp());
            preparedStatement.setLong(10, book.getId());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Aggiornamento del libro fallito");
            }
            return book;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Book create(Book book) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, book.getTitolo());
            preparedStatement.setString(2, book.getIsbn());
            preparedStatement.setString(3, book.getAutore());
            preparedStatement.setString(4, book.getCategoria());
            preparedStatement.setString(5, book.getGenere());
            preparedStatement.setInt(6, book.getnPagine());
            preparedStatement.setString(7, book.getAutoreIllustrazioni());
            preparedStatement.setString(8, book.getLingua());
            preparedStatement.setDate(9, book.getDdp());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creazione del libro fallita");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);
                    book.setId((int) id);
                    return book;
                } else {
                    throw new SQLException("Creazione del libro fallita, nessun ID generato");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK)) {
            preparedStatement.setLong(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Cancellazione del libro fallita");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

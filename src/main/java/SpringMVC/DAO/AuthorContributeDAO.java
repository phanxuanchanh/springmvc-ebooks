package SpringMVC.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SpringMVC.Entity.AuthorContribute;
import SpringMVC.Entity.AuthorContributeMapper;

@Repository
public class AuthorContributeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<AuthorContribute> GetAuthorContributesByBookAuthorId(long bookAuthorId) {
		List<AuthorContribute> authorContributes = new ArrayList<AuthorContribute>();
		String query = "Select * from AuthorContribute where bookAuthorId = ?";
		authorContributes = jdbcTemplate.query(query, new Object[] { bookAuthorId }, new AuthorContributeMapper());
		return authorContributes;
	}

	public List<AuthorContribute> GetAuthorContributesByBookId(long bookId) {
		List<AuthorContribute> authorContributes = new ArrayList<AuthorContribute>();
		String query = "Select * from AuthorContribute where bookId = ?";
		authorContributes = jdbcTemplate.query(query, new Object[] { bookId }, new AuthorContributeMapper());
		return authorContributes;
	}

	public AuthorContribute GetAuthorContribute(long bookAuthorId, long bookId) {
		AuthorContribute authorContribute = null;
		String query = "Select * from AuthorContribute where bookAuthorId = ? and bookId = ?";
		authorContribute = jdbcTemplate.queryForObject(query, new Object[] { bookAuthorId, bookId },
				new AuthorContributeMapper());
		return authorContribute;
	}

	public boolean CreateAuthorContribute(AuthorContribute authorContribute) {
		String query = "Insert into AuthorContribute(bookAuthorId, bookId, role) values(?, ?, ?)";
		int affected = jdbcTemplate.update(query, new Object[] { authorContribute.getBookAuthorId(),
				authorContribute.getBookId(), authorContribute.getRole() });
		return (affected > 0);
	}

	public boolean UpdateAuthorContribute(AuthorContribute authorContribute) {
		String query = "Update AuthorContribute set role = ? where bookAuthoId = ? and bookId = ?";
		int affected = jdbcTemplate.update(query, new Object[] { authorContribute.getRole(),
				authorContribute.getBookAuthorId(), authorContribute.getBookId() });
		return (affected > 0);
	}

	public boolean DeleteAuthorContribute(long bookAuthorId, long bookId) {
		String query = "Delete from AuthorContribute where bookAuthorId = ? and bookId = ?";
		int affected = jdbcTemplate.update(query, new Object[] { bookAuthorId, bookId });
		return (affected > 0);
	}
	
	public boolean DeleteAuthorContribute(long bookId) {
		String query = "Delete from AuthorContribute where bookId = ?";
		int affected = jdbcTemplate.update(query, new Object[] { bookId });
		return (affected > 0);
	}

	public int CountAuthorContribute() {
		String query = "Select count(*) from AuthorContribute";
		int count = jdbcTemplate.queryForObject(query, Integer.class);
		return count;
	}

	public boolean IsExistAuthorContribute(long bookAuthorId, long bookId) {
		String query = "Select count(*) from AuthorContribute where bookAuthorId = ? and bookId = ?";
		int count = jdbcTemplate.queryForObject(query, new Object[] { bookAuthorId, bookId }, Integer.class);
		return (count > 0);
	}
	
	public boolean IsExistAuthorContributeByBookId(long bookId) {
		String query = "Select count(*) from AuthorContribute where bookId = ?";
		int count = jdbcTemplate.queryForObject(query, new Object[] { bookId }, Integer.class);
		return (count > 0);
	}
	
	public boolean IsExistAuthorContributeByBookAuthorId(long bookAuthorId) {
		String query = "Select count(*) from AuthorContribute where bookAuthorId = ?";
		int count = jdbcTemplate.queryForObject(query, new Object[] { bookAuthorId }, Integer.class);
		return (count > 0);
	}
}
